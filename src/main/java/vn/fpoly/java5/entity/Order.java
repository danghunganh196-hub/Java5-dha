package vn.fpoly.java5.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Username",nullable = false)
    private User user;

    @Column(name = "CreateDate")
    private LocalDate createDate;

    @Column(name = "Address")
    private String address;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;
}
