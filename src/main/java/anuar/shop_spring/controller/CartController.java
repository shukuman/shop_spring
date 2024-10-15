package anuar.shop_spring.controller;

import anuar.shop_spring.entity.Cart;
import anuar.shop_spring.entity.Product;
import anuar.shop_spring.entity.User;
import anuar.shop_spring.service.CartService;
import anuar.shop_spring.service.ProductService;
import anuar.shop_spring.service.UserService;
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
    private final UserService userService;

    @GetMapping(path = "/addProductForm/{id}")
    public String addProductToCartForm(@PathVariable("id") Long id, Cart cart, Model model) {
        Product product = productService.getProductById(id);
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("product", product);
        model.addAttribute("cart", cart);
        return "addProductToCart";
    }

    @PostMapping(path = "/addProduct")
    public String addProductToCart(Cart cart, Product product, User user) {
        cartService.addProductToCart(cart, product, user);
        return "redirect:/products-list";
    }
}
