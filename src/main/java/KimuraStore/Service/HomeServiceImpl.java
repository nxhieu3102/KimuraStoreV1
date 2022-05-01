package KimuraStore.Service;

import KimuraStore.Dao.ProductDao;
import KimuraStore.Dao.SlidesDao;
import KimuraStore.Dto.ProductDto;
import KimuraStore.Enity.Slide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements IHomeService{

    @Autowired
    private SlidesDao slidesDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Slide> GetDataSlide() {
        return slidesDao.GetDataSlide();
    }

    @Override
    public List<ProductDto> GetNewProduct() {
        return productDao.GetNewProduct();
    }

    @Override
    public List<ProductDto> GetDiscountProduct() {
        List<ProductDto> list = productDao.GetDiscountProduct();
        for(ProductDto item : list) {
            if(item.getDiscount_rate() == 0) {
                item.setDiscount_rate(item.getDiscount_money() / item.getPrice() * 100);
            }
            if(item.getDiscount_money() == 0) {
                item.setDiscount_money(item.getDiscount_rate() / 100 * item.getPrice());
            }
        }
        return list;
    }
}
