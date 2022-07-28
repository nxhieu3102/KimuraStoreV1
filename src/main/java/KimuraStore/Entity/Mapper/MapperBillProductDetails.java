package KimuraStore.Entity.Mapper;

import KimuraStore.Entity.BillProductDetails;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperBillProductDetails implements RowMapper<BillProductDetails> {
    @Override
    public BillProductDetails mapRow(ResultSet resultSet, int i) throws SQLException {
        BillProductDetails billProductDetails = new BillProductDetails();

        billProductDetails.setBillId(resultSet.getInt("bill_id"));
        billProductDetails.setId(resultSet.getInt("id"));
        billProductDetails.setCartItemId(resultSet.getInt("cart_item_id"));

        return billProductDetails;
    }
}
