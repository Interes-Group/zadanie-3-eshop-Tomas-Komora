package sk.stuba.fei.uim.oop.assignment3.model.cart;


import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.model.product.Products;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    @OneToMany
    private List<ProductsInCart> productsInCarts = new ArrayList<>();

    private boolean payed;

}
