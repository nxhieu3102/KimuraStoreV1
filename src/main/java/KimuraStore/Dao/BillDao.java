package KimuraStore.Dao;

import KimuraStore.Entity.Bill;
import org.springframework.stereotype.Repository;

@Repository
public class BillDao extends BaseDao {
    public void InsertBill(Bill bill) {
//        INSERT INTO `kimurastore`.`bill` (`user_id`, `cart_id`, `phone`, `address`, `total_price`, `name`, `date_checkout`) VALUES ('1', '1', '1', '1', '1', '1', '1');

        String sql = "INSERT INTO bill (user_id, phone, address, total_price, name, date_checkout) values " +
                "( " +
                bill.getUserId() + ", " +
                "'" + bill.getPhone() + "', " +
                "'" + bill.getAddress() + "', " +
                bill.getTotalPrice() + ", " +
                "'" + bill.getName() + "', " +
                "'" + java.time.LocalDate.now() + "'" +
                " )";

        _jdbcTemplate.update(sql);
    }
}
