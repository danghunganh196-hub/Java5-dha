package vn.fpoly.java5.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "Account")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column(name="Username")
    private String username;
    @Column(name="Password")
    private String password;
    @Column(name="Fullname")
    private String fullname;
    @Column(name = "Email")
    private String email;
    @Column(name="Photo")
    private String photo;
    @Column(name="Activated")
    private Boolean activated;
    @Column(name = "Admin")
    private Boolean admin;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;
}
