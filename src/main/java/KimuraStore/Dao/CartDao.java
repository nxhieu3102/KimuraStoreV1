package KimuraStore.Dao;

import KimuraStore.Dto.CartDto;
import KimuraStore.Dto.ProductDto;
import KimuraStore.Entity.Cart;
import KimuraStore.Entity.CartItem;
import KimuraStore.Entity.Mapper.MapperCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
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

    public void AddCart(int product_id, Cart cart) {
        CartItem cartItem = cartItemDao.GetProductInCart(cart.getId(), product_id);
        ProductDto product = productDao.GetProductById(product_id);

        if(cartItem == null) {
            cartItem = new CartItem();
            cartItem.setCart_id(cart.getId());
            cartItem.setProduct_id(product_id);
            cartItem.setQuantity(1);
            cartItem.setTotal_price(product.getPrice());
            cartItemDao.InsertCartItem(cartItem);

        }
        else {
            cartItem.setQuantity(cartItem.getQuantity() + 1);
            cartItem.setTotal_price(cartItem.getQuantity() * product.getPrice());
            cartItemDao.UpdateCartItem(cartItem);
        }
    }

    public void EditCart(int cart_id, int product_id, int quantity) {
        CartItem cartItem = cartItemDao.GetProductInCart(cart_id, product_id);
        ProductDto product = productDao.GetProductById(product_id);

        cartItem.setQuantity(quantity);
        cartItem.setTotal_price(quantity * product.getPrice());

        cartItemDao.UpdateCartItem(cartItem);
    }

    public void DeleteCartItem(int id) {
        cartItemDao.RemoveCartItem(id);
    }

    public HashMap<Integer, CartDto> AddCart(int id, HashMap<Integer, CartDto> cart) {
        CartDto itemCart = new CartDto();
        ProductDto product = productDao.GetProductById(id);

        if(cart == null || product == null)
            return null;

        if (cart.containsKey(id)) {
            itemCart = cart.get(id);
            itemCart.setQuantity(itemCart.getQuantity() + 1);
            itemCart.setTotalPrice(product.getPrice() * itemCart.getQuantity());
        }else {
            itemCart.setProduct(product);
            itemCart.setQuantity(1);
            itemCart.setTotalPrice(product.getPrice());
        }

        cart.put(id, itemCart);

        return cart;
    }

    public HashMap<Integer, CartDto> EditCart(int id, int quantity, HashMap<Integer, CartDto> cart) {
        if (cart == null) return null;

        CartDto itemCart = new CartDto();
        if (cart.containsKey(id)) {
            itemCart = cart.get(id);
            itemCart.setQuantity(quantity);
            itemCart.setTotalPrice(quantity * itemCart.getProduct().getPrice());
        }
        cart.put(id, itemCart);
        return cart;
    }

    public HashMap<Integer, CartDto> DeleteCart(int id, HashMap<Integer, CartDto> cart) {
        if (cart == null) return null;
        if (cart.containsKey(id)) {
            cart.remove(id);
        }
        return cart;
    }

    public int GetTotalQuantity(HashMap<Integer, CartDto> cart) {
        int totalQuantity = 0;
        for (Map.Entry<Integer, CartDto> item : cart.entrySet()) {
            totalQuantity += item.getValue().getQuantity();
        }
        return totalQuantity;
    }

    public double GetTotalPrice(HashMap<Integer, CartDto> cart) {
        double totalPrice = 0;
        for (Map.Entry<Integer, CartDto> item : cart.entrySet()) {
            totalPrice += item.getValue().getTotalPrice();
        }
        return totalPrice;
    }
}
