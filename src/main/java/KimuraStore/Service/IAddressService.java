package KimuraStore.Service;

import KimuraStore.Entity.Address.District;
import KimuraStore.Entity.Address.Province;
import KimuraStore.Entity.Address.Ward;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAddressService {
    public List<District> GetDistrictByProvince(int provinceId);
    public List<Province> GetAllProvince();
    public List<Ward> GetWardByDistrictId(int districtId);
}
