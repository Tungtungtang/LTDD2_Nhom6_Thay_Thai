package tdc.edu.vn.test;

public class Drink {

    private String title1;

    private String mota;
    private String price;

    public Drink(String title1, String mota, String price) {
        this.title1 = title1;

        this.mota = mota;
        this.price = price;
    }
    public Drink(){};

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
