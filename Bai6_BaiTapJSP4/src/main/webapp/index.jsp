<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang Mua Hang</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
        <form action="trangDatHang.jsp" method="get">
            <div class="mb-3">
                <label for="hoVaTen" class="form-label">Họ và tên
                </label> 
                <input type="text" class="form-control"
                    id="hoVaTen" name="hoVaTen">
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email
                    </label> 
                    <input type="text" class="form-control"
                    id="email" name="email">
    
            </div>
            <div class="mb-3">
                <label for="soLuong" class="form-label">Số lượng mua
                    </label> <input type="text" class="form-control"
                    id="soLuong" name="soLuong">
    
            </div>

           
            <button type="submit" class="btn btn-primary">Đặt hàng</button>
        </form>
    </div>
</body>
</html>