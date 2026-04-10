package vn.fpoly.java5.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.fpoly.java5.entity.Product;
import vn.fpoly.java5.services.ProductService;
import vn.fpoly.java5.utility.CookieService;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {
    ProductService productService;

    // BEAN INJECTION: 3 CACHs

//    @Autowired
//    @Qualifier("CookieService1")
    CookieService cookieService;

    // NEN DUNG CONSTRUCTOR INJECTION

    public ProductController(@Qualifier("cookieService") CookieService cookieService, ProductService productService) {
        this.cookieService = cookieService;
        this.productService = productService;
    }


    @GetMapping("/index/{size}/{page}")
    public String getAll(@PathVariable("size") int size, @PathVariable("page") int page) {
        System.out.println("page size: "+size);
        System.out.println("page number: "+page);
        return "product/index";
    }

    @GetMapping("/order")
    public String order() {
        return "product/order";
    }
    @PostMapping("/order")
        public String createOrder(
//                        @Autowired @Qualifier CookieService cookieService,
                                    @RequestParam String id,
                                  @RequestParam int quantity,
                                  HttpServletResponse response,
                                  Model model) {

        String cart = id + ":" + quantity;
         cookieService.createCookie("cart",cart,60*60*24);
        response.addCookie(new Cookie("cart",cart));
        return "redirect:/product/cart";
    }
    @GetMapping("/cart")
    public String showCart(@CookieValue(value = "cart",required = false) String cart, Model model) {
        if(cart != null){
            String[] data = cart.split(":");
            model.addAttribute("id",data[0]);
            model.addAttribute("quantity",Integer.parseInt(data[1]));
        }
        return "product/cart";
    }
    @GetMapping("/list")
    public String productList(Model model) {
    Map<String,String> categories = new LinkedHashMap<>();
    categories.put("1","Điện thoại");
    categories.put("2","Laptop");
    categories.put("3","Phụ kiện");
    model.addAttribute("categories",categories);
    model.addAttribute("selectedCatId","1");
    return "product/list";
    }
    @GetMapping("/filter-by-price")
    public String filterByPrice(Model model) {
        List<Product> productList = productService.getByPrice();
        model.addAttribute("productList",productList);
        return "product/filter";
    }
    @GetMapping("/filter-by-name")
    public String filterByName(Model model) {
        List<Product> productList = productService.getByName();
        model.addAttribute("productList",productList);
        return "product/filter";
    }
    @GetMapping("/filter-by-quantity")
    public String filterByQuantity(@RequestParam (value = "min",required = false) Integer min,
                                   @RequestParam (value = "max",required = false) Integer max,
                                   Model model) {
        if(min == null){
            min = 0;
        }
        if(max == null){
            max = 1000;
        }
        List<Product> productList = productService.getByQuantity(min,max);
        model.addAttribute("productList",productList);
        return "product/filter";
    }
}
