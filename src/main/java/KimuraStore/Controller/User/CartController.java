package KimuraStore.Controller.User;

import KimuraStore.Dto.CartDto;
import KimuraStore.Entity.CartItem;
import KimuraStore.Entity.User;
import KimuraStore.Service.Impl.CartItemServiceImpl;
import KimuraStore.Service.Impl.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class CartController extends BaseController   {
    @Autowired
    private CartServiceImpl cartService;
    @Autowired
    private CartItemServiceImpl cartItemService;
    @RequestMapping(value = "xem-gio-hang")
    public ModelAndView CartInfo(HttpSession session) {
        _mvShare.setViewName("/user/cart/list_cart");
        List<CartItem> cartItems = (List<CartItem>)session.getAttribute("cartItem");

        session.setAttribute("TotalPrice", cartItemService.GetTotalPriceAllItems(cartItems));
        return _mvShare;
    }

//    @RequestMapping(value = "AddCart/{id}")
//    public String AddCart(HttpServletRequest request, HttpSession session, @PathVariable int id) {
//        HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>)session.getAttribute("Cart");
//        if(cart == null) {
//            cart = new HashMap<Integer, CartDto>();
//        }
//        cart = cartService.AddCart(id, cart);
//        session.setAttribute("Cart", cart);
//        session.setAttribute("TotalPrice", cartService.GetTotalPrice(cart));
//        return "redirect:" + request.getHeader("Referer");
//    }
//
//
    @RequestMapping(value = "AddCart/{id}")
    public String AddCart(HttpServletRequest request, HttpSession session, @PathVariable int id) {
        User user = (User)session.getAttribute("loginInfo");
        if(user != null) {
            int userId = user.getId();
            cartService.AddCart(userId, id);

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
        cartService.DeleteCart(userId, id);

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

//    @RequestMapping(value = "EditCart/{id}/{quantity}")
//    public String AddCart(HttpServletRequest request, HttpSession session, @PathVariable int id, @PathVariable int quantity) {
//        HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>)session.getAttribute("Cart");
//        if(cart == null) {
//            cart = new HashMap<Integer, CartDto>();
//        }
//        if(cart.get(id) == null)
//            cart = cartService.AddCart(id, cart);
//        cart = cartService.EditCart(id, quantity, cart);
//        session.setAttribute("Cart", cart);
//        session.setAttribute("TotalPrice", cartService.GetTotalPrice(cart));
//        return "redirect:" + request.getHeader("Referer");
//    }

//    @RequestMapping(value = "DeleteCart/{id}")
//    public String DeleteCart(HttpServletRequest request, HttpSession session, @PathVariable int id) {
//        HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>)session.getAttribute("Cart");
//        if(cart == null) {
//            cart = new HashMap<Integer, CartDto>();
//        }
//
//        cart = cartService.DeleteCart(id, cart);
//        session.setAttribute("Cart", cart);
//        session.setAttribute("TotalPrice", cartService.GetTotalPrice(cart));
//        return "redirect:" + request.getHeader("Referer");
//    }
}
