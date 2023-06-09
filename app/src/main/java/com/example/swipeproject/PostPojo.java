package com.example.swipeproject;

public class PostPojo {

    private String image;
    private float price;
    private String product_name;
    private String product_type;
    private float tax;


    // Getter Methods
    
    public String getImage() {
        return image;
    }

    public float getPrice() {
        return price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getProduct_type() {
        return product_type;
    }

    public float getTax() {
        return tax;
    }

    // Setter Methods

    public void setImage( String image ) {
        this.image = image;
    }

    public void setPrice( float price ) {
        this.price = price;
    }

    public void setProduct_name( String product_name ) {
        this.product_name = product_name;
    }

    public void setProduct_type( String product_type ) {
        this.product_type = product_type;
    }

    public void setTax( float tax ) {
        this.tax = tax;
    }
}
