package KimuraStore.Service.Impl;

import KimuraStore.Dao.BillProductDetailsDao;
import KimuraStore.Entity.CartItem;
import KimuraStore.Service.IBillProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillProductDetailsServiceImpl implements IBillProductDetails {
    @Autowired
    private BillProductDetailsDao billProductDetailsDao;

    @Override
    public void AddProductDetails(int billId, int productId) {
        billProductDetailsDao.AddProductDetails(billId, productId);
    }

    @Override
    public List<CartItem> GetAllCartItemByBillId(int billId) {
        return billProductDetailsDao.GetAllCartItemByBillId(billId);
    }
}
