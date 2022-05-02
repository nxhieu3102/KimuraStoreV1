package KimuraStore.Controller.User;

import KimuraStore.Service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController extends BaseController{
    @Autowired
    private ProductServiceImpl productService;

    @RequestMapping(value = "chi-tiet-san-pham/{id}")
    public ModelAndView Index(@PathVariable int id) {
        _mvShare.setViewName("user/products/product");
        _mvShare.addObject("product", productService.GetProductById(id));
        _mvShare.addObject("productOptions", productService.GetProductOptionsById(id));
        int idCategory = productService.GetProductById(id).getCategory_id();
        _mvShare.addObject("productRelated", productService.GetRelatedProductByIdCategory(idCategory));
        _mvShare.addObject("productByIdCategory", productService.GetAllProductByIdCategory(idCategory));

        return _mvShare;
    }
}
