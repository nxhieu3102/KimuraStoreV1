package KimuraStore.Service.Impl;

import KimuraStore.Dao.CartDao;
import KimuraStore.Dto.CartDto;
import KimuraStore.Service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    private CartDao cartDao;

    @Override
    public HashMap<Integer, CartDto> AddCart(int id, HashMap<Integer, CartDto> cart) {
        return cartDao.AddCart(id, cart);
    }

    @Override
    public HashMap<Integer, CartDto> EditCart(int id, int quantity, HashMap<Integer, CartDto> cart) {
        return cartDao.EditCart(id, quantity, cart);
    }

    @Override
    public HashMap<Integer, CartDto> DeleteCart(int id, HashMap<Integer, CartDto> cart) {
        return cartDao.DeleteCart(id, cart);
    }

    @Override
    public int GetTotalQuantity(HashMap<Integer, CartDto> cart) {
        return cartDao.GetTotalQuantity(cart);
    }

    @Override
    public double GetTotalPrice(HashMap<Integer, CartDto> cart) {
        return cartDao.GetTotalPrice(cart);
    }
}
