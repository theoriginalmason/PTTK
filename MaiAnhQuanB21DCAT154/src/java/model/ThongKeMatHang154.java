package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class ThongKeMatHang154 {
    // Thuộc tính
    private int maMH; // Mã mặt hàng
    private String tenMH; // Tên mặt hàng
    private String loaiMH; // Loại mặt hàng
    private int giaTien; // Giá tiền
    private int soLuongBan; // Số lượng bán
    private int doanhThu; // Doanh thu
    private LocalTime gioGiaoDich; // Giờ giao dịch
    private LocalDate ngayGiaoDich; // Ngày giao dịch (thay cho NgayBatDauGiaoDich và NgayKetThucGiaoDich)
    // Constructor
    public ThongKeMatHang154(int maMH, String tenMH, String loaiMH, int giaTien, int soLuongBan, int doanhThu,
                              LocalTime gioGiaoDich,LocalDate ngayGiaoDich) {
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.loaiMH = loaiMH;
        this.giaTien = giaTien;
        this.soLuongBan = soLuongBan;
        this.doanhThu = doanhThu;
        this.gioGiaoDich = gioGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
    }

    // Getter và Setter
    public int getMaMH() {
        return maMH;
    }

    public void setMaMH(int maMH) {
        this.maMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public String getLoaiMH() {
        return loaiMH;
    }

    public void setLoaiMH(String loaiMH) {
        this.loaiMH = loaiMH;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public int getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(int doanhThu) {
        this.doanhThu = doanhThu;
    }


    public LocalTime getGioGiaoDich() {
        return gioGiaoDich;
    }

    public void setGioGiaoDich(LocalTime gioGiaoDich) {
        this.gioGiaoDich = gioGiaoDich;
    }
     public LocalDate getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public void setNgayGiaoDich(LocalDate ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }
}
