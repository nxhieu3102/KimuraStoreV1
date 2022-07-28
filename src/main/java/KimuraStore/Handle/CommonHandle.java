package KimuraStore.Handle;

import KimuraStore.Dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class CommonHandle {
    public ProductDto HandleDiscount(ProductDto product, Double discountMoney, Double discountRate) {
        if(discountMoney != 0 || discountRate != 0) {
            Double price = product.getPrice();
            if(discountMoney != 0) {
                discountRate = discountMoney / price * 100.0;
            } else {
                discountMoney = discountRate * price / 100.0;
            }
        }
        Math.round(discountMoney);
        Math.round(discountRate);

        product.setDiscount_rate(discountRate);
        product.setDiscount_money(discountMoney);
        return product;
    }
}
