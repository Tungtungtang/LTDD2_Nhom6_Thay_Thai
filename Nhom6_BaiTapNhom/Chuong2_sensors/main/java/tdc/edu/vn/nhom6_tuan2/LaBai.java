package tdc.edu.vn.nhom6_tuan2;

public class LaBai {
    int SoNut;
    String Ten;
    int Hinh;

    public LaBai() {
    }

    public LaBai(int soNut, String ten, int hinh) {
        SoNut = soNut;
        Ten = ten;
        Hinh = hinh;
    }

    public int getSoNut() {
        return SoNut;
    }

    public void setSoNut(int soNut) {
        SoNut = soNut;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}
