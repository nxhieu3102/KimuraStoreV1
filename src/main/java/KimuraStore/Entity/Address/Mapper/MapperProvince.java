package KimuraStore.Entity.Address.Mapper;

import KimuraStore.Entity.Address.Province;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperProvince implements RowMapper<Province> {

    @Override
    public Province mapRow(ResultSet resultSet, int i) throws SQLException {
        Province province = new Province();
        province.setId(resultSet.getInt("id"));
        province.setName(resultSet.getString("_name"));
        province.setCode(resultSet.getString("_code"));
        return province;
    }
}
