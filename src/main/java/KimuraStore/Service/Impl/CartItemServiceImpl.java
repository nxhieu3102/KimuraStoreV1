package KimuraStore.Service.Impl;

import KimuraStore.Dao.CartItemDao;
import KimuraStore.Entity.CartItem;
import KimuraStore.Service.ICartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements ICartItemService {
    @Autowired
    private CartItemDao cartItemDao;

    @Override
    public List<CartItem> GetCartItemsByCartId(int cart_id) {
        return cartItemDao.GetCartItemsByCartId(cart_id);
    }

    @Override
    public double GetTotalPriceAllItems(List<CartItem> cartItems) {
        if(cartItems == null)
            return 0;

        double total = 0;

        for(CartItem item : cartItems) {
            total += item.getTotalPrice();
        }

        return total;
    }
}
