package KimuraStore.Service;

import KimuraStore.Dao.ProductDao;
import KimuraStore.Dao.ProductOptionsDao;
import KimuraStore.Dto.ProductDto;
import KimuraStore.Dto.ProductOptionsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    ProductDao productDao;
    @Autowired
    ProductOptionsDao productOptionsDao;

    @Override
    public List<ProductDto> GetAllProductByIdCategory(int id) {
        return productDao.GetProductByIdCategory(id);
    }

    @Override
    public ProductDto GetProductById(int id) {
        return productDao.GetProductById(id);
    }

    @Override
    public List<ProductOptionsDto> GetProductOptionsById(int id) {
        return productOptionsDao.GetProductOptionsById(id);
    }

    @Override
    public List<ProductDto> GetRelatedProductByIdCategory(int id) {
        return productDao.GetRelatedProductByIdCategory(id);
    }
}
