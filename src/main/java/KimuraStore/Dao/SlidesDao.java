package KimuraStore.Dao;
import KimuraStore.Entity.Mapper.MapperSlide;
import KimuraStore.Entity.Slide;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SlidesDao extends BaseDao{
    public List<Slide> GetDataSlide() {
        List<Slide> list = new ArrayList<Slide>();
        String sql = "SELECT * FROM slide";
        list = _jdbcTemplate.query(sql, new MapperSlide());
        return list;
    }
}
