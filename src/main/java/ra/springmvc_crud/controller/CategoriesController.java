package ra.springmvc_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.springmvc_crud.model.Categories;
import ra.springmvc_crud.service.CategoriesService;
import ra.springmvc_crud.serviceImp.CategoriesServiceImp;

import java.util.List;

@Controller
@RequestMapping("/CategoriesController")
public class CategoriesController {
    private final CategoriesService categoriesService;

    @Autowired
    public CategoriesController(CategoriesServiceImp categoriesServiceImp) {
        this.categoriesService = categoriesServiceImp;
    }
//    @RequestMapping(value = "findAll",method = RequestMethod.GET)
    @GetMapping("findAll")
    public ModelAndView findAllCategories(){
        //Khởi tạo đối tuợng ModelAndView định nghĩa sau khi thực hiện xong thì gọi view nào
        ModelAndView mav = new ModelAndView("categories");
        List<Categories> listCategories = categoriesService.findAll();
        //add listCategories vào mav và chuyển sang view
        mav.addObject("listCategories", listCategories);
        return mav;
    }
}
