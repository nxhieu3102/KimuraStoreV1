package KimuraStore.Service.Impl;

import KimuraStore.Dao.ProductDao;
import KimuraStore.Dto.ProductDto;
import KimuraStore.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductDao productDao;


    @Override
    public List<ProductDto> GetAllProductByIdCategory(int id) {
        return productDao.GetProductByIdCategory(id);
    }

    @Override
    public ProductDto GetProductById(int id) {
        return productDao.GetProductById(id);
    }



    @Override
    public List<ProductDto> GetRelatedProductByIdCategory(int id) {
        return productDao.GetRelatedProductByIdCategory(id);
    }



    @Override
    public List<ProductDto> SearchByName(String keyWord, String price, String name, String category) {
        return productDao.SearchByName(keyWord, price, name, category);
    }

    @Override
    public List<ProductDto> GetAllProducts() {
        return productDao.GetAllProduct();
    }

    @Override
    public void AddProduct(ProductDto productDto) {
        productDao.AddProduct(productDto);
    }
}
