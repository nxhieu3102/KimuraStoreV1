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

    private StringBuffer SqlString() {
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

    private String SqlNewProduct() {
        StringBuffer sql =  SqlString();
        sql.append("WHERE 1 = 1 ");
        sql.append("AND new_product = 1 ");
        sql.append("ORDER BY RAND() ");
        sql.append("LIMIT 6 ");
        return sql.toString();
    }

    private String SqlRelatedProductsByIDCategory(int id) {
        StringBuffer sql =  SqlString();
        sql.append("WHERE 1 = 1 ");
        sql.append("AND category_id = " + id + " ");
        sql.append("ORDER BY RAND() ");
        sql.append("LIMIT 5 ");
        return sql.toString();
    }

    private String SqlDiscountProduct() {
        StringBuffer sql =  SqlString();
        sql.append("WHERE 1 = 1 ");
        sql.append("AND discount = 1 ");
        sql.append("ORDER BY RAND() ");
        sql.append("LIMIT 6 ");
        return sql.toString();
    }

    private String SqlProductsByID(int id) {
        StringBuffer sql = SqlString();
        sql.append("WHERE 1 = 1 ");
        sql.append("AND id = " + id + " ");
        return sql.toString();
    }

    private String SqlProductsByIDCategory(int id){
        StringBuffer sql = SqlString();
        sql.append("WHERE 1 = 1 ");
        sql.append("AND category_id = " + id + " ");
        return sql.toString();
    }
    public List<ProductDto> GetNewProduct() {
        List<ProductDto> list = new ArrayList<ProductDto>();
        String sql = SqlNewProduct();
        list = _jdbcTemplate.query(sql, new MapperProductDto());
        return list;
    }

    public List<ProductDto> GetDiscountProduct() {
        List<ProductDto> list = new ArrayList<ProductDto>();
        String sql = SqlDiscountProduct();
        list = _jdbcTemplate.query(sql, new MapperProductDto());
        return list;
    }

    public List<ProductDto> GetDataProduct() {
        List<ProductDto> list = new ArrayList<ProductDto>();
        String sql = SqlString().toString();
        list = _jdbcTemplate.query(sql, new MapperProductDto());
        return list;
    }

    public ProductDto GetProductById(int id) {
        List<ProductDto> list = new ArrayList<ProductDto>();
        String sql = SqlProductsByID(id);
        list = _jdbcTemplate.query(sql, new MapperProductDto());
        return list.get(0);
    }

    public List<ProductDto> GetProductByIdCategory(int id) {
        List<ProductDto> list = new ArrayList<ProductDto>();
        String sql = SqlProductsByIDCategory(id);
        list = _jdbcTemplate.query(sql, new MapperProductDto());
        return list;
    }

    public List<ProductDto> GetRelatedProductByIdCategory(int id) {
        List<ProductDto> list = new ArrayList<ProductDto>();
        String sql = SqlRelatedProductsByIDCategory(id);
        list = _jdbcTemplate.query(sql, new MapperProductDto());
        return list;
    }
}
