package dao;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    protected Connection con;

    public DBConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/quanlykhachhang154"; // Thay thế bằng thông tin của bạn
            String user = "root";
            String password = "Quandz1105*";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      public Connection getConnection() {
        return con;
    }
}
