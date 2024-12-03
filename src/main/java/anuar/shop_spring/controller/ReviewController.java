package anuar.shop_spring.controller;

import anuar.shop_spring.entity.Product;
import anuar.shop_spring.entity.Review;
import anuar.shop_spring.entity.User;
import anuar.shop_spring.service.ProductService;
import anuar.shop_spring.service.ReviewService;
import anuar.shop_spring.service.UserService;
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
    private final ProductService productService;
    private final UserService userService;

    @GetMapping(path = "/reviews")
    public String showAllReviews(Model model) {
        List<Review> reviews = reviewService.getAllReviews();
        model.addAttribute("reviews", reviews);
        return "reviews";
    }

    @GetMapping(path = "/reviewsByProductId/{id}")
    public String showReviewsByProductId(@PathVariable("id") Long productId, Model model) {
        Product productByID = productService.getProductById(productId);
        List<Review> reviewsByProductId = reviewService.getAllReviewsByProductId(productId);

        model.addAttribute("productById", productByID);
        model.addAttribute("reviewsByProductId", reviewsByProductId);
        return "reviewsByProductId";
    }

    @GetMapping(path = "/review-create/{id}")
    public String createReviewForm(@PathVariable("id") Long productId, Model model) {
        Review review = new Review();
        model.addAttribute("review", review);

        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);

        Product product = productService.getProductById(productId);
        review.setProduct(product);

        return "review-create";
    }

    @PostMapping(path = "/review-create")
    public String createReview(Review review) {
        Long productId = review.getProduct().getId();
        Long userId = review.getUser().getId();

        boolean reviewExists = reviewService.reviewExistsByProductAndUser(productId, userId);
        if(reviewExists) {
            return "error";
        }
        reviewService.saveReview(review);

        return "redirect:/reviewsByProductId/" + productId;
    }

    @GetMapping(path = "/review-delete/{id}")
    public String deleteReview(@PathVariable("id") Long id,
                               @RequestParam("productId") Long productId) {
        reviewService.deleteReviewById(id);
        return "redirect:/reviewsByProductId/" + productId;
    }

    @GetMapping(path = "/review-status/{id}")
    public String setReviewStatus(@PathVariable("id") Long reviewId,
                                  @RequestParam("productId") Long productId,
                                  @RequestParam("status") boolean status) {
        reviewService.setReviewStatus(reviewId, status);
        return "redirect:/reviewsByProductId/" + productId;
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
