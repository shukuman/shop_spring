package anuar.shop_spring.repository;

import anuar.shop_spring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository <Product, Long> {

    @Query("select p from Product p order by p.id")
    List<Product> getAllProducts();
}
