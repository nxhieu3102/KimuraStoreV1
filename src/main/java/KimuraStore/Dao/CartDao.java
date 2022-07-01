package KimuraStore.Dao;

import KimuraStore.Dto.CartDto;
import KimuraStore.Dto.ProductDto;
import KimuraStore.Entity.Cart;
import KimuraStore.Entity.Mapper.MapperCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CartDao extends BaseDao {
    @Autowired
    ProductDao productDao;
    @Autowired
    CartItemDao cartItemDao;

    public Cart GetCartByIdUser(int id) {
        String sql = "SELECT * FROM cart WHERE user_id = " + id;
        List<Cart> cartList = _jdbcTemplate.query(sql, new MapperCart());

        if(cartList.size() == 0)
            return null;
        return cartList.get(0);
    }

    public void AddCart(int userId, int itemId) {
        String sql = "SELECT * FROM cart WHERE user_id = " + userId;
        List<Cart> cart = _jdbcTemplate.query(sql, new MapperCart());

        if(cart.size() == 0) {
            CreateCart(userId);
            cart = _jdbcTemplate.query(sql, new MapperCart());
        }

        cartItemDao.AddCart(cart.get(0).getId(), itemId);
    }

    public void DeleteCart(int userId, int itemId) {
        String sql = "SELECT * FROM cart WHERE user_id = " + userId;
        List<Cart> cart = _jdbcTemplate.query(sql, new MapperCart());

        cartItemDao.DeleteCart(cart.get(0).getId(), itemId);
    }

    public void EditCart(int userId, int itemId, int quantity) {
        String sql = "SELECT * FROM cart WHERE user_id = " + userId;
        List<Cart> cart = _jdbcTemplate.query(sql, new MapperCart());

        if(cart.size() == 0) {
            CreateCart(userId);
            cart = _jdbcTemplate.query(sql, new MapperCart());
        }

        cartItemDao.EditCart(cart.get(0).getId(), itemId, quantity);
    }

    public void CreateCart(int userId) {
        String sql = "INSERT INTO cart (user_id) values (" + userId + ")";
        _jdbcTemplate.update(sql);
    }
}
