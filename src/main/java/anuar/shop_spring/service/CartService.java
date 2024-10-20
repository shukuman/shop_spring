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

    public Cart getCartById(Long id) {
        return cartRepository.findById(id).orElseThrow(null);
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

    public void increaseProductQuantity(Long productId) {
        Cart cart = cartRepository.findByProductId(productId);
        if (cart != null) {
            cart.setCount(cart.getCount() + 1);
            cartRepository.save(cart);
        }
    }

    public void decreaseProductQuantity(Long productId) {
        Cart cart = cartRepository.findByProductId(productId);
        if (cart != null) {
            int currentQuantity = cart.getCount();
            if (currentQuantity > 1) {
                cart.setCount(currentQuantity - 1);
                cartRepository.save(cart);
            } else {
                cartRepository.delete(cart);
            }
        }
    }
}
