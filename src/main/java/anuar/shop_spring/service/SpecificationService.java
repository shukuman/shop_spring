package anuar.shop_spring.service;

import anuar.shop_spring.entity.Category;
import anuar.shop_spring.entity.Specification;
import anuar.shop_spring.repository.CategoryRepository;
import anuar.shop_spring.repository.SpecificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecificationService {

    private final SpecificationRepository specificationRepository;
    private final CategoryRepository categoryRepository;

    public List<Specification> getAllSpecifications() {
        return specificationRepository.getAllSpecifications();
    }

    public Specification getSpecificationById(Long id) {
        return specificationRepository.getSpecificationById(id);
    }

    public void saveSpecification(Specification specification) {
        specificationRepository.save(specification);
    }

    public void deleteSpecificationById(Long id) {
        specificationRepository.deleteById(id);
    }

    public void addSpecToCategory(Long categoryId, Long specId) {
        Category category = categoryRepository.getCategoryById(categoryId);
        Specification specification = specificationRepository.getSpecificationById(specId);
        specification.setCategory(category);
        specificationRepository.save(specification);
    }

    public List<Specification> getSpecificationsByCategoryId(Long categoryId) {
        return specificationRepository.getSpecificationsByCategoryId(categoryId);
    }
}
