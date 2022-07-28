package KimuraStore.Controller.Admin;

import KimuraStore.Entity.Category;
import KimuraStore.Entity.User;
import KimuraStore.Service.Impl.CategoryServiceImpl;
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
public class AdminCategoryController {
    @Autowired
    CategoryServiceImpl categoryService;

    @RequestMapping("/admin/category")
    public ModelAndView index(HttpSession session) {
        User user = (User)session.getAttribute("loginInfo");
        if(user == null || user.getRole().equals("customer")){
            return new ModelAndView("redirect:/");
        }

        ModelAndView mv = new ModelAndView("/admin/category");
        List<Category> categories = categoryService.GetDataCategory();
        mv.clear();
        mv.addObject("categories", categories);

        return mv;
    }

    @RequestMapping("/admin/category/add")
    public ModelAndView index(HttpServletRequest request, HttpSession session) {
        User user = (User)session.getAttribute("loginInfo");
        if(user == null || user.getRole().equals("customer")){
            return new ModelAndView("redirect:/");
        }

        ModelAndView mv = new ModelAndView("/admin/category");
        String category = request.getParameter("name");
        categoryService.AddCategory(category);
        mv.addObject("message", "Thêm danh mục thành công");
        return mv;
    }

    @RequestMapping("/admin/category/delete/{id}")
    public String index(HttpServletRequest request, @PathVariable("id") int id, HttpSession session) {
        User user = (User)session.getAttribute("loginInfo");
        if(user == null || user.getRole().equals("customer")){
            return "redirect:/";
        }
        categoryService.DeleteCategory(id);
        return "redirect:/admin/category";
    }

    @RequestMapping(value = "/admin/category/edit/{id}", method = RequestMethod.GET)
    public ModelAndView EditCategory(HttpServletRequest request, @PathVariable("id") int id, HttpSession session) {
        User user = (User)session.getAttribute("loginInfo");
        if(user == null || user.getRole().equals("customer")){
            return new ModelAndView("redirect:/");
        }
        ModelAndView mv = new ModelAndView("/admin/category");
        mv.addObject("edit", id);
        List<Category> categories = categoryService.GetDataCategory();
        mv.addObject("categories", categories);
        return mv;
    }

    @RequestMapping(value="/admin/category/edit/{id}", method = RequestMethod.POST)
    public ModelAndView EditCategorySuccess(HttpServletRequest request, @PathVariable("id") int id, HttpSession session) {
        User user = (User)session.getAttribute("loginInfo");
        if(user == null || user.getRole().equals("customer")){
            return new ModelAndView("redirect:/");
        }
        ModelAndView mv = new ModelAndView("/admin/category");
        String name = request.getParameter("name");
        categoryService.UpdateCategory(id, name);
        mv.addObject("message", "Chỉnh sửa danh mục thành công");
        return mv;
    }
}
