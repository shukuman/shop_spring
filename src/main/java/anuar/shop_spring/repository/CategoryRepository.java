package anuar.shop_spring.repository;

import anuar.shop_spring.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository <Category, Long> {

    @Query("select c from Category c order by c.name")
    List<Category> getAllCategories();

    @Query("select c from Category c where c.id = :categoryId")
    Category getCategoryById(@Param("categoryId") Long categoryId);
}
