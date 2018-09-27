package pl.lukasz.shopping.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_product")
    private int idProduct;
    @NotNull
    @Column(name="product_name")
    private String productName;
    @NotNull
    @Column(name="messure")
    private String measure;
    @Column(name="price")
    private double price;

    public Product() {
    }

    public Product(int idProduct, String productName, String measure, double price) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.measure = measure;
        this.price = price;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
