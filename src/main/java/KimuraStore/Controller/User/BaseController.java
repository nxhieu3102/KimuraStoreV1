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

}
