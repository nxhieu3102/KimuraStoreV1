package KimuraStore.Service.Impl;

import KimuraStore.Dao.CategoryDao;
import KimuraStore.Dao.ProductDao;
import KimuraStore.Dto.ProductDto;
import KimuraStore.Entity.Category;
import KimuraStore.Service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    CategoryDao categoryDao;

    @Autowired
    ProductDao productDao;

    public List<Category> GetDataCategory() {
        return categoryDao.GetDataCategory();
    }

    @Override
    public Category GetDataCategoryById(int id) {
        return categoryDao.GetDataCategoryById(id);
    }

    public List<ProductDto> GetProductByIdCategory(int id) {
        if (id == 0) {
            return productDao.GetDataProduct();
        }
        return productDao.GetProductByIdCategory(id);
    }

    @Override
    public List<ProductDto> GetDataProductsPaginate(int id, int start, int totalProductsInPage) {
        List<ProductDto> products = productDao.GetDataProductsPaginate(id, start, totalProductsInPage);
        return products;
    }


}