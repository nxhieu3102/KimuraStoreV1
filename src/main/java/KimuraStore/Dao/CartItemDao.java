package KimuraStore.Dao;

import KimuraStore.Dto.ProductDto;
import KimuraStore.Entity.CartItem;
import KimuraStore.Entity.Mapper.MapperCartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartItemDao extends BaseDao {

    @Autowired
    ProductDao productDao;

    public CartItem GetCartItemById(int cartItemId) {
        String sql = "SELECT * FROM cart_item WHERE id = " + cartItemId;
        List<CartItem> cartItems = _jdbcTemplate.query(sql, new MapperCartItem());
        if(cartItems != null)
            return cartItems.get(0);
        return null;
    }
    public List<CartItem> GetCartItemsByCartId(int cart_id) {
        String sql = "SELECT * FROM cart_item where cart_id = " + cart_id;
        List<CartItem> cartItems = _jdbcTemplate.query(sql, new MapperCartItem());

        if (cartItems.size() == 0)
            return null;
        return cartItems;
    }

    public void AddItemToCart(int cartId, int itemId) {
        String sql = "select * from cart_item where ( cart_id = " + cartId
                + " and product_id = " + itemId + " )";

        List<CartItem> cartItem = _jdbcTemplate.query(sql, new MapperCartItem());

        if (cartItem.size() == 0) {
            UpdateQuantityOfItemCart(cartId, itemId, 1);
        } else {
            UpdateQuantityOfItemCart(cartId, itemId, cartItem.get(0).getQuantity() + 1);
        }
    }

    public void DeleteItemFromCart(int cartId, int itemId) {
        UpdateQuantityOfItemCart(cartId, itemId, 0);
    }

    public void EditCart(int cartId, int itemId, int quantity) {
        UpdateQuantityOfItemCart(cartId, itemId, quantity);
    }
    private void UpdateQuantityOfItemCart(int cartId, int itemId, int quantity) {
        String sql = "select * from cart_item where ( cart_id = " + cartId
                + " and product_id = " + itemId + " )";

        List<CartItem> cartItem = _jdbcTemplate.query(sql, new MapperCartItem());

        if (cartItem.size() == 0) {
            CreateCartItem(cartId, itemId);
            cartItem = _jdbcTemplate.query(sql, new MapperCartItem());
        }

        if (quantity == 0) {
            sql = "DELETE FROM cart_item WHERE id = " + cartItem.get(0).getId();
        } else {
            double price = productDao.GetProductById(itemId).getPrice();
            double totalPrice = price * quantity;
            sql = "UPDATE cart_item SET quantity = " + quantity + ", total_price = "+ totalPrice + " WHERE id = " + cartItem.get(0).getId();
        }


        _jdbcTemplate.update(sql);
    }

    private void CreateCartItem(int cartId, int itemId) {
        ProductDto product = productDao.GetProductById(itemId);
        String sql = "INSERT INTO cart_item (`cart_id`, `product_id`, `image`, `name`) " +
                "VALUES (" + cartId + ", " + itemId + ", '" + product.getImage() + "', '" + product.getName() + "')";
        _jdbcTemplate.update(sql);
    }
}
