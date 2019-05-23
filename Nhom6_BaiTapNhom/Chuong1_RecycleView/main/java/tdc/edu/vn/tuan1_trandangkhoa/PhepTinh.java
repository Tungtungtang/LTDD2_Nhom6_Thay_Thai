package tdc.edu.vn.tuan1_trandangkhoa;

public class PhepTinh {
    int image;
    String SoA;
    String SoB;
    String KQ;
    String PT;

    public PhepTinh() {
    }

    public PhepTinh(int image, String soA, String PT, String soB, String KQ) {
        this.image = image;
        SoA = soA;
        this.PT = PT;
        SoB = soB;
        this.KQ = KQ;

    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getSoA() {
        return SoA;
    }

    public void setSoA(String soA) {
        SoA = soA;
    }

    public String getSoB() {
        return SoB;
    }

    public void setSoB(String soB) {
        SoB = soB;
    }

    public String getKQ() {
        return KQ;
    }

    public void setKQ(String KQ) {
        this.KQ = KQ;
    }

    public String getPT() {
        return PT;
    }

    public void setPT(String PT) {
        this.PT = PT;
    }
}
