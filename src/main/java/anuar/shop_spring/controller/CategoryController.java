package anuar.shop_spring.controller;

import anuar.shop_spring.entity.*;
import anuar.shop_spring.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping(path = "/categories")
    public String showAllCategories(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "categories";
    }

    @GetMapping(path = "/category-create")
    public String createCategoryForm(Category category, Model model) {
        model.addAttribute("category", category);
        return "category-create";
    }

    @PostMapping(path = "/category-create")
    public String createCategory(Category category) {
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }

    @GetMapping(path = "/category-delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategoryById(id);
        return "redirect:/categories";
    }

    @GetMapping(path = "/category-update/{id}")
    public String updateCategoryForm(@PathVariable("id") Long id, Model model) {
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category", category);
        return "category-update";
    }

    @PostMapping(path = "/category-update")
    public String updateCategory(Category category) {
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }
}
