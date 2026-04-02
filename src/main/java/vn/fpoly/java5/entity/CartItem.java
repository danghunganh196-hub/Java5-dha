package vn.fpoly.java5.entity;

import lombok.*;

@Getter@Setter@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItem {
    Integer id;
    String name;
    Double price;
    @Builder.Default
    Integer quantity = 1;

    public Double getTotalAmount(){
        return this.price * quantity;
    }
}
