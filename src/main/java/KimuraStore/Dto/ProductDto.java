package KimuraStore.Dto;

import java.util.Date;

public class ProductDto {
    private int id;
    private int category_id;
    private String name;
    private String deltail;
    private boolean discount;
    private double discount_rate;
    private double discount_money;
    private boolean new_product;
    private double price;
    private Date create_at;
    private Date modify_at;

    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ProductDto() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeltail() {
        return deltail;
    }

    public void setDeltail(String deltail) {
        this.deltail = deltail;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public double getDiscount_rate() {
        return discount_rate;
    }

    public void setDiscount_rate(double discount_rate) {
        this.discount_rate = discount_rate;
    }

    public double getDiscount_money() {
        return discount_money;
    }

    public void setDiscount_money(double discount_money) {
        this.discount_money = discount_money;
    }

    public boolean isNew_product() {
        return new_product;
    }

    public void setNew_product(boolean new_product) {
        this.new_product = new_product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public Date getModify_at() {
        return modify_at;
    }

    public void setModify_at(Date modify_at) {
        this.modify_at = modify_at;
    }
}
