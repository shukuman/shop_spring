package anuar.shop_spring.repository;

import anuar.shop_spring.entity.Category;
import anuar.shop_spring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository <Category, Long> {

    @Query("select c from Category c order by c.id")
    List<Category> getAllCategories();
}
