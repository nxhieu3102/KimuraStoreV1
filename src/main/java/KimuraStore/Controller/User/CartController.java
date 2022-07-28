package KimuraStore.Controller.User;


import KimuraStore.Dao.ProductDao;
import KimuraStore.Entity.Bill;
import KimuraStore.Entity.CartItem;
import KimuraStore.Entity.User;
import KimuraStore.Service.Impl.BillProductDetailsServiceImpl;
import KimuraStore.Service.Impl.BillServiceImpl;
import KimuraStore.Service.Impl.CartItemServiceImpl;
import KimuraStore.Service.Impl.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CartController extends BaseController   {
    @Autowired
    private CartServiceImpl cartService;
    @Autowired
    private CartItemServiceImpl cartItemService;
    @Autowired
    private BillServiceImpl billService;
    @Autowired
    private ProductDao productDao;

    @Autowired
    private BillProductDetailsServiceImpl billProductDetailsService;
    @RequestMapping(value = "xem-gio-hang", method = RequestMethod.GET)
    public ModelAndView CartInfo(HttpSession session) {
        _mvShare.setViewName("/user/cart/list_cart");
        _mvShare.addObject("BillInfo", new Bill());
        List<CartItem> cartItems = (List<CartItem>)session.getAttribute("cartItem");
        session.setAttribute("TotalPrice", cartItemService.GetTotalPriceAllItems(cartItems));
        return _mvShare;
    }

    @RequestMapping(value = "xem-gio-hang", method = RequestMethod.POST)
    public String CheckOut(HttpServletRequest request, HttpSession session, @ModelAttribute("BillInfo") Bill bill){
        User user = (User)session.getAttribute("loginInfo");
        bill.setUserId(user.getId());
        bill.setTotalPrice((double)session.getAttribute("TotalPrice"));
        billService.InsertBill(bill);

        int id = billService.GetLastInsertBillId();
        List<CartItem> cartItems = (List<CartItem>)session.getAttribute("cartItem");

        for(CartItem item : cartItems) {
            billProductDetailsService.AddProductDetails(id, item.getId());
            int productId = item.getProductId();
            productDao.IncreaseQuantitySell(productId, item.getQuantity());
        }

        session.setAttribute("messageCheckout", "Xin cảm ơn quý khách đã mua hàng của chúng tôi");
        session.removeAttribute("cartItem");
        cartService.RemoveCart(user.getId());

        return "redirect:" + request.getHeader("Referer");
    }

    @RequestMapping(value = "AddCart/{id}")
    public String AddCart(HttpServletRequest request, HttpSession session, @PathVariable int id) {
        User user = (User)session.getAttribute("loginInfo");
        if(user != null) {
            int userId = user.getId();
            cartService.AddItemToCart(userId, id);

            int cartId = cartService.GetCartByIdUser(userId).getId();
            List<CartItem> cartItems = cartItemService.GetCartItemsByCartId(cartId);

            session.removeAttribute("cartItem");
            session.setAttribute("cartItem", cartItems);
        }
        return "redirect:" + request.getHeader("Referer");
    }

    @RequestMapping(value = "DeleteCart/{id}")
    public String DeleteCart(HttpServletRequest request, HttpSession session, @PathVariable int id) {
        int userId = ((User)session.getAttribute("loginInfo")).getId();
        cartService.DeleteItemFromCart(userId, id);

        int cartId = cartService.GetCartByIdUser(userId).getId();
        List<CartItem> cartItems = cartItemService.GetCartItemsByCartId(cartId);

        session.removeAttribute("cartItem");
        session.setAttribute("cartItem", cartItems);
        return "redirect:" + request.getHeader("Referer");
    }

    @RequestMapping(value = "EditCart/{id}/{quantity}")
    public String EditCart(HttpServletRequest request, HttpSession session, @PathVariable int id, @PathVariable int quantity){
        User user = (User)session.getAttribute("loginInfo");
        if(user != null) {
            int userId = user.getId();
            cartService.EditCart(userId, id, quantity);

            int cartId = cartService.GetCartByIdUser(userId).getId();
            List<CartItem> cartItems = cartItemService.GetCartItemsByCartId(cartId);

            session.removeAttribute("cartItem");
            session.setAttribute("cartItem", cartItems);
        }
        return "redirect:" + request.getHeader("Referer");
    }
}
