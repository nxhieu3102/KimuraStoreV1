package KimuraStore.Service;

import KimuraStore.Dto.ProductDto;
import KimuraStore.Enity.ProductOptions;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    public List<ProductDto> GetAllProductByIdCategory(int id);

    public ProductDto GetProductById(int id);

    public List<ProductOptions> GetProductOptionsByIdProduct(int id);

    public List<ProductDto> GetRelatedProductByIdCategory(int id);
    public ProductOptions GetProductOptionsByIdOption(int id);

}
