package vn.fpoly.java5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.fpoly.java5.dao.CategoryDAO;

@Controller
@RequestMapping("/webshop/category")
public class CategoryController {
    private final CategoryDAO categoryDAO;

    public CategoryController(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @GetMapping("/index")
    public String handleIndex(Model model) {
        model.addAttribute("categories", categoryDAO.findAll());
        return "webshop/category/index";
    }

}
