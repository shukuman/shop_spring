package anuar.shop_spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "count")
    private Integer count;

    @ManyToOne
    @JoinTable(name = "users")
    private User user;

    @ManyToOne
    @JoinTable(name = "products")
    private Product product;
}
