package vn.fpoly.java5.utility;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.fpoly.java5.entity.CartItem;
import java.util.List;

public interface CartService {
    CartItem add(Integer id);
    CartItem get(Integer id);
    CartItem update(Integer id, Integer quantity);
    CartItem remove(Integer id);
    void clear();
    List<CartItem> getAll();
    Integer getQuantity();
    Double getTotalAmount();
}
