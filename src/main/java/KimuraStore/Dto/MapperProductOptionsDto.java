package KimuraStore.Dto;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperProductOptionsDto implements RowMapper<ProductOptionsDto> {

    @Override
    public ProductOptionsDto mapRow(ResultSet resultSet, int i) throws SQLException {
        ProductOptionsDto productOptionsDto =  new ProductOptionsDto();
        productOptionsDto.setProductId(resultSet.getInt("product_id"));
        productOptionsDto.setOptionId(resultSet.getInt("option_id"));
        productOptionsDto.setName(resultSet.getString("name"));
        return productOptionsDto;
    }
}
