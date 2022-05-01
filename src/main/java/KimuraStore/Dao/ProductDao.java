package KimuraStore.Dao;

public class ProductDao {
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
        sql.append("highlight, ");
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
        sql.append("AND highlight = 1 ");
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

}
