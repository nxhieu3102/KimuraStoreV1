package KimuraStore.Entity.Mapper;

import KimuraStore.Entity.Discount;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperDiscount implements RowMapper<Discount> {

    @Override
    public Discount mapRow(ResultSet resultSet, int i) throws SQLException {
        Discount discount = new Discount();
        discount.setId(resultSet.getInt("id"));
        discount.setDiscount_money(resultSet.getDouble("discount_money"));
        discount.setDiscount_rate(resultSet.getDouble("discount_rate"));
        return discount;
    }
}
