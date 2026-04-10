package vn.fpoly.java5.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.fpoly.java5.dao.CategoryDAO;
import vn.fpoly.java5.entity.Category;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryDAO categoryDAO;

    public CategoryService(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public List<Category> getAll() {
        return categoryDAO.findAll();
    }

    public Boolean categoryIdExist(String id) {
        return categoryDAO.existsById(id);
    }

    public void save(Category category) {
        categoryDAO.save(category);
    }

    public Optional<Category> getById(String id) {
        return categoryDAO.findById(id);
    }

    public void delete(String id) {
        categoryDAO.deleteById(id);
    }

    public Page<Category> getByPage(int page, int size, String sortBy, String sortDir) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDir), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        return categoryDAO.findAll(pageable);
    }
}
