package anuar.shop_spring.repository;

import anuar.shop_spring.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("select r from Review r where r.product.id = :id and r.status = :status")
    List<Review> getReviewsByProductIdAndStatus(@Param("id") Long id, @Param("status") Boolean status);

    @Query("select r from Review r where r.product.id = :id")
    List<Review> getReviewsByProductId(@Param("id") Long id);
}
