package vn.fpoly.java5.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Category")
public class Category {
    @Id
    @Column(name="id")
    private String id;

    @Column(name = "Name")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
