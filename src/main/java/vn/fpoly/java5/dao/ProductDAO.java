package vn.fpoly.java5.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    //Truy vấn với tham số
//    @Query(value = "SELECT p FROM Product p WHERE p.quantity BETWEEN ?1 AND ?2")
//    List<Product> findByQuantity(int min,int max);

    //Truy vấn với tham số truyền theo parameter
    @Query(value = "SELECT p FROM Product p WHERE p.quantity BETWEEN :min AND :max")
    List<Product> findByQuantity(@Param("min") int min, @Param("max") int max);

//    @Query(name="findByCategory")
//    List<Product> findByCategory(String categoryId);
}
