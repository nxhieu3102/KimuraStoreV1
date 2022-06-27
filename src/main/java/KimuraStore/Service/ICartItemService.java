package KimuraStore.Service;

import KimuraStore.Entity.CartItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICartItemService {
    public List<CartItem> GetCartItemsByCartId(int cart_id);
    public double GetTotalPriceAllItems(List<CartItem> cartItems);
}
