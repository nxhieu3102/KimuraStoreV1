package KimuraStore.Dao;

import KimuraStore.Dto.MapperProductDto;
import KimuraStore.Dto.ProductDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDao extends BaseDao{
    private final boolean YES = true;
    private final boolean NO = false;

    private StringBuffer sqlString() {
        StringBuffer  sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("id, ");
        sql.append("category_id, ");
        sql.append("name, ");
        sql.append("deltail, ");
        sql.append("discount, ");
        sql.append("discount_rate, ");
        sql.append("discount_money, ");
        sql.append("new_product, ");
        sql.append("price, ");
        sql.append("create_at, ");
        sql.append("modify_at, ");
        sql.append("image ");
        sql.append("FROM product as p ");
        return sql;
    }

    private String sqlNewProduct() {
        StringBuffer sql =  sqlString();
        sql.append("WHERE 1 = 1 ");
        sql.append("AND new_product = 1 ");
        sql.append("ORDER BY RAND() ");
        sql.append("LIMIT 6 ");
        return sql.toString();
    }

    private String sqlDiscountProduct() {
        StringBuffer sql =  sqlString();
        sql.append("WHERE 1 = 1 ");
        sql.append("AND discount = 1 ");
        sql.append("ORDER BY RAND() ");
        sql.append("LIMIT 6 ");
        return sql.toString();
    }

    public List<ProductDto> GetNewProduct() {
        List<ProductDto> list = new ArrayList<ProductDto>();
        String sql = sqlNewProduct();
        list = _jdbcTemplate.query(sql, new MapperProductDto());
        return list;
    }

    public List<ProductDto> GetDiscountProduct() {
        List<ProductDto> list = new ArrayList<ProductDto>();
        String sql = sqlDiscountProduct();
        list = _jdbcTemplate.query(sql, new MapperProductDto());
        return list;
    }

    public List<ProductDto> GetDataProduct() {
        List<ProductDto> list = new ArrayList<ProductDto>();
        String sql = sqlString().toString();
        list = _jdbcTemplate.query(sql, new MapperProductDto());
        return list;
    }
}
