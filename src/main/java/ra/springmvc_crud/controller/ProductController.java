package ra.springmvc_crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.springmvc_crud.model.Categories;
import ra.springmvc_crud.model.Product;
import ra.springmvc_crud.service.CategoriesService;
import ra.springmvc_crud.service.ProductService;
import ra.springmvc_crud.serviceImp.CategoriesServiceImp;
import ra.springmvc_crud.serviceImp.ProductServiceImp;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/productController")
public class ProductController {
    private final ProductService productService;
    private final CategoriesService categoriesService;

    public ProductController(ProductServiceImp productServiceImp, CategoriesServiceImp categoriesServiceImp) {
        this.productService = productServiceImp;
        this.categoriesService = categoriesServiceImp;
    }

    @GetMapping("/findAll")
    public ModelAndView findAllProduct() {
        ModelAndView mav = new ModelAndView("products");
        List<Product> listProduct = productService.findAll();
        mav.addObject("listProduct", listProduct);
        return mav;
    }

    @GetMapping("/initCreate")
    public ModelAndView initCreateProduct() {
        ModelAndView mav = new ModelAndView("newProduct");
        Product productNew = new Product();
        List<Categories> listCategories = categoriesService.findAll();
        mav.addObject("productNew", productNew);
        mav.addObject("listCategories", listCategories);
        return mav;
    }

    @PostMapping("/create")
    public String createProduct(@Valid Product productNew, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            //Có lỗi khi validate
            //1. Lấy các lỗi ra và add vào model
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                model.addAttribute(fieldError.getField(), fieldError.getDefaultMessage());
            }
            //2. add lại dữ liệu cũ của form vào model
            model.addAttribute("productNew", productNew);
            List<Categories> listCategories = categoriesService.findAll();
            model.addAttribute("listCategories", listCategories);
            //3. return về view: newProduct.jsp
            return "newProduct";
        }
        boolean result = productService.create(productNew);
        if (result) {
            return "redirect:findAll";
        }
        return "error";
    }
}
