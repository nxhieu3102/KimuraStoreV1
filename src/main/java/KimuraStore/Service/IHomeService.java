package KimuraStore.Service;

import KimuraStore.Dao.DiscountDao;
import KimuraStore.Dto.ProductDto;
import KimuraStore.Enity.Category;
import KimuraStore.Enity.Discount;
import KimuraStore.Enity.Slide;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IHomeService {
    public List<Slide> GetDataSlide();
    public List<Category> GetDataCategory();
    public List<ProductDto> GetDiscountProduct();
    public List<ProductDto> GetBestSellerProduct();
}
