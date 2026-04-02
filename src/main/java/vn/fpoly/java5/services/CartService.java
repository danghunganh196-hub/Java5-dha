package vn.fpoly.java5.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CartService implements vn.fpoly.java5.utility.CartService {

    private final CookieService cookieService;

    public CartService(CookieService cookieService) {
        this.cookieService = cookieService;
    }

    // cart format: "id1:qty1,id2:qty2"
    private Map<String, Integer> getCart(HttpServletRequest request) {
        Map<String, Integer> cart = new HashMap<>();
        String cartStr = cookieService.getCookie("cart", request);
        if (cartStr != null && !cartStr.isEmpty()) {
            for (String item : cartStr.split(",")) {
                String[] parts = item.split(":");
                if (parts.length == 2) {
                    cart.put(parts[0], Integer.parseInt(parts[1]));
                }
            }
        }
        return cart;
    }

    private void saveCart(Map<String, Integer> cart, HttpServletRequest request, HttpServletResponse response) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            if (sb.length() > 0) sb.append(",");
            sb.append(entry.getKey()).append(":").append(entry.getValue());
        }
        response.addCookie(cookieService.createCookie("cart", sb.toString(), 60 * 60 * 24));
    }

    @Override
    public void addToCart(String productId, Integer quantity, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Integer> cart = getCart(request);
        cart.put(productId, cart.getOrDefault(productId, 0) + quantity);
        saveCart(cart, request, response);
    }

    @Override
    public void removeFromCart(String productId, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Integer> cart = getCart(request);
        cart.remove(productId);
        saveCart(cart, request, response);
    }

    @Override
    public int getCartCount(HttpServletRequest request) {
        return getCart(request).values().stream().mapToInt(Integer::intValue).sum();
    }
}