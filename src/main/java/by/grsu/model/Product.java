package by.grsu.model;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(name = "product_title")
    public String title;
    @Column(name = "product_price")
    public int price;
    @Column(name = "product_available")
    public int availableCount;

    public Product(){};

    public Product(String title, int price) {
        this.title = title;
        this.price = price;
    }
}
