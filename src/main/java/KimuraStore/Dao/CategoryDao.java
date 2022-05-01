package KimuraStore.Dao;
import KimuraStore.Enity.Category;
import KimuraStore.Enity.MapperCategory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDao extends BaseDao{
    public List<Category> GetDataCategory() {
        List<Category> list = new ArrayList<Category>();
        String sql = "SELECT * FROM category";
        list = _jdbcTemplate.query(sql, new MapperCategory());
        return list;
    }
}
