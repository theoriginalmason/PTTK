package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.DangKiThanhVien154;

public class DangKiThanhVienDAO extends DBConnection {

    public DangKiThanhVienDAO() {
        super();
    }

    public boolean addDangKiThanhVien(DangKiThanhVien154 tv) {
        String sql = "INSERT INTO ThanhVien154 (tenTV, gioitinh, diachi, sdt) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tv.getTenTV());
            ps.setString(2, tv.getGioitinh());
            ps.setString(3, tv.getDiachi());
            ps.setString(4, tv.getSdt());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
