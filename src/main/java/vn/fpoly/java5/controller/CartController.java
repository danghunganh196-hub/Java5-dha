package vn.fpoly.java5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.fpoly.java5.entity.CartItem;
import vn.fpoly.java5.utility.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cartService.getAll());
        model.addAttribute("totalQuantity", cartService.getQuantity());
        model.addAttribute("totalAmount", cartService.getTotalAmount());
        return "cart/index";
    }

    @PostMapping("/add/{id}")
    public String addItem(@PathVariable Integer id) {
        cartService.add(id);
        return "redirect:/cart";
    }

    @PostMapping("/update/{id}")
    public String updateItem(@PathVariable Integer id,
                             @RequestParam Integer quantity) {
        cartService.update(id, quantity);
        return "redirect:/cart";
    }

    @PostMapping("/remove/{id}")
    public String removeItem(@PathVariable Integer id) {
        cartService.remove(id);
        return "redirect:/cart";
    }

    @PostMapping("/clear")
    public String clearCart() {
        cartService.clear();
        return "redirect:/cart";
    }
}
