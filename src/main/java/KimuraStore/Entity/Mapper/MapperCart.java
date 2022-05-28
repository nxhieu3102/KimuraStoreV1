package KimuraStore.Entity.Mapper;

import KimuraStore.Entity.Cart;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperCart implements RowMapper<Cart> {
    @Override
    public Cart mapRow(ResultSet resultSet, int i) throws SQLException {
        Cart cart = new Cart();
        cart.setId(resultSet.getInt("id"));
        cart.setUser_id(resultSet.getInt("user_id"));
        return cart;
    }
}
