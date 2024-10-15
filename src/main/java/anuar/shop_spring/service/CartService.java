package anuar.shop_spring.service;

import anuar.shop_spring.entity.Cart;
import anuar.shop_spring.entity.Product;
import anuar.shop_spring.entity.User;
import anuar.shop_spring.repository.CartRepository;
import anuar.shop_spring.repository.ProductRepository;
import anuar.shop_spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public void addProductToCart(Cart cart, Product product, User user) {
        cart.setProduct(product);
        cart.setUser(user);
        cartRepository.save(cart);
    }
}
