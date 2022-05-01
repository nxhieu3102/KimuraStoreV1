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
        productDto.setDeltail(resultSet.getString("deltail"));
        productDto.setDiscount(resultSet.getBoolean("discount"));
        productDto.setDiscount_rate(resultSet.getDouble("discount_rate"));
        productDto.setDiscount_money(resultSet.getDouble("discount_money"));
        productDto.setNew_product(resultSet.getBoolean("new_product"));
        productDto.setPrice(resultSet.getDouble("price"));
        productDto.setCreate_at(resultSet.getDate("create_at"));
        productDto.setModify_at(resultSet.getDate("modify_at"));
        productDto.setImage(resultSet.getString("image"));
        return productDto;
    }
}
