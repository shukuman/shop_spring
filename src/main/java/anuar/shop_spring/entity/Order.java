package anuar.shop_spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private Integer status;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "orders_products")
    private List<OrderProduct> orderProductList;
}
