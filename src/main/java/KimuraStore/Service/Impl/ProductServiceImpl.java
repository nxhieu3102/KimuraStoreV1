package KimuraStore.Service.Impl;

import KimuraStore.Dao.ProductDao;
import KimuraStore.Dao.ProductOptionsDao;
import KimuraStore.Dto.ProductDto;
import KimuraStore.Enity.ProductOptions;
import KimuraStore.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductOptionsDao productOptionsDao;

    @Override
    public List<ProductDto> GetAllProductByIdCategory(int id) {
        return productDao.GetProductByIdCategory(id);
    }

    @Override
    public ProductDto GetProductById(int id) {
        return productDao.GetProductById(id);
    }

    @Override
    public List<ProductOptions> GetProductOptionsByIdProduct(int id) {
        return productOptionsDao.GetProductOptionsByIdProduct(id);
    }

    @Override
    public List<ProductDto> GetRelatedProductByIdCategory(int id) {
        return productDao.GetRelatedProductByIdCategory(id);
    }

    @Override
    public ProductOptions GetProductOptionsByIdOption(int id) {
        return productOptionsDao.GetProductOptionsByIdOption(id);
    }

}
