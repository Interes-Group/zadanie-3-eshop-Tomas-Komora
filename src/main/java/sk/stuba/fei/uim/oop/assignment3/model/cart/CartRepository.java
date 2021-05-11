package sk.stuba.fei.uim.oop.assignment3.model.cart;

import org.springframework.data.repository.CrudRepository;
import sk.stuba.fei.uim.oop.assignment3.model.product.Products;

import java.util.List;

public interface CartRepository extends CrudRepository<Cart,Long> {
    List<Cart> findAll();
}
