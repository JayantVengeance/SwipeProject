package com.example.swipeproject;

public class DataModal {

    String product_name;
    String product_type;
    String product_price;
    String tax;
    String image;

    public DataModal( String product_name ,String product_type ,String product_price ,String tax ,String image)
    {
        this.product_name=product_name;
        this.product_type=product_type;
        this.product_price=product_price;
        this.tax=tax;
        this.image=image;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
