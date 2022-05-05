package KimuraStore.Dto;

import KimuraStore.Dao.ProductOptionsDao;

public class ProductOptionsDto {
    private int productId;
    private String name;

    public ProductOptionsDto() {
        super();
    }
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
