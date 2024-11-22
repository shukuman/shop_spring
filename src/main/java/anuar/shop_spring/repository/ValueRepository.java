package anuar.shop_spring.repository;

import anuar.shop_spring.entity.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ValueRepository extends JpaRepository <Value, Long> {

    @Query("select v from Value v order by v.specification.id")
    List<Value> getAllValues();

    @Query("select v from Value v where v.id = :valueId")
    Value getValueById(@Param("valueId") Long valueId);
}
