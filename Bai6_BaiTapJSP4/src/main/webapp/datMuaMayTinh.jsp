<%@page import="java.util.concurrent.locks.Condition"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
      crossorigin="anonymous"
    />
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
      crossorigin="anonymous"
    ></script>
</head>
<body>
	<%
		double tongTien = 0;
		//Radio button 
		// Có chọn => trả value được chọn
		// Không chọn => trả về Null
		String proccesor = request.getParameter("processor");	
		double processorPrice = 0;
		if(proccesor!=null){
			if(proccesor.equals("Core I9")){
				processorPrice += 5000000;
			}else if(proccesor.equals("Core I7")){
				processorPrice += 3000000;
			}else if(proccesor.equals("Core I5")){
				processorPrice += 1000000;
			}
			tongTien += processorPrice;
		}
		
		//
		String ram = request.getParameter("ram");	
		double ramPrice = 0;
			if(ram!=null){
				if(ram.equals("RAM 16GB")){
					ramPrice = ramPrice +  100000;
				}else if(ram.equals("RAM 8GB")){
					ramPrice = ramPrice+  100000;
				}else if(ram.equals("RAM 4GB")){
					ramPrice = ramPrice+  100000;
				}
				tongTien += ramPrice;
			}
		
		//Checkbox 
		//Có chọn => ten = on
		// Không có chọn => không được đề cập
		String monitor = request.getParameter("monitor");
		double monitorPrice = 0;
		if(monitor!= null) {
			monitorPrice += 1500000;
		}
		tongTien += monitorPrice;
		
		//Select
		String [] accessories = request.getParameterValues("accessories");
		double accessoriesPrice = 0;
		if(accessories != null){
			for(String luaChon: accessories){
				if(luaChon.equals("Camera")){
					accessoriesPrice += 800000;
				}
				if(luaChon.equals("Printer")){
					accessoriesPrice += 5000000;
				}
				if(luaChon.equals("Scanner")){
					accessoriesPrice += 1200000;
				}
			}
			tongTien += accessoriesPrice;
		}

	%>

	<h1>HÓA ĐƠN</h1>
	<table class="table">
		<thead>
			<tr>

				<th scope="col">Tên sản phẩm</th>
				<th scope="col">Giá tiền</th>

			</tr>
		</thead>
		<tbody>
		<% if(proccesor!=null) {%>
			<tr>
				<td><%= proccesor %></td>
				<td><%= processorPrice %></td>
			</tr>
		<% } %>	
		<% if(ram!=null) {%>
			<tr>
				<td><%= ram %></td>
				<td><%= ramPrice %></td>
			</tr>
		<% } %>	
		<% if(monitor!=null) {%>
			<tr>
				<td><%= ram %></td>
				<td><%= ramPrice %></td>
			</tr>
		<% } %>	
		<%
		if(accessories != null){
			for(String luaChon: accessories){
				double price = 0;
				if(luaChon.equals("Camera")){
					price += 800000;
				}
				if(luaChon.equals("Printer")){
					price += 5000000;
				}
				if(luaChon.equals("Scanner")){
					price += 1200000;
				}
			
				%>
				<tr>
					<td><%= luaChon %></td>
					<td><%= price %></td>
				</tr>
			
				<% 
				} 
			}
		%>	
				<tr>
					<td>Tổng tiền</td>
					<td><%= Math.round(tongTien) %></td>
				</tr>
		</tbody>
	</table>
</body>
</html>