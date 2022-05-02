package KimuraStore.Dao;

import KimuraStore.Dto.MapperProductOptionsDto;
import KimuraStore.Dto.ProductOptionsDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductOptionsDao extends BaseDao{
    public List<ProductOptionsDto> GetProductOptionsById(int id) {
        List<ProductOptionsDto> list = new ArrayList<ProductOptionsDto>();
        String sql = "SELECT * FROM product_option WHERE 1 and product_id = " + id + " ";
        list = _jdbcTemplate.query(sql, new MapperProductOptionsDto());
        return list;
    }
}
