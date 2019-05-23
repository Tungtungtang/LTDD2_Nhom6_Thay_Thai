package tdc.edu.vn.test;

import java.io.Serializable;

public class Food implements Serializable {
    private int id;
    private String title;
    private String mota;
    private String price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Food(int id, String title, String mota, String price) {
        this.id = id;
        this.title = title;
        this.mota = mota;
        this.price = price;
    }

    public Food(){};
}
