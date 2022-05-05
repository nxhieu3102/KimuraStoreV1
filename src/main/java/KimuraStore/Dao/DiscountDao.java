package KimuraStore.Dao;
import KimuraStore.Enity.Discount;
import KimuraStore.Enity.MapperDiscount;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DiscountDao extends BaseDao{
    public List<Discount> GetDataDiscount() {
        List<Discount> list = new ArrayList<Discount>();
        String sql = "SELECT * FROM discount";
        list = _jdbcTemplate.query(sql, new MapperDiscount());
        return list;
    }

    private StringBuffer SqlString() {
        StringBuffer  sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("id, ");
        sql.append("discount_rate, ");
        sql.append("discount_money ");
        sql.append("FROM discount as dc ");
        return sql;
    }

    private String SqlDiscountById(int id) {
        StringBuffer sql = SqlString();
        sql.append("WHERE 1 = 1 ");
        sql.append("AND id = " + id + " ");
        return sql.toString();
    }

    private String SqlDiscountLIMIT() {
        StringBuffer sql =  SqlString();
        sql.append("ORDER BY RAND() ");
        sql.append("LIMIT 6 ");
        return sql.toString();
    }

    public Discount GetDiscountById(int id) {
        List<Discount> list = new ArrayList<Discount>();
        String sql = SqlDiscountById(id);
        list = _jdbcTemplate.query(sql, new MapperDiscount());
        return list.get(0);
    }

    public List<Discount> GetDiscountLIMIT() {
        List<Discount> list = new ArrayList<Discount>();
        String sql = SqlDiscountLIMIT();
        list = _jdbcTemplate.query(sql, new MapperDiscount());
        return list;
    }
}