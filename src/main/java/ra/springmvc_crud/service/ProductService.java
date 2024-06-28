package ra.springmvc_crud.service;

import ra.springmvc_crud.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    boolean create(Product product);
}
