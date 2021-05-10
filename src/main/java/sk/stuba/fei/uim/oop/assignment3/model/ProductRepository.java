package sk.stuba.fei.uim.oop.assignment3.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.stuba.fei.uim.oop.assignment3.model.Products;

import java.util.List;


@Repository
public interface ProductRepository extends CrudRepository<Products,Long> {
    List<Products> findAll();


}
