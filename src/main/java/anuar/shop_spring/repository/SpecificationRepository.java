package anuar.shop_spring.repository;

import anuar.shop_spring.entity.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpecificationRepository extends JpaRepository <Specification, Long> {

    @Query("select s from Specification s order by s.category.name, s.name")
    List<Specification> getAllSpecifications();

    @Query("select s from Specification s where s.id = :specificationId")
    Specification getSpecificationById(@Param("specificationId") Long specificationId);
}
