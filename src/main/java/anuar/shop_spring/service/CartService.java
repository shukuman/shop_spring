package anuar.shop_spring.service;

import anuar.shop_spring.entity.Cart;
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

    public List<Cart> getAllCarts() {
        return cartRepository.getAllCarts();
    }

    public void addProductToCart(Cart cart) {
        cartRepository.save(cart);
    }

    public double calculateTotal () {
        double total = 0.0;
        for (Cart cart : cartRepository.getAllCarts()) {
            total += cart.getProduct().getPrice() * cart.getCount();
        }
        return total;
    }
}
