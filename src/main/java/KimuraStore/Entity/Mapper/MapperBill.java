package KimuraStore.Entity.Mapper;

import KimuraStore.Entity.Bill;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperBill implements RowMapper<Bill> {
    @Override
    public Bill mapRow(ResultSet resultSet, int i) throws SQLException {
        Bill bill = new Bill();
        bill.setId(resultSet.getInt("id"));
        bill.setUserId(resultSet.getInt("user_id"));
        bill.setPhone(resultSet.getString("phone"));
        bill.setAddress(resultSet.getString("address"));
        bill.setTotalPrice(resultSet.getDouble("total_price"));
        bill.setName(resultSet.getString("name"));
        bill.setCheckoutDate(resultSet.getDate("date_checkout"));

        return bill;
    }
}
