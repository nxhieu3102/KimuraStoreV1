package KimuraStore.Dao;

import KimuraStore.Entity.Category;
import KimuraStore.Entity.Mapper.MapperCategory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDao extends BaseDao {
    public List<Category> GetDataCategory() {
        List<Category> list = new ArrayList<Category>();
        String sql = "SELECT * FROM category";
        list = _jdbcTemplate.query(sql, new MapperCategory());
        return list;
    }

    public Category GetDataCategoryById(int id) {
        List<Category> list = new ArrayList<Category>();
        String sql = "SELECT * FROM category WHERE id = " + id;
        list = _jdbcTemplate.query(sql, new MapperCategory());

        if(list.size() == 0)
            return null;
        return list.get(0);
    }

    public void AddCategory(String category) {
        //INSERT INTO `kimurastore`.`category` (`name`) VALUES ('Hàn quốc');
        String sql = "INSERT INTO category (`name`) VALUES ('"+category+"')";
        _jdbcTemplate.update(sql);
    }

    public void DeleteCategory(int id) {
//        DELETE FROM `kimurastore`.`category` WHERE (`id` = '3');
        String sql = "DELETE FROM category WHERE id = " + id;
        _jdbcTemplate.update(sql);
    }

    public void UpdateCategory(int id, String name) {
//        UPDATE `kimurastore`.`category` SET `name` = 'abc' WHERE (`id` = '1');
        String sql = "UPDATE category SET name = '" + name + "' WHERE id = " + id;
        _jdbcTemplate.update(sql);
    }
}
