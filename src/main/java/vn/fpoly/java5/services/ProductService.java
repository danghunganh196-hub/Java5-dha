package vn.fpoly.java5.services;

import org.springframework.stereotype.Service;
import vn.fpoly.java5.dao.ProductDAO;
import vn.fpoly.java5.entity.Product;

import java.util.List;

@Service
public class ProductService {
    private ProductDAO productDAO;
    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> getByPrice(){
        return productDAO.findByPrice();
    }

    public List<Product> getByName(){
        return productDAO.findByName();
    }

    public List<Product> getByQuantity(int min, int max){
        return productDAO.findByQuantity(min,max);
    }
}
