package model;
public class DangKiThanhVien154 {
    private int maTV;
    private String tenTV;
    private String gioitinh;
    private String diachi;
    private String sdt;

    // Constructor
    public DangKiThanhVien154(int maTV, String tenTV, String gioitinh, String diachi, String sdt) {
        this.maTV = maTV;
        this.tenTV = tenTV;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.sdt = sdt;
    }

    // Getters and Setters
    public int getMaTV() {
        return maTV;
    }

    public void setMaTV(int maTV) {
        this.maTV = maTV;
    }

    public String getTenTV() {
        return tenTV;
    }

    public void setTenTV(String tenTV) {
        this.tenTV = tenTV;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
