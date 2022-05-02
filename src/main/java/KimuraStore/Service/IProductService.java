package KimuraStore.Service;

import KimuraStore.Dto.ProductDto;
import KimuraStore.Dto.ProductOptionsDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    public List<ProductDto> GetAllProductByIdCategory(int id);
    public ProductDto GetProductById(int id);

    public List<ProductOptionsDto> GetProductOptionsById(int id);

    public List<ProductDto> GetRelatedProductByIdCategory(int id);
}
