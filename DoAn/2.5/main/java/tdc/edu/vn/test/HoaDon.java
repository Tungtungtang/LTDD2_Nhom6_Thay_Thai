package tdc.edu.vn.test;

public class HoaDon {
    int id_hoadon;
//    int id_ban;
    String ten;
    int gia;
    int SoLuong;

    public HoaDon(int id_hoadon, String ten, int gia, int soLuong) {
        this.id_hoadon = id_hoadon;
        this.ten = ten;
        this.gia = gia;
        SoLuong = soLuong;
    }
    public HoaDon(){};

    public int getId_hoadon() {
        return id_hoadon;
    }

    public void setId_hoadon(int id_hoadon) {
        this.id_hoadon = id_hoadon;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }
}
