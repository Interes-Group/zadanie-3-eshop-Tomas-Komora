package sk.stuba.fei.uim.oop.assignment3.model.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends CrudRepository<Products,Long> {
    List<Products> findAll();


}
