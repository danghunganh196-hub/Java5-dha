package vn.fpoly.java5.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.fpoly.java5.dao.CategoryDAO;
import vn.fpoly.java5.entity.Category;
import vn.fpoly.java5.services.CategoryService;

@Controller
@RequestMapping("/webshop/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/index")
    public String handleIndex(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("category", new Category());
        return "webshop/category/index";
    }

    @PostMapping("/create")
    public String handleCreate(@ModelAttribute("category") Category category,
                               Model model) {
        if (!categoryService.categoryIdExist(category.getId())) {
            categoryService.save(category);
        }
        return "redirect:/webshop/category/index";
    }

    @PostMapping("/update")
    public String handleUpdate(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        return "redirect:/webshop/category/index";
    }
    @GetMapping("/edit/{id}")
    public String handleEdit(@PathVariable("id") String id, Model model) {
        Category category = categoryService.getById(id).orElse(null);
        model.addAttribute("category", category);
        model.addAttribute("categories", categoryService.getAll());
        return "webshop/category/index";
    }
    @GetMapping("/delete/{id}")
    public String handleDelete(@PathVariable("id") String id) {
        if(categoryService.categoryIdExist(id)) {
            categoryService.delete(id);
        }
        return "redirect:/webshop/category/index";
    }
    @GetMapping("/paging")
    public String handlePaging(Model model, @RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "2") int size,
                               @RequestParam(defaultValue = "id") String sortBy,
                               @RequestParam(defaultValue = "asc") String sortDir
                               ) {
        Page<Category> categories = categoryService.getByPage(page,size,sortBy,sortDir);
        model.addAttribute("categories", categories);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", categories.getTotalPages());
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("sortDir", sortDir);

        model.addAttribute("reverseDir",sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("category", new Category());

        return "webshop/category/paging";
    }
}
