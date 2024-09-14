package anuar.shop_spring.controller;

import anuar.shop_spring.entity.Product;
import anuar.shop_spring.entity.Review;
import anuar.shop_spring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class ProductController {

    private final ProductService productService;

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

        BigDecimal averageRating = productService.getAverageRating(productByID);
        model.addAttribute("average", averageRating);
        return "product-info";
    }

    @GetMapping(path = "/product-create")
    public String createProductForm(Product product, Model model) {
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
}
