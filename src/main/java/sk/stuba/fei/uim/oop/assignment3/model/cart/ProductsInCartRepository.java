package sk.stuba.fei.uim.oop.assignment3.model.cart;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductsInCartRepository extends CrudRepository<ProductsInCart, Long> {
    List<ProductsInCart> findAll();
}
