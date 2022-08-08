package KimuraStore.Dao.Address;

import KimuraStore.Dao.BaseDao;
import KimuraStore.Entity.Address.District;
import KimuraStore.Entity.Address.Mapper.MapperDistrict;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DistrictDao extends BaseDao {
    public List<District> GetDistrictByProvince(int provinceId){
        List<District> districts = new ArrayList<District>();
        String sql = "SELECT * FROM district WHERE _province_id = " + provinceId;
        districts = _jdbcTemplate.query(sql, new MapperDistrict());
        return districts;
    }
}
