package anuar.shop_spring.repository;

import anuar.shop_spring.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("select c from Cart c order by c.user.id")
    List<Cart> getAllCarts();

    @Query("select c from Cart c where c.id = :cartId")
    Cart getCartById(@Param("cartId") Long cartId);

    Cart findByProductId(Long productId);
}
