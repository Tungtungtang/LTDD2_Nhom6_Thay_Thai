package tdc.edu.vn.test;

public class Drink {

    private String title;
    private int icon;
    private String mota;
    private String price;


    @Override
    public String toString() {
        return "Drink{" +
                "title='" + title + '\'' +
                ", icon=" + icon +
                ", mota='" + mota + '\'' +
                ", price=" + price +
                '}';
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public void setMota(String noidung) {
        this.mota = noidung;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getIcon() {
        return icon;
    }

    public String getMota() {
        return mota;
    }

    public String getPrice() {
        return price;
    }

    public Drink(String title, int icon, String mota, String price) {
        this.title = title;
        this.icon = icon;
        this.mota = mota;
        this.price = price;
    }
}
