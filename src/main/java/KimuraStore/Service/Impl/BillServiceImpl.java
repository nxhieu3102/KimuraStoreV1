package KimuraStore.Service.Impl;

import KimuraStore.Dao.BillDao;
import KimuraStore.Entity.Bill;
import KimuraStore.Service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements IBillService {
    @Autowired
    private BillDao billDao;

    @Override
    public void InsertBill(Bill bill) {
        billDao.InsertBill(bill);
    }

    @Override
    public int GetLastInsertBillId() {
        return billDao.GetLastInsertBillId();
    }

    @Override
    public List<Bill> GetBillsByUserId(int userId) {
        return billDao.GetBillsByUserId(userId);
    }

    @Override
    public List<Bill> GetBillData() {
        return billDao.GetBillData();
    }
}
