package KimuraStore.Service;

import KimuraStore.Dao.CategoryDao;
import KimuraStore.Enity.Category;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    public List<Category> GetDataCategory(){
        CategoryDao categoryDao = new CategoryDao();
        return  categoryDao.GetDataCategory();
    }
}
