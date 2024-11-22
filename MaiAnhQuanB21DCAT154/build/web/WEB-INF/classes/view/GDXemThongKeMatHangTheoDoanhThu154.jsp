<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Xem Thống Kê Mặt Hàng Theo Doanh Thu</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            text-align: center;
            background-color: #ffffff;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 400px;
        }
        .container h1 {
            font-size: 24px;
            color: #333;
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 15px;
            text-align: left;
        }
        label {
            font-size: 16px;
            color: #555;
        }
        input[type="date"] {
            width: 100%;
            padding: 10px;
            font-size: 14px;
            margin-top: 5px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        button {
            background-color: #007bff;
            color: #ffffff;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Xem Thống Kê Mặt Hàng</h1>
        <form action="ThongKeMatHangServlet" method="POST">
            <div class="form-group">
                <label for="startDate">Chọn ngày bắt đầu:</label>
                <input type="date" id="startDate" name="startDate" required>
            </div>
            <div class="form-group">
                <label for="endDate">Chọn ngày kết thúc:</label>
                <input type="date" id="endDate" name="endDate" required>
            </div>
            <button type="submit">Xem Thống Kê</button>
        </form>
    </div>
</body>
</html>
