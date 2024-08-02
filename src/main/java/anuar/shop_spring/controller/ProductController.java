package anuar.shop_spring.controller;

import anuar.shop_spring.entity.Product;
import anuar.shop_spring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String showProducts(Model model) {
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("products", productList);
        return "products";
    }
}
