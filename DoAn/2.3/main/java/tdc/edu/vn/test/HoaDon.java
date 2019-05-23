package tdc.edu.vn.test;

import android.support.v7.app.AppCompatActivity;

public class HoaDon extends AppCompatActivity {
    int id_hoadon;
//    int id_ban;
    String ten;
    String gia;
    int SoLuong;

    public HoaDon(int id_hoadon, String ten, String gia, int soLuong) {
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

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }
}
