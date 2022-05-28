package KimuraStore.Service;

import KimuraStore.Dto.ProductDto;
import KimuraStore.Entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryService {
    public List<Category> GetDataCategory();

    Category GetDataCategoryById(int id);

    public List<ProductDto> GetProductByIdCategory(int id);

    public List<ProductDto> GetDataProductsPaginate(int id, int start, int totalProductsInPage);
}
