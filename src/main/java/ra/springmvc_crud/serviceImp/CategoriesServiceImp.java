package ra.springmvc_crud.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.springmvc_crud.model.Categories;
import ra.springmvc_crud.repository.CategoriesRepository;
import ra.springmvc_crud.repositoryImp.CategoriesRepositoryImp;
import ra.springmvc_crud.service.CategoriesService;

import java.util.List;

@Service
public class CategoriesServiceImp implements CategoriesService {
    //Tiêm phụ thuộc CategoriesRepository vào để tạo instance và gọi sang repository
    private final CategoriesRepository categoriesRepository;
    @Autowired
    public CategoriesServiceImp(CategoriesRepositoryImp categoriesRepositoryImp) {
        this.categoriesRepository = categoriesRepositoryImp;
    }

    @Override
    public List<Categories> findAll() {
        return categoriesRepository.findAll();
    }
}
