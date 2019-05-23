package tdc.edu.vn.test;

public class QuanLy {
    String sname,spass;

    public QuanLy(String sname, String spass) {
        this.sname = sname;
        this.spass = spass;
    }
    public QuanLy(){}

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSpass() {
        return spass;
    }

    public void setSpass(String spass) {
        this.spass = spass;
    }
}
