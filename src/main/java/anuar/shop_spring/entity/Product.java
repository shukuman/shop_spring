package anuar.shop_spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

    @ManyToMany
    @JoinTable(name = "carts")
    private List<Cart> carts;

    @ManyToMany
    @JoinTable(name = "order_products")
    private List<OrderProduct> orderProductList;
}
