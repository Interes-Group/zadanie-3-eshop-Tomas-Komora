package sk.stuba.fei.uim.oop.assignment3.controller.cart;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.model.cart.ProductsInCart;
import sk.stuba.fei.uim.oop.assignment3.model.product.Products;

import javax.persistence.Entity;
import java.util.List;

@Getter
@Setter
public class CartRequest {
    private List<ProductsInCart> shoppingList;
    private boolean payed;
}
