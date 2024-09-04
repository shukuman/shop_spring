package anuar.shop_spring.service;

import anuar.shop_spring.entity.Review;
import anuar.shop_spring.entity.Specification;
import anuar.shop_spring.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        List<Review> reviews = new ArrayList<>();
        reviews.addAll(reviewRepository.findAll());
        return reviews;
    }

    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElseThrow(null);
    }

    public void saveReview(Review review) {
        reviewRepository.save(review);
    }

    public void deleteReviewById(Long id) {
        reviewRepository.deleteById(id);
    }
}