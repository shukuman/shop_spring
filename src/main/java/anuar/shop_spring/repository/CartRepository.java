package anuar.shop_spring.repository;

import anuar.shop_spring.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("select c from Cart c order by c.id")
    List<Cart> getAllCarts();
}
