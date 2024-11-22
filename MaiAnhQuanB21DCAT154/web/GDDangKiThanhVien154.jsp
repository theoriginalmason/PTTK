<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="model.DangKiThanhVien154" %>
<%@page import="dao.DangKiThanhVienDAO" %>

<%
    String message = "";
    if (request.getMethod().equalsIgnoreCase("POST")) {
        String ten = request.getParameter("ten");
        String gioitinh = request.getParameter("gioitinh");
        String diachi = request.getParameter("diachi");
        String sdt = request.getParameter("sdt");

        ThanhVien154 tv = new ThanhVien154(0, ten, gioitinh, diachi, sdt); // ID tự động
        DangKiThanhVienDAO dao = new DangKiThanhVienDAO();
        boolean result = dao.addDangKiThanhVien(tv);
        if (result) {
            message = "Đăng ký thành công!";
        } else {
            message = "Đăng ký thất bại!";
        }
    }
%>
<html>
    <body>
        <form method="POST" action="GDDangKiThanhVien154.jsp">
            <label for="ten">Tên:</label>
            <input type="text" name="ten" required /><br/>

            <label for="gioitinh">Giới tính:</label>
            <input type="text" name="gioitinh" required /><br/>

            <label for="diachi">Địa chỉ:</label>
            <input type="text" name="diachi" required /><br/>

            <label for="sdt">Số điện thoại:</label>
            <input type="text" name="sdt" required /><br/>

            <button type="submit">Đăng ký</button>
        </form>
        <p><%= message %></p>
    </body>
</html>
