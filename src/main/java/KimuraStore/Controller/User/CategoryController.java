package KimuraStore.Controller.User;

import KimuraStore.Dao.ProductDao;
import KimuraStore.Dto.PaginatesDto;
import KimuraStore.Service.Impl.CategoryServiceImpl;
import KimuraStore.Service.Impl.PaginateServiceImpl;
import KimuraStore.Service.Impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController extends BaseController {
    @Autowired
    private CategoryServiceImpl categoryService;
    @Autowired
    private PaginateServiceImpl paginateService;
    @Autowired
    private ProductServiceImpl productService;

    private ModelAndView getModelAndView(@PathVariable int id, @RequestParam(required = false, name = "price", defaultValue = "null") String price, @RequestParam(required = false, name = "name", defaultValue = "null") String name, PaginatesDto paginatesInfo) {
        _mvShare.addObject("category", categoryService.GetDataCategoryById(id));
        _mvShare.addObject("idCategory", id);
        _mvShare.addObject("paginateInfo", paginatesInfo);
        _mvShare.addObject("ProductPaginate", categoryService.GetProductsPaginate(price, name, id, Math.max(paginatesInfo.getStart() - 1, 0), 12));

        return _mvShare;
    }

    @RequestMapping(value = "the-loai-san-pham/{id}")
    public ModelAndView Index(@PathVariable int id, @RequestParam(required = false, name = "price", defaultValue = "null") String price,
                              @RequestParam(required = false, name = "name", defaultValue = "null") String name) {

        _mvShare.setViewName("user/products/category");
        _mvShare.addObject("categoryData", categoryService.GetDataCategory());

        int totalData = categoryService.GetProductByIdCategoryAndFilter(price, name, id).size();

        PaginatesDto paginatesInfo = paginateService.GetInfoPaginates(totalData, 12, 1);

        return getModelAndView(id, price, name, paginatesInfo);
    }

    @RequestMapping(value = "the-loai-san-pham/{id}/{currentPage}")
    public ModelAndView Index(@PathVariable int id, @PathVariable int currentPage,
                              @RequestParam(required = false, name = "price", defaultValue = "null") String price,
                              @RequestParam(required = false, name = "name", defaultValue = "null") String name) {
        _mvShare.setViewName("user/products/category");
        _mvShare.addObject("categoryData", categoryService.GetDataCategory());
        _mvShare.addObject("productByCategoryId", categoryService.GetProductByIdCategory(id));

        int totalData = categoryService.GetProductByIdCategoryAndFilter(price, name, id).size();

        PaginatesDto paginatesInfo = paginateService.GetInfoPaginates(totalData, 12, currentPage);

        return getModelAndView(id, price, name, paginatesInfo);
    }


}