package KimuraStore.Service;

import KimuraStore.Dao.Address.DistrictDao;
import KimuraStore.Dao.Address.ProvinceDao;
import KimuraStore.Dao.Address.WardDao;
import KimuraStore.Entity.Address.District;
import KimuraStore.Entity.Address.Province;
import KimuraStore.Entity.Address.Ward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService{
    @Autowired
    private DistrictDao districtDao;

    @Autowired
    private ProvinceDao provinceDao;

    @Autowired
    private WardDao wardDao;

    @Override
    public List<District> GetDistrictByProvince(int provinceId) {
        return districtDao.GetDistrictByProvince(provinceId);
    }

    @Override
    public List<Province> GetAllProvince() {
        return provinceDao.GetAllProvince();
    }

    @Override
    public List<Ward> GetWardByDistrictId(int districtId) {
        return wardDao.GetWardByDistrictId(districtId);
    }
}
