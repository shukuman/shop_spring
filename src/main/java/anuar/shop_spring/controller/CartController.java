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

    @GetMapping(path = "/cart")
    public String getAllCarts(Model model) {
        List<Cart> carts = cartService.getAllCarts();
        model.addAttribute("carts", carts);

        Double total = cartService.calculateTotal();
        model.addAttribute("total", total);
        return "cart";
    }

    @GetMapping(path = "/addProductForm/{id}")
    public String addProductToCartForm(@PathVariable("id") Long id, Model model) {
        Cart cart = new Cart();
        model.addAttribute("cart", cart);

        Product product = productService.getProductById(id);
        cart.setProduct(product);
        model.addAttribute("product", product);

        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);

        return "addProductToCart";
    }

    @PostMapping(path = "/addProduct")
    public String addProductToCart(Cart cart) {
        cartService.addProductToCart(cart);
        return "redirect:/cart";
    }

    @GetMapping("/cart/increase/{id}")
    public String increaseProductQuantity(@PathVariable("id") Long productId) {
        cartService.increaseProductQuantity(productId);
        return "redirect:/cart";
    }

    @GetMapping("/cart/decrease/{id}")
    public String decreaseProductQuantity(@PathVariable("id") Long productId) {
        cartService.decreaseProductQuantity(productId);
        return "redirect:/cart";
    }
}
