package KimuraStore.Dto;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperProductDto implements RowMapper<ProductDto> {

    @Override
    public ProductDto mapRow(ResultSet resultSet, int i) throws SQLException {
        ProductDto productDto = new ProductDto();
        productDto.setId(resultSet.getInt("id"));
        productDto.setCategory_id(resultSet.getInt("category_id"));
        productDto.setName(resultSet.getString("name"));
        productDto.setDetail(resultSet.getString("detail"));
        productDto.setDiscount_rate(resultSet.getDouble("discount_rate"));
        productDto.setDiscount_money(resultSet.getDouble("discount_money"));
        productDto.setQuantity_sell(resultSet.getInt("quantity_sell"));
        productDto.setPrice(resultSet.getDouble("price"));
        productDto.setPrice_max(resultSet.getDouble("price_max"));
        productDto.setCreate_at(resultSet.getDate("create_at"));
        productDto.setModify_at(resultSet.getDate("modify_at"));
        productDto.setImage(resultSet.getString("image"));
        return productDto;
    }
}
