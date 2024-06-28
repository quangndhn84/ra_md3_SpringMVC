package ra.springmvc_crud.serviceImp;

import org.springframework.stereotype.Service;
import ra.springmvc_crud.model.Product;
import ra.springmvc_crud.repository.ProductRepository;
import ra.springmvc_crud.repositoryImp.ProductRepositoryImp;
import ra.springmvc_crud.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImp(ProductRepositoryImp productRepositoryImp) {
        this.productRepository = productRepositoryImp;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public boolean create(Product product) {
        return productRepository.create(product);
    }
}
