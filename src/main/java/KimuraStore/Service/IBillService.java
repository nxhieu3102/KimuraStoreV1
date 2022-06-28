package KimuraStore.Service;

import KimuraStore.Entity.Bill;
import org.springframework.stereotype.Service;

@Service
public interface IBillService {
    public void InsertBill(Bill bill);
}
