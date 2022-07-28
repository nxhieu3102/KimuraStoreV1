package KimuraStore.Service;

import KimuraStore.Entity.CartItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBillProductDetails {
    public void AddProductDetails(int billId, int productId);
    public List<CartItem> GetAllCartItemByBillId(int billId);
}
