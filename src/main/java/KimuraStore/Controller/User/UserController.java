package KimuraStore.Controller.User;

import KimuraStore.Dao.UserDao;
import KimuraStore.Entity.Cart;
import KimuraStore.Entity.CartItem;
import KimuraStore.Entity.User;
import KimuraStore.Service.Impl.CartItemServiceImpl;
import KimuraStore.Service.Impl.CartServiceImpl;
import KimuraStore.Service.Impl.UserServiceImpl;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController extends BaseController {
    @Autowired
    UserServiceImpl userService;

    @Autowired
    CartItemServiceImpl cartItemService;

    @Autowired
    CartServiceImpl cartService;

    @RequestMapping(value = "/create-account", method = RequestMethod.POST)
    String CreateAccount(HttpSession session, @ModelAttribute("user")User user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
        String message = "";

        if(userService.IsAccountExist(user)) {
            message = "Email này đã tồn tại";
        } else {
            message = "Đăng kí thành công";
            userService.AddAccount(user);
        }

        session.setAttribute("message_create_account", message);
        return "redirect:/dang-ky" ;
    }

    @RequestMapping(value = "/dang-ky")
    ModelAndView Register(HttpSession session) {
        _mvShare.setViewName("user/account/register");
        _mvShare.addObject("user", new User());
        return _mvShare;
    }

    @RequestMapping(value = "/dang-nhap")
    ModelAndView Login(HttpSession session) {
        _mvShare.setViewName("user/account/login");
        _mvShare.addObject("user", new User());
        return _mvShare;
    }

    @RequestMapping(value = "/login-account", method = RequestMethod.POST)
    String LoginAccount(HttpSession session, @ModelAttribute("user") User user) {
        if(!userService.CheckAccount(user)) {
            session.setAttribute("messsage_login_account", "Thông tin đăng nhập sai !");
            return "redirect:/dang-nhap";
        }
        else {
            user = userService.GetUserByEmail(user.getEmail());
            session.setAttribute("loginInfo", user);

            Cart cart = cartService.GetCartByIdUser(user.getId());
            if(cart == null)
                cartService.CreateCart(user.getId());
            int cartId = cartService.GetCartByIdUser(user.getId()).getId();
            List<CartItem> cartItems = cartItemService.GetCartItemsByCartId(cartId);

            session.setAttribute("cartItem", cartItems);
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/dang-xuat")
    String Logout(HttpSession session) {
        session.removeAttribute("loginInfo");
        return "redirect:/";
    }

}
