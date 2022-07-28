package KimuraStore.Service;

import KimuraStore.Dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    public List<ProductDto> GetAllProductByIdCategory(int id);
    public ProductDto GetProductById(int id);
    public List<ProductDto> GetRelatedProductByIdCategory(int id);
    public List<ProductDto> SearchByName(String keyWord, String price, String name, String category);
    public List<ProductDto> GetAllProducts();
    public void AddProduct(ProductDto productDto);
}
