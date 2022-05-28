package KimuraStore.Dao;

import KimuraStore.Entity.Discount;
import KimuraStore.Entity.Mapper.MapperProductOptions;
import KimuraStore.Entity.ProductOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductOptionsDao extends BaseDao {
    @Autowired
    DiscountDao discountDao;
    private void GetDiscountData(List<ProductOptions> list) {
        for (ProductOptions item : list) {
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
    public List<ProductOptions> GetProductOptionsByIdProduct(int id) {
        List<ProductOptions> list = new ArrayList<ProductOptions>();
        String sql = "SELECT * FROM product_option WHERE 1 and product_id = " + id + " ";
        list = _jdbcTemplate.query(sql, new MapperProductOptions());
        GetDiscountData(list);
        return list;
    }

    public ProductOptions GetProductOptionsByIdOption(int id) {
        List<ProductOptions> list = new ArrayList<ProductOptions>();
        String sql = "SELECT * FROM product_option WHERE 1 and id = " + id + " ";
        list = _jdbcTemplate.query(sql, new MapperProductOptions());
        GetDiscountData(list);
        return list.get(0);
    }
}
