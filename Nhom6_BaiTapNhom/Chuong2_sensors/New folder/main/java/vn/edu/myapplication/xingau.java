package vn.edu.myapplication;

public class xingau {
    String ten;
    int Hinh;
    public xingau(){};

    public xingau(String ten, int hinh) {
        this.ten = ten;
        Hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}

