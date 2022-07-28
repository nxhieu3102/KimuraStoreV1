package KimuraStore.Service;

import KimuraStore.Entity.Bill;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBillService {
    public void InsertBill(Bill bill);
    public int GetLastInsertBillId();
    public List<Bill> GetBillsByUserId(int userId);
    public List<Bill> GetBillData();
}
