<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<style>
    .rq {
        color: red;
    }
</style>

</head>
<body>
    <div class="container mt-5">
        <%
        String e_soLuong = request.getAttribute("e_soLuong") + "";
    	String e_soDienThoai = request.getAttribute("e_soDienThoai") + "";
    	String e_email = request.getAttribute("e_email") + "";
	
    	e_soLuong = (e_soLuong.equals("null"))?"":e_soLuong;
    	e_soDienThoai = (e_soDienThoai.equals("null"))?"":e_soDienThoai;
    	e_email = (e_email.equals("null"))?"":e_email;
        %>

        <form action="mua-hang" method="get">
            Số lượng cần mua: <input class="form-control" type="text" name = "soLuong" required/>
            <span class="rq"><%=e_soLuong %></span><br>
            Số điện thoại: <input class="form-control" type="text" name="soDienThoai"required/>
            <span class="rq"><%=e_soDienThoai %></span><br>
            Email: <input class="form-control" type="text" name="email"required/>
            <span class="rq"><%=e_email %></span><br>
            <input class="form-control" type="submit"value="Mua hàng"/>
        </form>
    </div>
</body>
</html>