package KimuraStore.Service.Impl;

import KimuraStore.Dao.CategoryDao;
import KimuraStore.Dao.ProductDao;
import KimuraStore.Dao.SlidesDao;
import KimuraStore.Dto.ProductDto;
import KimuraStore.Entity.Category;
import KimuraStore.Entity.Slide;
import KimuraStore.Service.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class HomeServiceImpl implements IHomeService {

    @Autowired
    private SlidesDao slidesDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CategoryDao categoryDao;
    @Override
    public List<Slide> GetDataSlide() {
        return slidesDao.GetDataSlide();
    }

    @Override
    public List<Category> GetDataCategory() {
        return categoryDao.GetDataCategory();
    }

    public List<ProductDto> GetBestSellerProduct() {
        List<ProductDto> list = productDao.GetDataProduct();
        Collections.sort(list, new Comparator<ProductDto>() {
            public int compare(ProductDto o1, ProductDto o2) {
                return o1.getQuantity_sell() > o2.getQuantity_sell() ? 1 : 0;
            }
        });

        List<ProductDto> BestSellerList = new ArrayList<ProductDto>();

        for (int i = 0; i < Math.min(7, list.size()); i++) {
            BestSellerList.add(list.get(i));
        }

        return BestSellerList;
    }

    public List<ProductDto> GetDiscountProduct() {
        List<ProductDto> products = productDao.GetDataProduct();
        List<ProductDto> discountProducts = new ArrayList<ProductDto>();

        for (ProductDto product: products) {
            if(product.getDiscount_rate() > 0.0) {
                discountProducts.add(product);
            }
        }
        return discountProducts;
    }
}
