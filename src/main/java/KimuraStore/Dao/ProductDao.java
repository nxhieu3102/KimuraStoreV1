package KimuraStore.Dao;

import KimuraStore.Dto.MapperProductDto;
import KimuraStore.Dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDao extends BaseDao {
    private String SqlRelatedProductsByIDCategory(int id) {
        String sql = "SELECT * from product WHERE category_id = " + id + " ORDER BY RAND() LIMIT 5";
        return sql;
    }

    private String SqlProductsByID(int id) {
        String sql = "SELECT * FROM product WHERE id = " + id;
        return sql;
    }

    private String SqlProductsByIDCategory(int id) {
        String sql = "SELECT * FROM product WHERE category_id = " + id;
        return sql;
    }

    private String SqlProductsPaginate(int id, int start, int totalProductsInPage) {
        String sql = "SELECT * FROM product " + "LIMIT " + start + ", " + totalProductsInPage;
        return sql;
    }

    private void GetPriceMinMax(List<ProductDto> productDtos) {
        for (ProductDto item : productDtos) {
            item.setPrice_max(item.getPrice());
            item.setPrice(item.getPrice() - item.getDiscount_money());
        }
    }

    private String SqlGetProductsByIdCategoryAndFilter(String price, String name, int id) {
        String sql = "";
        if (id != 0) sql = "SELECT * FROM product WHERE category_id = " + id;
        else sql = "SELECT * FROM product";

        sql = GetFilterSql(price, name, sql);

        return sql;
    }

    private String GetFilterSql(String price, String name, String sql) {
        if (!price.equals("null")) {
            sql += " ORDER BY price " + price;
            if (!name.equals("null")) {
                sql += ", name " + name;
            }
        } else {
            if (!name.equals("null")) {
                sql += "ORDER BY name " + name;
            }
        }
        return sql;
    }

    public List<ProductDto> GetDataProduct() {
        String sql = "SELECT * FROM product";
        List<ProductDto> list = _jdbcTemplate.query(sql, new MapperProductDto());
        GetPriceMinMax(list);
        return list;
    }

    public ProductDto GetProductById(int id) {
        List<ProductDto> list = new ArrayList<ProductDto>();
        String sql = SqlProductsByID(id);
        list = _jdbcTemplate.query(sql, new MapperProductDto());
        GetPriceMinMax(list);

        return list.get(0);
    }

    public List<ProductDto> GetProductByIdCategory(int id) {
        List<ProductDto> list = new ArrayList<ProductDto>();
        String sql = SqlProductsByIDCategory(id).toString();
        list = _jdbcTemplate.query(sql, new MapperProductDto());
        GetPriceMinMax(list);

        return list;
    }

    public List<ProductDto> GetRelatedProductByIdCategory(int id) {
        List<ProductDto> list = new ArrayList<ProductDto>();
        String sql = SqlRelatedProductsByIDCategory(id);
        list = _jdbcTemplate.query(sql, new MapperProductDto());
        GetPriceMinMax(list);
        return list;
    }


    public List<ProductDto> GetDataProductsPaginate(int id, int start, int totalPage) {
        String sqlProductByID = SqlProductsByIDCategory(id).toString();
        if (id == 0) sqlProductByID = "SELECT * FROM product";
        List<ProductDto> listProductsByID = _jdbcTemplate.query(sqlProductByID, new MapperProductDto());

        if (listProductsByID.size() > 0) {
            String sql = SqlProductsPaginate(id, start, totalPage);
            List<ProductDto> listProducts = _jdbcTemplate.query(sql, new MapperProductDto());
            return listProducts;
        }

        return null;
    }

    public List<ProductDto> SearchByName(String keyWord, String price, String name, String category) {
        String sql = "SELECT * FROM product WHERE name LIKE '%" + keyWord + "%'";
        if (!category.equals("null"))
            sql += " AND category_id = " + category;

        sql = GetFilterSql(price, name, sql);

        List<ProductDto> products = _jdbcTemplate.query(sql, new MapperProductDto());
        return products;
    }

    public List<ProductDto> GetProductByIdCategoryAndFilter(String price, String name, int id) {
        String sql = SqlGetProductsByIdCategoryAndFilter(price, name, id);

        List<ProductDto> products = _jdbcTemplate.query(sql, new MapperProductDto());
        return products;
    }

    public List<ProductDto> GetProductsPaginate(String price, String name, int id, int start, int totalProductsInPage) {
        String sql = SqlGetProductsByIdCategoryAndFilter(price, name, id);

        sql += " LIMIT " + start + ", " + totalProductsInPage;
        List<ProductDto> products = _jdbcTemplate.query(sql, new MapperProductDto());
        return products;
    }

    public List<ProductDto> GetAllProduct() {
        String sql = "SELECT * FROM product";
        List<ProductDto> products = _jdbcTemplate.query(sql, new MapperProductDto());
        return products;
    }

    public void AddProduct(ProductDto productDto) {
        //INSERT INTO `kimurastore`.`product` (`category_id`, `name`, `price`, `detail`, `discount_money`, `discount_rate`, `image`) VALUES ('1', 'abc', '123123', 'aaaa', '5', '1400', 'imtem1.jpg');
        String sql = "INSERT INTO product (category_id, name, price, detail, discount_money, discount_rate, image)" +
                " VALUES (" +
                productDto.getCategory_id() + ", '" +
                productDto.getName() + "', " +
                productDto.getPrice() + ", '" +
                productDto.getDetail() + "', " +
                productDto.getDiscount_money() + ", " +
                productDto.getDiscount_rate() + ", '" +
                productDto.getImage() +
                "')";

        _jdbcTemplate.update(sql);
    }

    public void DeleteProduct(int id) {
        String sql = "DELETE FROM product WHERE id = " + id;
        _jdbcTemplate.update(sql);
    }

    public void IncreaseQuantitySell(int productId, int addQuantity) {
        String sql = "SELECT * FROM product WHERE id = " + productId;
        List<ProductDto> products = _jdbcTemplate.query(sql, new MapperProductDto());
        ProductDto product = products.get(0);
        int quantity = product.getQuantity_sell() + addQuantity;
        sql = "UPDATE product SET quantity_sell = " + quantity + " WHERE id = " + productId;
        _jdbcTemplate.update(sql);
    }

}
