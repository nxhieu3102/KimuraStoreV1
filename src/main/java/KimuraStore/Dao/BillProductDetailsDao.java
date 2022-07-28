package KimuraStore.Dao;

import KimuraStore.Entity.BillProductDetails;
import KimuraStore.Entity.CartItem;
import KimuraStore.Entity.Mapper.MapperBillProductDetails;
import KimuraStore.Entity.Mapper.MapperCartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BillProductDetailsDao extends BaseDao{
    @Autowired
    private CartItemDao cartItemDao;

    public List<BillProductDetails> GetProductByBillId(int id){
        String sql = "SELECT * FROM bill_product_details WHERE bill_id = " + id;
        List<BillProductDetails> billProductDetails = _jdbcTemplate.query(sql, new MapperBillProductDetails());
        return billProductDetails;
    }

    public void AddProductDetails(int billId, int cartItemId){
        //INSERT INTO `kimurastore`.`bill_product_details` (`bill_id`, `product_id`) VALUES ('1', '1');
        String sql = "INSERT INTO bill_product_details (`bill_id`, `cart_item_id`) VALUES " +
                "(" + billId + ", " + cartItemId + ");";
        _jdbcTemplate.update(sql);
    }

    public List<CartItem> GetAllCartItemByBillId(int billId) {
        String sql = "SELECT * FROM bill_product_details WHERE bill_id = " + billId;
        List<BillProductDetails> billProductDetails = _jdbcTemplate.query(sql, new MapperBillProductDetails());

        List<CartItem> cartItems = new ArrayList<CartItem>();

        for(BillProductDetails item : billProductDetails) {
            CartItem c = cartItemDao.GetCartItemById(item.getCartItemId());
            cartItems.add(c);
        }
        return cartItems;
    }
}
