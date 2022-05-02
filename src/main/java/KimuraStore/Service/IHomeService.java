package KimuraStore.Service;

import KimuraStore.Dto.ProductDto;
import KimuraStore.Enity.Category;
import KimuraStore.Enity.Slide;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IHomeService {
    public List<Slide> GetDataSlide();
    public List<ProductDto> GetNewProduct();
    public List<ProductDto> GetDiscountProduct();
    public List<Category> GetDataCategory();
}
