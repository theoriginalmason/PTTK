package dao;

import model.ThongKeMatHang154;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
public class ThongKeMatHangDAO extends DBConnection {

    // Lấy danh sách mặt hàng theo khoảng ngày
  public List<ThongKeMatHang154> getThongKeByDateRange(String startDate, String endDate) {
    List<ThongKeMatHang154> items = new ArrayList<>();
    String query = "SELECT * FROM ThongKeMatHang154 WHERE NgayGiaoDich BETWEEN ? AND ?";
    try (Connection conn = getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, startDate);
        stmt.setString(2, endDate);
        ResultSet rs = stmt.executeQuery();
        System.out.println(rs);
        while (rs.next()) {
            items.add(new ThongKeMatHang154(
                rs.getInt("MaMH"),
                rs.getString("TenMH"),
                rs.getString("LoaiMH"),
                rs.getInt("GiaTien"),
                rs.getInt("SoLuongBan"),
                rs.getInt("DoanhThu"),
                rs.getTime("GioGiaoDich").toLocalTime(),
                rs.getDate("NgayGiaoDich").toLocalDate()
            ));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return items;
}
    // Lấy thông tin chi tiết của một mặt hàng theo maMH
public ThongKeMatHang154 getThongKeByMaMH(int maMH) {
    System.out.println("Truy vấn với mã mặt hàng: " + maMH);
    String query = "SELECT * FROM ThongKeMatHang154 WHERE MaMH = ? ";
    Connection conn = getConnection();
    try (
        PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setInt(1, maMH);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            return new ThongKeMatHang154(
                rs.getInt(maMH),
                rs.getString("TenMH"),
                rs.getString("LoaiMH"),
                rs.getInt("GiaTien"),
                rs.getInt("SoLuongBan"),
                rs.getInt("DoanhThu"),
                rs.getTime("GioGiaoDich").toLocalTime(),
                rs.getDate("NgayGiaoDich").toLocalDate()
            );  
    }} catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
}
