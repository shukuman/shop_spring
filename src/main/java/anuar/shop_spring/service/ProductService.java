package anuar.shop_spring.service;

import anuar.shop_spring.entity.Product;
import anuar.shop_spring.entity.Review;
import anuar.shop_spring.repository.ProductRepository;
import anuar.shop_spring.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ReviewRepository reviewRepository;

    public List<Product> getProducts() {
        return productRepository.getAllProducts();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(null);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public BigDecimal getAverageRating(Product product, Long id, Boolean status) {
        try {
            Double rating = 0.0;
            int count = 0;
            for(Review r : reviewRepository.getReviewsByProductIdAndStatus(id, status)) {
                rating += r.getAssessment();
                count++;
            }
            BigDecimal averageRating = BigDecimal.valueOf(rating/count);
            return averageRating.setScale(2, RoundingMode.HALF_UP);
        } catch (Exception e) {
            return null;
        }
    }
}
