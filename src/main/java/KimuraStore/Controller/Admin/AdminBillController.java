package KimuraStore.Controller.Admin;

import KimuraStore.Dao.BillDao;
import KimuraStore.Entity.Bill;
import KimuraStore.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminBillController {

    @Autowired
    private BillDao billDao;

    @RequestMapping("/admin/bill")
    public ModelAndView index(HttpSession session) {

        User user = (User)session.getAttribute("loginInfo");
        if(user == null || user.getRole().equals("customer")){
            return new ModelAndView("redirect:/");
        }

        ModelAndView mv = new ModelAndView("/admin/bill");
        List<Bill> bills = billDao.GetBillData();
        mv.addObject("bills", bills);
        return mv;
    }

    @RequestMapping("/admin/bill/view/{id}")
    public ModelAndView BillDetail(@PathVariable("id") int id, HttpSession session) {
        User user = (User)session.getAttribute("loginInfo");
        if(user == null || user.getRole().equals("customer")){
            return new ModelAndView("redirect:/");
        }

        ModelAndView mv = new ModelAndView("/admin/bill");
        Bill bill = billDao.GetBillById(id);
        mv.addObject("bill", bill);
        return mv;
    }
}
