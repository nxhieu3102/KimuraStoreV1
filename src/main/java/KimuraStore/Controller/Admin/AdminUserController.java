package KimuraStore.Controller.Admin;

import KimuraStore.Dao.UserDao;
import KimuraStore.Entity.User;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminUserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping("/admin/user")
    public ModelAndView mv(HttpSession session) {
        User user = (User)session.getAttribute("loginInfo");
        if(user == null || user.getRole().equals("user")){
            return new ModelAndView("redirect:/");
        }
        ModelAndView mv = new ModelAndView("/admin/user");
        List<User> users = userDao.GetDataUser();
        mv.addObject("users", users);
        return mv;
    }

    @RequestMapping("/admin/user/delete/{id}")
    public String DeleteUser(@PathVariable("id") int id, HttpSession session) {
        User user = (User)session.getAttribute("loginInfo");
        if(user == null || user.getRole().equals("customer")){
            return "redirect:/";
        }
        userDao.DeleteUser(id);
        return "redirect:/admin/user";
    }

    @RequestMapping(value = "/admin/user/edit/{id}", method = RequestMethod.GET)
    public ModelAndView EditUserPage(@PathVariable("id") int id, HttpSession session) {
        User user = (User)session.getAttribute("loginInfo");
        if(user == null || user.getRole().equals("customer")){
            return new ModelAndView("redirect:/");
        }
        ModelAndView mv = new ModelAndView("/admin/user");
        mv.addObject("id", id);
        return mv;
    }

    @RequestMapping(value = "/admin/user/edit/{id}", method = RequestMethod.POST)
    public ModelAndView EditUser(HttpServletRequest request, @PathVariable("id") int id, HttpSession session) {
        User user = (User)session.getAttribute("loginInfo");
        if(user == null || user.getRole().equals("customer")){
            return new ModelAndView("redirect:/");
        }
        ModelAndView mv = new ModelAndView("/admin/user");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String role = request.getParameter("role");

        boolean edit = userDao.EditUser(id, name, email, role);
        mv.addObject("isSuccess", edit);
        mv.addObject("id", id);
        return mv;
    }

    @RequestMapping(value = "/admin/user/add")
    public ModelAndView AddUser(HttpServletRequest request, HttpSession session) {
        User user = (User)session.getAttribute("loginInfo");
        if(user == null || user.getRole().equals("customer")){
            return new ModelAndView("redirect:/");
        }

        ModelAndView mv = new ModelAndView("/admin/user");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        password = BCrypt.hashpw(password, BCrypt.gensalt(12));

        user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setDisplay_name(name);
        user.setRole(role);
        boolean isSuccess = userDao.AddAccount(user);

        mv.addObject("isSuccess", isSuccess);
        mv.addObject("add", true);
        return mv;
    }

    @RequestMapping("/admin/logout")
    public String LogOut(HttpSession session) {
        session.removeAttribute("loginInfo");
        return "redirect:/";
    }

}
