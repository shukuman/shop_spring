package anuar.shop_spring.controller;

import anuar.shop_spring.entity.Category;
import anuar.shop_spring.entity.Product;
import anuar.shop_spring.entity.Review;
import anuar.shop_spring.service.CartService;
import anuar.shop_spring.service.CategoryService;
import anuar.shop_spring.service.ProductService;
import anuar.shop_spring.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class ProductController {

    private final ProductService productService;

    private final ReviewService reviewService;

    private final CartService cartService;

    private final CategoryService categoryService;

    @GetMapping(path = "/products")
    public String showAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping(path = "/products/{id}")
    public String showProduct(@PathVariable("id") Long id, Model model) {
        Product productByID = productService.getProductById(id);
        model.addAttribute("productById", productByID);

        BigDecimal averageRating = productService.getAverageRating(productByID, true);
        model.addAttribute("average", averageRating);

        List<Review> reviewsByProductIdAndStatus = reviewService.getAllReviewsByStatus(id, true);
        model.addAttribute("reviewsByProductIdAndStatus", reviewsByProductIdAndStatus);

        return "product-info";
    }

    @GetMapping(path = "/product-create")
    public String createProductForm(Product product, Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("product", product);
        return "product-create";
    }

    @PostMapping(path = "/product-create")
    public String createProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping(path = "/product-delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
        return "redirect:/products";
    }

    @GetMapping(path = "/product-update/{id}")
    public String updateProductForm(@PathVariable("id") Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product-update";
    }

    @PostMapping(path = "/product-update")
    public String updateProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping(path = "/products-list")
    public String showProductsList(@RequestParam(defaultValue = "1") int page, Model model) {
        List<Product> products = productService.getAllProducts();

        int pageSize = 10;
        int totalProducts = products.size();
        int totalPages = (int) Math.ceil((double) totalProducts / pageSize);

        model.addAttribute("products", products);
        model.addAttribute("page", page);
        model.addAttribute("totalPages", totalPages);

        return "products-list";
    }
}
