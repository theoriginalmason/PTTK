package controller;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.DangKiThanhVienDAO;
import model.DangKiThanhVien154;
// Định nghĩa đường dẫn URL cho Servlet
@WebServlet("/DangKiThanhVienServlet")
public class DangKyThanhVienServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Hàm xử lý GET yêu cầu
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Chuyển hướng người dùng tới trang đăng ký
        request.getRequestDispatcher("GDDangKiThanhVien154.jsp").forward(request, response);
    }

    // Hàm xử lý POST yêu cầu
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin từ biểu mẫu đăng ký
        String tenTV = request.getParameter("ten");
        String gioitinh = request.getParameter("gioitinh");
        String diachi = request.getParameter("diachi");
        String sdt = request.getParameter("sdt");

        // Tạo đối tượng thành viên
        DangKiThanhVien154 tv = new DangKiThanhVien154(0, tenTV, gioitinh, diachi, sdt);

        // Sử dụng DAO để lưu dữ liệu vào cơ sở dữ liệu
        DangKiThanhVienDAO dao = new DangKiThanhVienDAO();
        boolean isSuccess = dao.addDangKiThanhVien(tv);

        // Kiểm tra kết quả và chuyển hướng tới trang tương ứng
        if (isSuccess) {
            request.setAttribute("message", "Đăng ký thành công!");
        } else {
            request.setAttribute("message", "Đăng ký thất bại!");
        }

        // Chuyển tiếp lại trang đăng ký với thông báo
        request.getRequestDispatcher("GDDangKiThanhVien154.jsp").forward(request, response);
    }
}
