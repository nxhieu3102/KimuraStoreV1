package KimuraStore.Dao;

import KimuraStore.Dto.MapperProductDto;
import KimuraStore.Dto.ProductDto;
import KimuraStore.Entity.Discount;
import KimuraStore.Entity.ProductOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDao extends BaseDao {
    @Autowired
    ProductOptionsDao productOptionsDao;

    @Autowired
    DiscountDao discountDao;

    private StringBuffer SqlString() {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("id, ");
        sql.append("category_id, ");
        sql.append("name, ");
        sql.append("detail, ");
        sql.append("discount_id, ");
        sql.append("discount_rate, ");
        sql.append("discount_money, ");
        sql.append("quantity_sell, ");
        sql.append("price, ");
        sql.append("price_min, ");
        sql.append("price_max, ");
        sql.append("create_at, ");
        sql.append("modify_at, ");
        sql.append("image ");
        sql.append("FROM product as p ");
        return sql;
    }

    private String SqlRelatedProductsByIDCategory(int id) {
        StringBuffer sql = SqlString();
        sql.append("WHERE 1 = 1 ");
        sql.append("AND category_id  = " + id + " ");
        sql.append("ORDER BY RAND() ");
        sql.append("LIMIT 5 ");
        return sql.toString();
    }

    private StringBuffer SqlProductsByID(int id) {
        StringBuffer sql = SqlString();
        sql.append("WHERE 1 = 1 ");
        sql.append("AND id = " + id + " ");
        return sql;
    }

    private StringBuffer SqlProductsByIDCategory(int id) {
        StringBuffer sql = SqlString();
        sql.append("WHERE 1 = 1 ");
        sql.append("AND category_id = " + id + " ");
        return sql;
    }

    private String SqlDiscountProduct() {
        StringBuffer sql = SqlString();
        sql.append("WHERE 1 = 1 ");
        sql.append("AND discount_id > 0 ");
        return sql.toString();
    }

    private String SqlProductsPaginate(int id, int start, int totalProductsInPage) {
        StringBuffer sql = SqlProductsByIDCategory(id);
        sql.append("LIMIT " + start + ", " + totalProductsInPage);
        return sql.toString();
    }

    private void GetPriceMinMax(List<ProductDto> productDtos) {
        for (ProductDto item : productDtos) {
            List<ProductOptions> productOptionsList = productOptionsDao.GetProductOptionsByIdProduct(item.getId());
            item.setPrice_max(item.getPrice());
            item.setPrice_min(item.getPrice());
            if (productOptionsList.size() == 0) continue;
            for (ProductOptions option : productOptionsList) {
                item.setPrice_max(Math.max(item.getPrice_max(), option.getPrice()));
                item.setPrice_min(Math.min(item.getPrice_min(), option.getPrice()));
            }
        }
    }

    private void GetDiscountPrice(List<ProductDto> productDtos) {
        for (ProductDto item : productDtos) {
            if(item.getDiscount_id() == 0) continue;
            Discount discount = discountDao.GetDiscountById(item.getDiscount_id());
            if (discount.getDiscount_money() > 0) {
                item.setDiscount_money(discount.getDiscount_money());
                item.setDiscount_rate((double) Math.round((item.getDiscount_money() / item.getPrice() * 100) * 100) / 100);
            }

            if (discount.getDiscount_rate() > 0) {
                item.setDiscount_rate(discount.getDiscount_rate());
                item.setDiscount_money((int) (item.getDiscount_rate() / 100 * item.getPrice()));
            }

            if (item.getDiscount_money() > item.getPrice()) {
                item.setDiscount_money(0);
            }

            if (item.getDiscount_rate() > 100) {
                item.setDiscount_rate(100);
            }
        }
    }

    public List<ProductDto> GetDataProduct() {
        List<ProductDto> list = new ArrayList<ProductDto>();
        String sql = SqlString().toString();
        list = _jdbcTemplate.query(sql, new MapperProductDto());
        GetPriceMinMax(list);
        GetDiscountPrice(list);
        return list;
    }

    public ProductDto GetProductById(int id) {
        List<ProductDto> list = new ArrayList<ProductDto>();
        String sql = SqlProductsByID(id).toString();
        list = _jdbcTemplate.query(sql, new MapperProductDto());
        GetPriceMinMax(list);
        GetDiscountPrice(list);
        return list.get(0);
    }

    public List<ProductDto> GetProductByIdCategory(int id) {
        List<ProductDto> list = new ArrayList<ProductDto>();
        String sql = SqlProductsByIDCategory(id).toString();
        list = _jdbcTemplate.query(sql, new MapperProductDto());
        GetPriceMinMax(list);
        GetDiscountPrice(list);
        return list;
    }

    public List<ProductDto> GetRelatedProductByIdCategory(int id) {
        List<ProductDto> list = new ArrayList<ProductDto>();
        String sql = SqlRelatedProductsByIDCategory(id);
        list = _jdbcTemplate.query(sql, new MapperProductDto());
        GetPriceMinMax(list);
        GetDiscountPrice(list);
        return list;
    }

    public List<ProductDto> GetDiscountProduct() {
        List<ProductDto> list = new ArrayList<ProductDto>();
        String sql = SqlDiscountProduct();
        list = _jdbcTemplate.query(sql, new MapperProductDto());
        GetPriceMinMax(list);
        GetDiscountPrice(list);
        return list;
    }

    public List<ProductDto> GetDataProductsPaginate(int id, int start, int totalPage) {
        String sqlProductByID = SqlProductsByIDCategory(id).toString();
        List<ProductDto> listProductsByID = _jdbcTemplate.query(sqlProductByID, new MapperProductDto());

        if (listProductsByID.size() > 0) {
            String sql = SqlProductsPaginate(id, start, totalPage);
            List<ProductDto> listProducts = _jdbcTemplate.query(sql, new MapperProductDto());
            return listProducts;
        }

        return null;
    }


}
