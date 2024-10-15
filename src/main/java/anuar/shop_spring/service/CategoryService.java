package anuar.shop_spring.service;

import anuar.shop_spring.entity.Category;
import anuar.shop_spring.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        categories.addAll(categoryRepository.getAllCategories());
        return categories;
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(null);
    }

    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }
}
