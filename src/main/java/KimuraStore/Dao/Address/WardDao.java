package KimuraStore.Dao.Address;

import KimuraStore.Dao.BaseDao;
import KimuraStore.Entity.Address.District;
import KimuraStore.Entity.Address.Mapper.MapperWard;
import KimuraStore.Entity.Address.Ward;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WardDao extends BaseDao {
    public List<Ward> GetWardByDistrictId(int districtId){
        String sql = "SELECT * FROM ward WHERE _district_id = " + districtId;
        List< Ward> wards = _jdbcTemplate.query(sql, new MapperWard());
        return wards;
    }
}
