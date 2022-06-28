package KimuraStore.Service.Impl;

import KimuraStore.Dao.CartDao;
import KimuraStore.Dto.CartDto;
import KimuraStore.Entity.Cart;
import KimuraStore.Service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    private CartDao cartDao;

    @Override
    public void AddCart(int userId, int itemId) {
        cartDao.AddCart(userId, itemId);
    }

    @Override
    public void DeleteCart(int userId, int itemId) {
        cartDao.DeleteCart(userId, itemId);
    }

    @Override
    public void EditCart(int userId, int itemId, int quantity) {
        cartDao.EditCart(userId, itemId, quantity);
    }

    @Override
    public Cart GetCartByIdUser(int id) {
        return cartDao.GetCartByIdUser(id);
    }
}
