package KimuraStore.Dto;
import java.util.Date;


public class ProductDto {

    private int id;
    private int category_id;
    private String name;
    private String detail;
    private double discount_rate;
    private double discount_money;
    private int quantity_sell;
    private double price;
    private double price_max;
    private Date create_at;
    private Date modify_at;
    private String image;

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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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

    public int getQuantity_sell() {
        return quantity_sell;
    }

    public void setQuantity_sell(int quantity_sell) {
        this.quantity_sell = quantity_sell;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public double getPrice_max() {
        return price_max;
    }

    public void setPrice_max(double price_max) {
        this.price_max = price_max;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
