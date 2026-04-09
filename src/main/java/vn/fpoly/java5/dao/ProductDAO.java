package vn.fpoly.java5.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.fpoly.java5.entity.Product;

import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {
    //Tìm kiế các sản phẩm có giá trong khoảng 10.000.000 đến 20.000.000
    @Query(value = "SELECT p FROM Product p WHERE p.price BETWEEN 10000000 AND 20000000")
    List<Product> findByPrice();

    //Truy vấn theo dạng thức SQL thuần (Native Query)
    @Query(value = "SELECT * FROM Product WHERE Name LIKE '%Mac%' ",nativeQuery = true )
    List<Product> findByName();
}
