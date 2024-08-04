package anuar.shop_spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "orders_products")
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "count")
    private Integer count;

    @ManyToMany
    @JoinTable(name = "orders")
    private List<Order> orders;

    @ManyToMany
    @JoinTable(name = "products")
    private List<Product> products;
}
