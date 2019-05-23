package tdc.edu.vn.test;

import java.io.Serializable;

public class Drink implements Serializable {
    private int id;
    private String title1;
    private String mota;
    private int price;



    public Drink(){};

    public Drink(int id, String title1, String mota, int price) {
        this.id = id;
        this.title1 = title1;
        this.mota = mota;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
