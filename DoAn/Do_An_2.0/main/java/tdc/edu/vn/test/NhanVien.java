package tdc.edu.vn.test;

public class NhanVien {
    String name;
    String pass;

    public NhanVien(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }
    public NhanVien(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
