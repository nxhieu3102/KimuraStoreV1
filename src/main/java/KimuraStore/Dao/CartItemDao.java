package KimuraStore.Dao;

import KimuraStore.Entity.CartItem;
import KimuraStore.Entity.Mapper.MapperCartItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartItemDao extends BaseDao {
    public List<CartItem> GetCartItemsByIdCart(int cart_id) {
        String sql = "select * from cart_item where cart_id = " + cart_id;
        List<CartItem> cartItemList = _jdbcTemplate.query(sql, new MapperCartItem());

        if(cartItemList.size() == 0)
            return null;
        return cartItemList;
    }

    public CartItem GetProductInCart(int cart_id, int product_id) {
        String sql = "select * from cart_item where (cart_id = " + cart_id + " and product_id = " + product_id + ")";
        List<CartItem> cartItemList = _jdbcTemplate.query(sql, new MapperCartItem());

        if(cartItemList.size() == 0)
            return null;
        return cartItemList.get(0);
    }

    public void InsertCartItem(CartItem cartItem) {
        StringBuffer sql = new StringBuffer();
        sql.append("INSERT ");
        sql.append("into cart_item( ");
        sql.append("cart_id, ");
        sql.append("product_id, ");
        sql.append("quantity ");
        sql.append("total_price ");
        sql.append("values ");
        sql.append("( ");
        sql.append(cartItem.getCart_id()+ ", ");
        sql.append(cartItem.getProduct_id()+ ", ");
        sql.append(cartItem.getQuantity()+ ", ");
        sql.append(cartItem.getTotal_price()+ ", ");
        sql.append(")");

        _jdbcTemplate.update(sql.toString());
    }

    public void UpdateCartItem(CartItem cartItem) {
        String sql = "update cart_item set quantity = "+ cartItem.getQuantity() + ", total_price = " + cartItem.getTotal_price() +
                "where cart_id = " + cartItem.getCart_id() + " and product_id = " + cartItem.getProduct_id();
        _jdbcTemplate.update(sql);
    }

    public void RemoveCartItem(int id) {
        String sql = "delete from cart_item where " + id;
        _jdbcTemplate.update(sql);
    }
}
