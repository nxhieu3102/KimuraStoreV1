package KimuraStore.Service;

import KimuraStore.Dto.ProductDto;
import KimuraStore.Entity.Category;
import KimuraStore.Entity.Slide;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IHomeService {
    public List<Slide> GetDataSlide();

    public List<Category> GetDataCategory();

    public List<ProductDto> GetDiscountProduct();

    public List<ProductDto> GetBestSellerProduct();
}
