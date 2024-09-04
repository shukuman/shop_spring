package anuar.shop_spring.controller;

import anuar.shop_spring.entity.Review;
import anuar.shop_spring.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping(path = "/reviews")
    public String showAllReviews(Model model) {
        List<Review> reviews = reviewService.getAllReviews();
        model.addAttribute("reviews", reviews);
        return "reviews";
    }

    @GetMapping(path = "/review-create")
    public String createReviewForm(Review review, Model model) {
        model.addAttribute("review", review);
        return "review-create";
    }

    @PostMapping(path = "/review-create")
    public String createReview(Review review) {
        reviewService.saveReview(review);
        return "redirect:/reviews";
    }

    @GetMapping(path = "/review-delete/{id}")
    public String deleteReview(@PathVariable("id") Long id) {
        reviewService.deleteReviewById(id);
        return "redirect:/reviews";
    }

    @GetMapping(path = "/review-update/{id}")
    public String updateReviewForm(@PathVariable("id") Long id, Model model) {
        Review review = reviewService.getReviewById(id);
        model.addAttribute("review", review);
        return "review-update";
    }

    @PostMapping(path = "/review-update")
    public String updateReview(Review review) {
        reviewService.saveReview(review);
        return "redirect:/reviews";
    }
}
