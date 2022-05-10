package KimuraStore.Controller.User;

import KimuraStore.Service.Impl.HomeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseController {
    @Autowired
    HomeServiceImpl _homeService;
    public ModelAndView _mvShare = new ModelAndView();

//    @PostConstruct
//    public ModelAndView Init() {
//        _mvShare.addObject("menus", _homeService.GetDataMenus());
//        return _mvShare;
//    }
}
