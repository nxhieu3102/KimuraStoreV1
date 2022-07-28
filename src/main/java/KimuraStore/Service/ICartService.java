package KimuraStore.Service;

import KimuraStore.Dto.CartDto;
import KimuraStore.Entity.Cart;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface ICartService {
    public void AddItemToCart(int userId, int itemId);
    public void DeleteItemFromCart(int userId, int itemId);
    public void EditCart(int userId, int itemId, int quantity);
    public Cart GetCartByIdUser(int id);
    public void CreateCart(int id);
    public void RemoveCart(int id);
}
