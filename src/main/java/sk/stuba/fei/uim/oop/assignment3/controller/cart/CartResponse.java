package sk.stuba.fei.uim.oop.assignment3.controller.cart;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.model.cart.Cart;
import sk.stuba.fei.uim.oop.assignment3.model.cart.ProductsInCart;
import sk.stuba.fei.uim.oop.assignment3.model.product.Products;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CartResponse {
    private Long id;
    private List<ProductsInCart> shoppingList;
    private boolean payed;

    public CartResponse(Cart c){
        this.id=c.getId();
        this.shoppingList= c.getProductsInCarts();
        this.payed=c.isPayed();
    }
}
