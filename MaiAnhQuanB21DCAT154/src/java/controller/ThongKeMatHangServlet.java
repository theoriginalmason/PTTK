package controller;

import dao.ThongKeMatHangDAO;
import model.ThongKeMatHang154;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ThongKeMatHangServlet", urlPatterns = {"/ThongKeMatHangServlet"})
public class ThongKeMatHangServlet extends HttpServlet {

    private ThongKeMatHangDAO thongKeMatHangDAO = new ThongKeMatHangDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin từ form JSP
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String selectedMaMH = request.getParameter("selectedMaMH");
        System.out.println("selectedMaMH: " + request.getParameter("selectedMaMH"));
        // Kiểm tra xem người dùng có nhấn "Xem Chi Tiết" không
    if (selectedMaMH instanceof String) {
    System.out.println("Mã mặt hàng được truyền vào Servlet: " + selectedMaMH);
    try {
        int maMH = Integer.parseInt(selectedMaMH);
        System.out.println("Hi " + maMH);
        ThongKeMatHang154 item = thongKeMatHangDAO.getThongKeByMaMH(maMH);
        System.out.println(item);
        request.setAttribute("selectedItem", item);
        if (item != null) {
            request.setAttribute("selectedItem", item);
            
        } else {
            request.setAttribute("selectedItem", item);
        }
    } catch (NumberFormatException e) {
        request.setAttribute("message", "Mã mặt hàng không hợp lệ.");
    }
}
 else {
            // Xử lý lọc theo khoảng thời gian
            if (startDate == null || startDate.isEmpty() || endDate == null || endDate.isEmpty()) {
                request.setAttribute("error", "Vui lòng chọn khoảng thời gian hợp lệ.");
                request.getRequestDispatcher("GDXemThongKeMatHang154.jsp").forward(request, response);
                return;
            } else {
                // Lấy danh sách mặt hàng trong khoảng thời gian
                List<ThongKeMatHang154> items = thongKeMatHangDAO.getThongKeByDateRange(startDate, endDate);

                // Kiểm tra nếu không có dữ liệu
                if (items == null || items.isEmpty()) {
                    request.setAttribute("message", "Không có mặt hàng nào trong khoảng thời gian đã chọn.");
                } else {
                    request.setAttribute("items", items);
                }
            }

            // Gửi lại thông tin ngày để hiển thị trên giao diện
            request.setAttribute("startDate", startDate);
            request.setAttribute("endDate", endDate);
        }

        // Chuyển hướng đến JSP để hiển thị
        request.getRequestDispatcher("GDXemThongKeMatHang154.jsp").forward(request, response);
    }
}
