package by.grsu.model;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "product_title")
    private String title;
    @Column(name = "product_price")
    private int price;
    @Column(name = "product_available")
    private int availableCount;

    /*private int initialCount;
    private boolean isBought;*/

    public Product(){};
    public Product(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public Product(String title, int price, int count) {
        this.title = title;
        this.price = price;
        //this.initialCount = count;
        this.availableCount = count;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(int count) {
        this.availableCount = count;
    }

    /*private void incAvailableCount() {
        this.availableCount++;
    }*/

    /*public Boolean decAvailableCount() {
        if (this.availableCount - 1 < 0) {
            return false;
        } else {
            this.availableCount--;
            return true;
        }
    }*/

    /*public boolean isBought() {
        return isBought;
    }

    public void setIsBought(boolean isBought) {
        this.isBought = isBought;
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /*public int getInitialCount() {
        return initialCount;
    }

    public void setInitialCount(int initialCount) {
        this.initialCount = initialCount;
    }*/
}
