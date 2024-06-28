package ra.springmvc_crud.repository;

import ra.springmvc_crud.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    boolean create(Product product);
}
