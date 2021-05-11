package sk.stuba.fei.uim.oop.assignment3.controller.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.exceptions.NotExists;
import sk.stuba.fei.uim.oop.assignment3.model.cart.Cart;
import sk.stuba.fei.uim.oop.assignment3.service.cart.ICartService;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ICartService service;


    @PostMapping
    @ResponseBody
    public ResponseEntity<CartResponse> addCart() {
        Cart cart = service.create();
        return new ResponseEntity<>(new CartResponse(cart),HttpStatus.CREATED);
    }
    @GetMapping()
    @ResponseBody
    public List<CartResponse> getAllCarts() {
        return this.service.getAll().stream().map(CartResponse::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<CartResponse> getCartById(@PathVariable("id") Long id){
        try{
            Cart cart = service.getCartById(id);
            return new ResponseEntity<>(new CartResponse(cart) , HttpStatus.OK);
        }catch(NotExists notExists){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        try{
            service.deleteCartById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(NotExists notExists){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
