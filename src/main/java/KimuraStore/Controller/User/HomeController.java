package KimuraStore.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController extends BaseController {
    @RequestMapping(value = {"/", "/trang-chu"})
    public ModelAndView Index(HttpSession session) {
        _mvShare.addObject("slides", _homeService.GetDataSlide());
        _mvShare.addObject("category", _homeService.GetDataCategory());
        _mvShare.addObject("bestSellerProduct", _homeService.GetBestSellerProduct());
        _mvShare.addObject("discountProduct",_homeService.GetDiscountProduct());
        session.setAttribute("categoryHome",  _homeService.GetDataCategory());
        _mvShare.setViewName("user/index");
        return _mvShare;
    }
}