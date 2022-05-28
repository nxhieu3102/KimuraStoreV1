package KimuraStore.Entity.Mapper;

import KimuraStore.Entity.CartItem;
import KimuraStore.Entity.Category;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperCartItem implements RowMapper<CartItem> {
    @Override
    public CartItem mapRow(ResultSet resultSet, int i) throws SQLException {
        CartItem cartItem = new CartItem();
        cartItem.setId(resultSet.getInt("id"));
        cartItem.setCart_id(resultSet.getInt("cart_id"));
        cartItem.setProduct_id(resultSet.getInt("product_id"));
        cartItem.setQuantity(resultSet.getInt("quantity"));
        cartItem.setTotal_price(resultSet.getDouble("total_price"));
        return cartItem;
    }
}
