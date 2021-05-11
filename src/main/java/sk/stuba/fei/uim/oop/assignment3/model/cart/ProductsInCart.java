package sk.stuba.fei.uim.oop.assignment3.model.cart;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.model.product.Products;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class ProductsInCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Products products;
    private Long amount;


}
