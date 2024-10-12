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

    @ManyToMany
    @JoinTable(name = "users")
    private List<User> users;

    @ManyToMany
    @JoinTable(name = "products")
    private List<Product> products;
}
