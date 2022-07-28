package KimuraStore.Controller.User;

import KimuraStore.Entity.Bill;
import KimuraStore.Entity.CartItem;
import KimuraStore.Entity.User;
import KimuraStore.Service.Impl.BillProductDetailsServiceImpl;
import KimuraStore.Service.Impl.BillServiceImpl;
import KimuraStore.Service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UserInfoController {
    @Autowired
    private BillProductDetailsServiceImpl billProductDetailsService;

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private BillServiceImpl billService;
    @RequestMapping(value = "/thong-tin")
    public ModelAndView UserInfo(HttpSession session) {
        ModelAndView mv = new ModelAndView("/user/account/user-infor");
        User user = (User)session.getAttribute("loginInfo") ;
        mv.addObject("user", user);

        List<Bill> bills = billService.GetBillsByUserId(user.getId());
        List<List<CartItem>> cartItems = new ArrayList<>();
        List<Double> totalPrices = new ArrayList<Double>();
        List<String> dateCheckOut = new ArrayList<String>();

        for(Bill bill : bills) {
            List<CartItem> cartItems1 = billProductDetailsService.GetAllCartItemByBillId(bill.getId());
            cartItems.add(cartItems1);
            dateCheckOut.add(new SimpleDateFormat("dd-MM-yyyy").format(bill.getCheckoutDate()));
            totalPrices.add(bill.getTotalPrice());
        }

        mv.addObject("cartItems", cartItems);
        mv.addObject("dateCheckOut", dateCheckOut);
        mv.addObject("totalPrices", totalPrices);
        return mv;
    }

    @RequestMapping(value = "/thong-tin/change", method = RequestMethod.GET)
    public ModelAndView UserInfo() {
        ModelAndView mv = new ModelAndView("/user/account/change-user-info");
        return mv;
    }

    @RequestMapping(value = "/thong-tin/change", method = RequestMethod.POST)
    public ModelAndView UserInfo(HttpSession session, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("/user/account/change-user-info");

        String name = request.getParameter("name");
        String email = request.getParameter("email");

        User user = (User)session.getAttribute("loginInfo");
        String message = "Bạn chưa điền thông tin";

        if(name != null || email != null)
            message = "Thay đổi thông tin thành công";

        mv.addObject("message", message);

        if(name == null)
            name = user.getDisplay_name();
        if(email == null)
            email = user.getEmail();

        userService.ChangeInfo(name, email, user);
        user = userService.GetUserByEmail(user.getEmail());
        session.setAttribute("loginInfo", user);

        return mv;
    }

}
