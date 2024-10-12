package anuar.shop_spring.controller;

import anuar.shop_spring.entity.Cart;
import anuar.shop_spring.entity.Product;
import anuar.shop_spring.service.CartService;
import anuar.shop_spring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class CartController {

    private final CartService cartService;
    private final ProductService productService;

    @GetMapping(path = "/addProductForm/{id}")
    public String addProductToCartForm(@PathVariable("id") Long id, Cart cart, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("cart", cart);
        model.addAttribute("product", product);
        return "addProductToCart";
    }

    @PostMapping(path = "/addProduct")
    public String addProductToCart(Cart cart) {
        cartService.addProductToCart(cart);
        return "redirect:/products-list";
    }
}
