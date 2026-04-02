package vn.fpoly.java5.utility;

import org.springframework.stereotype.Service;
import vn.fpoly.java5.entity.CartItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("cartService")
public class CartServiceImpl implements CartService {
    private final Map<Integer, CartItem> cart = new HashMap<Integer, CartItem>();

    @Override
    public CartItem add(Integer id){
        CartItem item = cart.get(id);
        if(item == null){
            item = CartItem.builder().
                    id(id)
            .build();
            cart.put(id, item);
        }
        else{
            item.setQuantity(item.getQuantity() + 1);
        }
        return item;
    };
    @Override
    public CartItem get(Integer id){
        return cart.get(id);
    };
    @Override
    public CartItem update(Integer id, Integer quantity){
        CartItem item = cart.get(id);
        if(item != null){
            if(quantity < 0){
                cart.remove(id);
            }
            else{
                item.setQuantity(quantity);
            }
        }
        return item;
    };
    @Override
    public CartItem remove(Integer id){
        return cart.remove(id);
    };
    @Override
    public void clear(){
        cart.clear();
    };
    @Override
    public List<CartItem> getAll(){
        return new ArrayList<>(cart.values());
    };
    @Override
    public Integer getQuantity(){
        int quantity = 0;
        for(CartItem item : cart.values()){
            quantity += item.getQuantity();
        }
        return quantity;
    };
    @Override
    public Double getTotalAmount(){
        double total = 0.0;
        for(CartItem item : cart.values()){
            total += item.getQuantity() * item.getPrice();
        }
        return total;
    };
}
