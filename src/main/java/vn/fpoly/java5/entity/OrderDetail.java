package vn.fpoly.java5.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "OrderDetail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "OrderId",nullable = false)
    private Order order;
    @ManyToOne
    @JoinColumn(name = "ProductId",nullable = false)
    private Product product;

    @Column(name = "Price")
    private Double price;

    @Column(name = "Quantity")
    private Integer quantity;
}
