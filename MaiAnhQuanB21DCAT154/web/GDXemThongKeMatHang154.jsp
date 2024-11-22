<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.ThongKeMatHang154" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kết Quả Thống Kê Mặt Hàng</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            margin: 50px auto;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #007bff;
            color: white;
        }
        table tbody tr:hover {
            background-color: #f1f1f1;
        }
        .details {
            margin-top: 30px;
            padding: 20px;
            background-color: #f5f5f5;
            border: 1px solid #ddd;
            border-radius: 8px;
        }
        p {
            margin: 10px 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Kết Quả Thống Kê Mặt Hàng</h1>

        <!-- Hiển thị thông báo -->
        <%
            String error = (String) request.getAttribute("error");
            String message = (String) request.getAttribute("message");
            if (error != null) { 
        %>
            <p style="color: red; text-align: center;"><%= error %></p>
        <%
            } else if (message != null) { 
        %>
            <p style="color: blue; text-align: center;"><%= message %></p>
        <%
            }
        %>

        <table>
            <thead>
                <tr>
                    <th>Mã MH</th>
                    <th>Tên MH</th>
                    <th>Ngày Giao Dịch</th>
                    <th>Hành Động</th>
                </tr>
            </thead>
            <tbody>
                <%
                    // Lấy danh sách từ Servlet
                    List<model.ThongKeMatHang154> items = (List<model.ThongKeMatHang154>) request.getAttribute("items");
                    model.ThongKeMatHang154 selectedItem = (model.ThongKeMatHang154) request.getAttribute("selectedItem");

                    if (items != null && !items.isEmpty()) {
                        for (model.ThongKeMatHang154 item : items) {
                %>
                <tr>
                    <td><%= item.getMaMH() %></td>
                    <td><%= item.getTenMH() %></td>
                    <td><%= (item.getNgayGiaoDich() != null) ? item.getNgayGiaoDich() : "Không xác định" %></td>
                    <td>
                        <form method="post" action="ThongKeMatHangServlet">
                            <input type="hidden" name="selectedMaMH" value="<%= item.getMaMH() %>">
                            <button type="submit">Xem Chi Tiết</button>
                        </form>
                    </td>
                </tr>
                <% 
                        }
                    } else { 
                %>
                <tr>
                    <td colspan="4" style="text-align: center;">Không có mặt hàng nào trong khoảng thời gian đã chọn.</td>
                </tr>
                <% } %>
            </tbody>
        </table>

        <!-- Phần hiển thị chi tiết mặt hàng -->
        <% if (selectedItem != null) { %>
        <div class="details">
            <h2>Chi Tiết Mặt Hàng</h2>
            <p><strong>Mã MH:</strong> <%= selectedItem.getMaMH() %></p>
            <p><strong>Tên MH:</strong> <%= selectedItem.getTenMH() %></p>
            <p><strong>Loại MH:</strong> <%= selectedItem.getLoaiMH() %></p>
            <p><strong>Giá Tiền:</strong> <%= selectedItem.getGiaTien() %></p>
            <p><strong>Số Lượng Bán:</strong> <%= selectedItem.getSoLuongBan() %></p>
            <p><strong>Doanh Thu:</strong> <%= selectedItem.getDoanhThu() %></p>
            <p><strong>Ngày Giao Dịch:</strong> <%=  selectedItem.getNgayGiaoDich() %></p>
            <p><strong>Giờ Giao Dịch</strong> <%= selectedItem.getGioGiaoDich() %></p>
        </div>
        <% } %>
    </div>
</body>
</html>
