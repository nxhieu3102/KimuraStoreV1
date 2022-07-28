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
    public void AddItemToCart(int userId, int itemId) {
        cartDao.AddItemToCart(userId, itemId);
    }

    @Override
    public void DeleteItemFromCart(int userId, int itemId) {
        cartDao.DeleteItemFromCart(userId, itemId);
    }

    @Override
    public void EditCart(int userId, int itemId, int quantity) {
        cartDao.EditCart(userId, itemId, quantity);
    }

    @Override
    public Cart GetCartByIdUser(int id) {
        return cartDao.GetCartByIdUser(id);
    }

    @Override
    public void CreateCart(int id) {
        cartDao.CreateCart(id);
    }

    @Override
    public void RemoveCart(int userId) {
        cartDao.RemoveCart(userId);
    }


}
