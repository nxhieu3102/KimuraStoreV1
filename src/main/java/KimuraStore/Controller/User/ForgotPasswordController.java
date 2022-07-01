package KimuraStore.Controller.User;

import KimuraStore.Entity.User;
import KimuraStore.Service.Impl.EmailServiceImpl;
import KimuraStore.Service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ForgotPasswordController extends BaseController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private EmailServiceImpl emailService;

    private final int TOKEN_LEN = 6;

    @RequestMapping(value = "/forgot-password", method = RequestMethod.GET)
    public ModelAndView ForgotPasswordPage() {
        _mvShare.setViewName("user/account/forgot_password");
        return _mvShare;
    }

    @RequestMapping(value = "/forgot-password", method = RequestMethod.POST)
    public String ForgotPasswordPage(HttpSession session, HttpServletRequest request) {
        String message = "Email này chưa được đăng kí";
        String email = request.getParameter("email");
        User user = userService.GetUserByEmail(email);

        if (user != null) {
            String token = emailService.GenerateToken(TOKEN_LEN);
            userService.SaveToken(token, user.getId());

            String content = "Đây là mã khôi phục tài khoản của bạn: " + token;
            String subject = "Khôi phục mật khẩu KimuraStore";
            emailService.SendMessage(email, subject, content);

            session.setAttribute("email", email);


            return "redirect:/send-token";
        }

        _mvShare.addObject("message", message);
        return "redirect:" + request.getHeader("Referer");
    }

    @RequestMapping(value = "send-token", method = RequestMethod.GET)
    public ModelAndView SendToken() {
        _mvShare.setViewName("user/account/send_token");
        return _mvShare;
    }

    @RequestMapping(value = "send-token", method = RequestMethod.POST)
    public String SendToken(HttpSession session, HttpServletRequest request) {
        String token = request.getParameter("token");
        String email = (String)session.getAttribute("email");

        if(userService.CheckToken(token, email)) {
            return "redirect:/reset-password";
        }else {
            session.setAttribute("WrongToken", true);
            return "redirect:" + request.getHeader("Referer");
        }
    }

    @RequestMapping(value = "/reset-password", method = RequestMethod.GET)
    public ModelAndView ResetPasswordPage() {
        ModelAndView mv = new ModelAndView("user/account/reset_password");
        return mv;
    }

    @RequestMapping(value = "/reset-password", method = RequestMethod.POST)
    public ModelAndView ResetPasswordPage(HttpServletRequest request, HttpSession session) {
        ModelAndView mv = new ModelAndView("user/account/reset_password");

        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");
        String email = (String) session.getAttribute("email");

        if(password == confirmPassword) {
            User user = userService.GetUserByEmail(email);
            userService.ChangePassword(password, user);
            mv.addObject("message", "Thay đổi mật khẩu thành công");
        } else {
            mv.addObject("message", "Xác nhận mật khẩu sai");
        }

        return mv;
    }
}
