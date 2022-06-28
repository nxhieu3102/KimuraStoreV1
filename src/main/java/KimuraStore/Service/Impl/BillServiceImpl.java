package KimuraStore.Service.Impl;

import KimuraStore.Dao.BillDao;
import KimuraStore.Entity.Bill;
import KimuraStore.Service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements IBillService {
    @Autowired
    private BillDao billDao;

    @Override
    public void InsertBill(Bill bill) {
        billDao.InsertBill(bill);
    }
}
