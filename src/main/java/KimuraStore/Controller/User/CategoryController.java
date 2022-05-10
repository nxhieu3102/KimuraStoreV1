package KimuraStore.Controller.User;

import KimuraStore.Dto.PaginatesDto;
import KimuraStore.Service.Impl.CategoryServiceImpl;
import KimuraStore.Service.Impl.PaginateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController extends BaseController {
    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private PaginateServiceImpl paginateService;


    @RequestMapping(value = "the-loai-san-pham/{id}")
    public ModelAndView Index(@PathVariable int id) {

        _mvShare.setViewName("user/products/category");
        _mvShare.addObject("categoryData", categoryService.GetDataCategory());
        _mvShare.addObject("productByCategoryId", categoryService.GetProductByIdCategory(id));

        int totalData = categoryService.GetProductByIdCategory(id).size();

        PaginatesDto paginatesInfo = paginateService.GetInfoPaginates(totalData, 12, 1);

        _mvShare.addObject("category", categoryService.GetDataCategoryById(id));
        _mvShare.addObject("idCategory", id);
        _mvShare.addObject("paginateInfo", paginatesInfo);
        _mvShare.addObject("ProductPaginate", categoryService.GetDataProductsPaginate(id, paginatesInfo.getStart(), 12));

        return _mvShare;
    }

    @RequestMapping(value = "the-loai-san-pham/{id}/{currentPage}")
    public ModelAndView Index(@PathVariable int id, @PathVariable int currentPage) {
        _mvShare.setViewName("user/products/category");
        _mvShare.addObject("categoryData", categoryService.GetDataCategory());
        _mvShare.addObject("productByCategoryId", categoryService.GetProductByIdCategory(id));

        int totalData = categoryService.GetProductByIdCategory(id).size();

        PaginatesDto paginatesInfo = paginateService.GetInfoPaginates(totalData, 12, currentPage);

        _mvShare.addObject("category", categoryService.GetDataCategoryById(id));
        _mvShare.addObject("idCategory", id);
        _mvShare.addObject("paginateInfo", paginatesInfo);
        _mvShare.addObject("ProductPaginate", categoryService.GetDataProductsPaginate(id, paginatesInfo.getStart(), 12));

        return _mvShare;
    }

    
}