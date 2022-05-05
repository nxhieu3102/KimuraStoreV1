package KimuraStore.Service;

import KimuraStore.Dao.CategoryDao;
import KimuraStore.Dao.DiscountDao;
import KimuraStore.Dao.ProductDao;
import KimuraStore.Dao.SlidesDao;
import KimuraStore.Dto.ProductDto;
import KimuraStore.Enity.Category;
import KimuraStore.Enity.Discount;
import KimuraStore.Enity.Slide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class HomeServiceImpl implements IHomeService{

    @Autowired
    private SlidesDao slidesDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private DiscountDao discountDao;
    @Override
    public List<Slide> GetDataSlide() {
        return slidesDao.GetDataSlide();
    }

    @Override
    public List<Category> GetDataCategory(){
        return categoryDao.GetDataCategory();
    }
    @Override
    public List<ProductDto> GetDiscountProduct() {
        List<ProductDto> list = productDao.GetDiscountProduct();
        for(ProductDto item : list) {
            Discount discount = discountDao.GetDiscountById(item.getDiscount_id());
            if(discount.getDiscount_money() > 0) {
                item.setDiscount_money(discount.getDiscount_money());
                item.setDiscount_rate( (double)Math.round( (item.getDiscount_money() / item.getPrice() * 100) * 100) / 100);
            }

            if(discount.getDiscount_rate() > 0) {
                item.setDiscount_rate(discount.getDiscount_rate());
                item.setDiscount_money( (int)(item.getDiscount_rate() / 100 * item.getPrice()) );
            }

            if(item.getDiscount_money() > item.getPrice()) {
                item.setDiscount_money(0);
            }

            if(item.getDiscount_rate() > 100) {
                item.setDiscount_rate(100);
            }

        }
        return list;
    }

    public List<ProductDto> GetBestSellerProduct() {
        List<ProductDto> list = productDao.GetDataProduct();
        Collections.sort(list, new Comparator<ProductDto>() {
            public int compare(ProductDto o1, ProductDto o2) {
                return o1.getQuantity_sell() > o2.getQuantity_sell() ? 1 : 0;
            }
        });

        List<ProductDto> BestSellerList = new ArrayList<ProductDto>();

        for(int i = 0 ; i < 7 ; i++) {
            BestSellerList.add(list.get(i));
        }

        return BestSellerList;
    }
}
