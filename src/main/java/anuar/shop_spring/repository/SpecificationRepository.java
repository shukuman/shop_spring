package anuar.shop_spring.repository;

import anuar.shop_spring.entity.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecificationRepository extends JpaRepository <Specification, Long> {
}
