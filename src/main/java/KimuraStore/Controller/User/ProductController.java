package KimuraStore.Controller.User;

import KimuraStore.Dto.ProductDto;
import KimuraStore.Service.Impl.CategoryServiceImpl;
import KimuraStore.Service.Impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProductController extends BaseController {
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private CategoryServiceImpl categoryService;

    @RequestMapping(value = "chi-tiet-san-pham/{id}")
    public ModelAndView Index(@PathVariable int id) {
        ProductView(id);
        _mvShare.addObject("optionId", -1);

        return _mvShare;
    }

    @RequestMapping(value = "chi-tiet-san-pham/{id}/{optionId}")
    public ModelAndView Index(@PathVariable int id, @PathVariable int optionId) {
        ProductView(id);
        _mvShare.addObject("optionId", optionId);

        return _mvShare;
    }

    @RequestMapping(value = {"/search/**", "/search"})
    public ModelAndView Index(HttpServletRequest request, HttpSession session,
                              @RequestParam(required = false, name = "price", defaultValue = "null") String price,
                              @RequestParam(required = false, name = "name", defaultValue = "null") String name,
                              @RequestParam(required = false, name = "category", defaultValue = "null") String category) {
        ModelAndView mv = new ModelAndView("user/products/search");
        String keyword = request.getParameter("keyword");
        if (keyword == null)
            keyword = (String) session.getAttribute("keyword");
        session.setAttribute("keyword", keyword);
        List<ProductDto> products = productService.SearchByName(keyword, price, name, category);

        mv.addObject("categoryData", categoryService.GetDataCategory());
        mv.addObject("keyword", keyword);
        mv.addObject("ProductPaginate", products);
        return mv;
    }

    private void ProductView(@PathVariable int id) {
        _mvShare.setViewName("user/products/product");
        _mvShare.addObject("product", productService.GetProductById(id));
        _mvShare.addObject("idProduct", id);

        int idCategory = productService.GetProductById(id).getCategory_id();

        _mvShare.addObject("productRelated", productService.GetRelatedProductByIdCategory(idCategory));
        _mvShare.addObject("productByIdCategory", productService.GetAllProductByIdCategory(idCategory));
    }

}
