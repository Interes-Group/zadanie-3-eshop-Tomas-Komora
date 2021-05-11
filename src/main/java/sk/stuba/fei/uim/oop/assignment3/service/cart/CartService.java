package sk.stuba.fei.uim.oop.assignment3.service.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.controller.cart.CartRequest;
import sk.stuba.fei.uim.oop.assignment3.controller.cart.CartResponse;
import sk.stuba.fei.uim.oop.assignment3.exceptions.NotExists;
import sk.stuba.fei.uim.oop.assignment3.model.cart.Cart;
import sk.stuba.fei.uim.oop.assignment3.model.cart.CartRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService implements ICartService {

    private CartRepository repository;

    @Autowired
    public CartService(CartRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Cart> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Cart create() {
        Cart newCart = new Cart();
        newCart.setProductsInCarts(new ArrayList<>());
        newCart.setPayed(false);
        return this.repository.save(newCart);
    }

    public Cart getCartById(Long id) throws NotExists {
        Optional<Cart> cart= repository.findById(id);
        if(cart.isEmpty()){
            throw new NotExists();
        }else{
            return cart.get();
        }
    }

    public void deleteCartById(Long id) throws NotExists {
        Optional<Cart> cart= repository.findById(id);
        if(cart.isEmpty()){
            throw new NotExists();
        }else{
            repository.deleteById(id);
        }
    }

}
