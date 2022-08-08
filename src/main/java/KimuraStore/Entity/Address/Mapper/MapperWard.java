package KimuraStore.Entity.Address.Mapper;

import KimuraStore.Entity.Address.Ward;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperWard implements RowMapper<Ward> {
    @Override
    public Ward mapRow(ResultSet resultSet, int i) throws SQLException {
        Ward ward = new Ward();
        ward.setId(resultSet.getInt("id"));
        ward.setName(resultSet.getString("_name"));
        ward.setPrefix(resultSet.getString("_prefix"));
        ward.setDistrictId(resultSet.getInt("_district_id"));
        ward.setProvinceId(resultSet.getInt("_province_id"));

        return ward;
    }
}
