package KimuraStore.Entity.Address.Mapper;

import KimuraStore.Entity.Address.District;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperDistrict implements RowMapper<District> {
    @Override
    public District mapRow(ResultSet resultSet, int i) throws SQLException {
        District district = new District();
        district.setId(resultSet.getInt("id"));
        district.setName(resultSet.getString("_name"));
        district.setPrefix(resultSet.getString("_prefix"));
        district.setProvinceId(resultSet.getInt("_province_id"));
        return district;
    }
}
