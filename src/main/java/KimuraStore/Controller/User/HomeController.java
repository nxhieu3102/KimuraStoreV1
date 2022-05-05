package KimuraStore.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController {
    @RequestMapping(value = {"/", "/trang-chu"})
    public ModelAndView Index() {
        _mvShare.addObject("slides", _homeService.GetDataSlide());
        _mvShare.addObject("category", _homeService.GetDataCategory());
        _mvShare.addObject("discountProduct", _homeService.GetDiscountProduct());
        _mvShare.addObject("bestSellerProduct", _homeService.GetBestSellerProduct());
        _mvShare.setViewName("user/index");
        return _mvShare;
    }

    @RequestMapping(value = {"/product"})
    public ModelAndView Product() {
        ModelAndView mv = new ModelAndView("user/product");
        return mv;
    }
}