package sk.stuba.fei.uim.oop.assignment3.service.cart;

import sk.stuba.fei.uim.oop.assignment3.exceptions.NotExists;
import sk.stuba.fei.uim.oop.assignment3.model.cart.Cart;

import java.util.List;


public interface ICartService {
    List<Cart> getAll();
    Cart create();
    Cart getCartById(Long id) throws NotExists;
    void deleteCartById(Long id) throws NotExists;
}
