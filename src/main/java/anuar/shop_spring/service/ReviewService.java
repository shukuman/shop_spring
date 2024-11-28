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
        return reviewRepository.findAll();
    }

    public List<Review> getAllReviewsByStatus(Long id, Boolean status) {
        return reviewRepository.getReviewsByProductIdAndStatus(id, status);
    }

    public List<Review> getAllReviewsByProductId(Long id) {
        return reviewRepository.getReviewsByProductId(id);
    }

    public Review getReviewById(Long id) {
        return reviewRepository.getReviewById(id);
    }

    public void setReviewStatus(Long id, boolean status) {
        Review review = reviewRepository.getReviewById(id);
        review.setStatus(status);
        reviewRepository.save(review);
    }

    public void saveReview(Review review) {
        reviewRepository.save(review);
    }

    public void deleteReviewById(Long id) {
        reviewRepository.deleteById(id);
    }
}