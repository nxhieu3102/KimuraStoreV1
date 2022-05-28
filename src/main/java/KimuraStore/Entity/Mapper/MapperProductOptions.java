package KimuraStore.Entity.Mapper;

import KimuraStore.Entity.ProductOptions;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperProductOptions implements RowMapper<ProductOptions> {

    @Override
    public ProductOptions mapRow(ResultSet resultSet, int i) throws SQLException {
        ProductOptions productOptionsDto = new ProductOptions();
        productOptionsDto.setProductId(resultSet.getInt("product_id"));
        productOptionsDto.setName(resultSet.getString("name"));
        productOptionsDto.setPrice(resultSet.getDouble("price"));
        productOptionsDto.setId(resultSet.getInt("id"));
        productOptionsDto.setDiscount_id(resultSet.getInt("discount_id"));
        productOptionsDto.setDiscount_rate(resultSet.getDouble("discount_rate"));
        productOptionsDto.setDiscount_money(resultSet.getDouble("discount_money"));
        return productOptionsDto;
    }
}
