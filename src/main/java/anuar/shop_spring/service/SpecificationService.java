package anuar.shop_spring.service;

import anuar.shop_spring.entity.Specification;
import anuar.shop_spring.repository.SpecificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecificationService {

    private final SpecificationRepository specificationRepository;

    public List<Specification> getAllSpecifications() {
        List<Specification> specifications = new ArrayList<>();
        specifications.addAll(specificationRepository.findAll());
        return specifications;
    }

    public Specification getSpecificationById(Long id) {
        return specificationRepository.findById(id).orElseThrow(null);
    }

    public void saveSpecification(Specification specification) {
        specificationRepository.save(specification);
    }

    public void deleteSpecificationById(Long id) {
        specificationRepository.deleteById(id);
    }
}
