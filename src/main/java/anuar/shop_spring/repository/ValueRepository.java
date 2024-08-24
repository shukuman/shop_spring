package anuar.shop_spring.repository;

import anuar.shop_spring.entity.Value;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValueRepository extends JpaRepository <Value, Long> {
}
