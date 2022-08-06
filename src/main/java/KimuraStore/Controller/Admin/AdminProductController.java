package KimuraStore.Controller.Admin;

import KimuraStore.Dao.ProductDao;
import KimuraStore.Dto.ProductDto;
import KimuraStore.Entity.Category;
import KimuraStore.Entity.User;
import KimuraStore.Service.Impl.CategoryServiceImpl;
import KimuraStore.Service.Impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminProductController {

    @Autowired
    private CategoryServiceImpl categoryService;
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private ProductDao productDao;
    private boolean checkUserIsAdminOrCustomer(HttpSession session) {
        User user = (User)session.getAttribute("loginInfo");
        if(user == null || user.getRole().equals("customer"))
            return false;
        return true;
    }
    @RequestMapping(value = "/admin/product")
    public ModelAndView Index(HttpSession session) {
        if(!checkUserIsAdminOrCustomer(session)){
            return new ModelAndView("redirect:/");
        }
        ModelAndView mv = new ModelAndView("/admin/product");
        List<Category> categories = categoryService.GetDataCategory();
        List<ProductDto> productDtos = productService.GetAllProducts();
        List<Category> categoryProduct = new ArrayList<Category>();

        for(ProductDto product : productDtos) {
            categoryProduct.add(categoryService.GetDataCategoryById(product.getCategory_id()));
        }

        mv.addObject("categories", categories);
        mv.addObject("products", productDtos);
        mv.addObject("categoryProduct", categoryProduct);
        return mv;
    }

    @RequestMapping(value = "/admin/product/delete/{id}")
    public String DeleteProduct(@PathVariable("id") int id, HttpSession session) {
        if(checkUserIsAdminOrCustomer(session)){
            return "redirect:/";
        }
        productDao.DeleteProduct(id);
        return "redirect:/admin/product";
    }

    @RequestMapping(value = "/admin/product/edit/{id}", method = RequestMethod.GET)
    public ModelAndView EditProduct(@PathVariable("id") int id, HttpSession session) {
        if(checkUserIsAdminOrCustomer(session)){
            return new ModelAndView("redirect:/");
        }
        ModelAndView mv = new ModelAndView("/admin/product");
        List<Category> categories = categoryService.GetDataCategory();
        ProductDto product = productDao.GetProductById(id);
        mv.addObject("product", product);
        mv.addObject("edit", id);
        mv.addObject("categories", categories);
        return mv;
    }

}
