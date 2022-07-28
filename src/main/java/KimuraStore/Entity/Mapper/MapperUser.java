package KimuraStore.Entity.Mapper;

import KimuraStore.Entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperUser implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setPassword(resultSet.getString("password"));
        user.setDisplay_name(resultSet.getString("display_name"));
        user.setEmail(resultSet.getString("email"));
        user.setResetPasswordToken(resultSet.getString("reset_password_token"));
        user.setResetPasswordTokenTimeCreated(resultSet.getDate("reset_password_token_time_created"));
        user.setRole(resultSet.getString("role"));

        return user;
    }
}
