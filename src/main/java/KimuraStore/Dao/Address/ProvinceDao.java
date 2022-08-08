package KimuraStore.Dao.Address;

import KimuraStore.Dao.BaseDao;
import KimuraStore.Entity.Address.Mapper.MapperProvince;
import KimuraStore.Entity.Address.Province;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProvinceDao extends BaseDao {
    public List<Province> GetAllProvince() {
        String sql = "SELECT * FROM province";
        List<Province> provinces = _jdbcTemplate.query(sql, new MapperProvince());
        return provinces;
    }
}
