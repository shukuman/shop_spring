package anuar.shop_spring.repository;

import anuar.shop_spring.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository <Category, Long> {
}
