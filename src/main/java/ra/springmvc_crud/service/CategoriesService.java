package ra.springmvc_crud.service;

import ra.springmvc_crud.model.Categories;

import java.util.List;

public interface CategoriesService {
    List<Categories> findAll();

    boolean create(Categories catalog);

    Categories findById(int catalogId);

    boolean update(Categories catalog);
    boolean delete(int catalogId);
}
