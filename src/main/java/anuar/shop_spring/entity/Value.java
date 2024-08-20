package anuar.shop_spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "values")
public class Value {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "specification_id")
    private Specification specification;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
