package KimuraStore.Entity.Mapper;

import KimuraStore.Entity.CartItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperCartItem implements RowMapper<CartItem> {
    @Override
    public CartItem mapRow(ResultSet resultSet, int i) throws SQLException {
        CartItem cartItem = new CartItem();
        cartItem.setId(resultSet.getInt("id"));
        cartItem.setCartId(resultSet.getInt("cart_id"));
        cartItem.setProductId(resultSet.getInt("product_id"));
        cartItem.setQuantity(resultSet.getInt("quantity"));
        cartItem.setTotalPrice(resultSet.getInt("total_price"));
        cartItem.setImage(resultSet.getString("image"));
        cartItem.setName(resultSet.getString("name"));
        return cartItem;
    }
}
