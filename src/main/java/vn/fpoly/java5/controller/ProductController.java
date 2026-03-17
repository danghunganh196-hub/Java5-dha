package vn.fpoly.java5.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    @GetMapping("/order")
    public String order() {
        return "product/order";
    }
    @PostMapping("/order")
        public String createOrder(@RequestParam String id, @RequestParam int quantity, HttpServletResponse response, Model model) {
        String cart = id + " : " + quantity;
        Cookie cookie = new Cookie("cart", cart);
        cookie.setPath("/");
        cookie.setMaxAge(60*60*24);
        response.addCookie(cookie);
        return "redirect:/cart";
    }
    @GetMapping("/cart")
    public String showCart(@CookieValue(value = "cart",required = false) String cart, Model model) {
        if(cart != null){
            String[] data = cart.split("i");
            model.addAttribute("id",data[0]);
            model.addAttribute("quantity",Integer.parseInt(data[1]));
        }
        return "product/cart";
    }
}
