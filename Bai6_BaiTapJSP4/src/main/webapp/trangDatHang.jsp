<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String hoVaTen = request.getParameter("hoVaTen");
		String email = request.getParameter("email");
		String soLuong = request.getParameter("soLuong");
		int soLuongSanPham = 1;
		try{
			soLuongSanPham = Integer.parseInt(soLuong);
		}catch(Exception e){
			e.printStackTrace();
		}
				
	%>
	<h1>Xác nhận đặt hàng</h1>
	<p> Xin cảm ơn bạn <b><%=hoVaTen %></b> với <b><%=email %></b> đã đặt <b><%=soLuong %></b>
	sản phẩm. </p>
	<p>Số tiền bạn cần thành toán là: </p> <b><%= soLuongSanPham*5%> $</b>
</body>
</html>