package vn.fpoly.java5.utility;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface CartService {
    void addToCart(String productId, Integer quantity, HttpServletRequest request, HttpServletResponse response);
    void removeFromCart(String productId, HttpServletRequest request, HttpServletResponse response);
    int getCartCount(HttpServletRequest request);
}
