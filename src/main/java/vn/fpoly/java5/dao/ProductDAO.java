package vn.fpoly.java5.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.fpoly.java5.entity.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {
}
