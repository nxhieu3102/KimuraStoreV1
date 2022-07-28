package KimuraStore.Dao;

import KimuraStore.Entity.Bill;
import KimuraStore.Entity.Mapper.MapperBill;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public int GetLastInsertBillId(){
        String sql = "SELECT id FROM bill  ORDER BY id DESC LIMIT 1;";
        Integer id = _jdbcTemplate.queryForObject(sql, Integer.class);
        return id;
    }

    public List<Bill> GetBillsByUserId(int userId){
        String sql = "SELECT * FROM bill WHERE user_id = " + userId;
        List<Bill> bills = _jdbcTemplate.query(sql, new MapperBill());
        return bills;
    }

    public List<Bill> GetBillData() {
        String sql = "SELECT * FROM bill";
        List<Bill> bills = _jdbcTemplate.query(sql, new MapperBill());
        return bills;
    }

    public Bill GetBillById(int id) {
        String sql = "SELECT * FROM bill WHERE id = " + id;
        List<Bill> bill = _jdbcTemplate.query(sql, new MapperBill());

        if(bill.size() == 0)   return null;
        return bill.get(0);
    }
}
