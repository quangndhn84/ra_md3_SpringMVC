package ra.springmvc_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    public ModelAndView findAllCategories() {
        //Khởi tạo đối tuợng ModelAndView định nghĩa sau khi thực hiện xong thì gọi view nào
        ModelAndView mav = new ModelAndView("categories");
        List<Categories> listCategories = categoriesService.findAll();
        //add listCategories vào mav và chuyển sang view
        mav.addObject("listCategories", listCategories);
        return mav;
    }

    @GetMapping("/initCreate")
    public ModelAndView initCreateCatalog() {
        //Khởi tạo đối tượng catalogNew
        Categories catalogNew = new Categories();
        ModelAndView mav = new ModelAndView("newCategories");
        //add đối tượng catalogNew vào mav
        mav.addObject("catalogNew", catalogNew);
        return mav;
    }

    @PostMapping("/create")
//    public String createCatalog(@ModelAttribute("catalogNew") Categories catalog) {
    public String createCatalog(Categories catalogNew) {
        //1. Thêm catalogNew vào database --> CategoriesService
        boolean result = categoriesService.create(catalogNew);
        if (result) {
            //Thêm mới thành công --> gọi findAll để hiển thị tất cả danh mục
            return "redirect:findAll";
        } else {
            //Thêm mới thất bại --> chuyển sang trang error.jsp
            return "error";
        }
    }

    @GetMapping("/initUpdate")
//    public ModelAndView initUpdateCategories(@PathVariable("catalogId") int id){
    public ModelAndView initUpdateCategories(int catalogId) {
        //Lấy thông tin danh mục cần cập nhật theo catalogId
        Categories catalogUpdate = categoriesService.findById(catalogId);
        //Khởi tạo đối tượng ModelAndView và add catalogUpdate vào
        ModelAndView mav = new ModelAndView("updateCategories");
        mav.addObject("catalogUpdate", catalogUpdate);
        return mav;
    }

    @PostMapping("/update")
    public String updateCategories(Categories catalogUpdate) {
        //B1: gọi service thực hiện cập nhật danh mục
        boolean result = categoriesService.update(catalogUpdate);
        //B2: kiểm tra kết quả, thành công --> findAll, thất bại--> error.jsp
        if (result) {
            return "redirect:findAll";
        } else {
            return "error";
        }
    }

    @GetMapping("/delete")
    public String deleteCategories(int catalogId) {
        //Gọi service thực hiện xóa theo catalogId
        boolean result = categoriesService.delete(catalogId);
        //Kết quả true --> findAll, false--> error.jsp
        if (result) {
            return "redirect:findAll";
        } else {
            return "error";
        }
    }
}
