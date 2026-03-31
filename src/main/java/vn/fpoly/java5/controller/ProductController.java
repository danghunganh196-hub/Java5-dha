package vn.fpoly.java5.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.fpoly.java5.utility.CookieService;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    CookieService cookieService;

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
        public String createOrder(@RequestParam String id, @RequestParam int quantity, HttpServletResponse response, Model model) {
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
}
