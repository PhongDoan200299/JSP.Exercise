<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1,shrink-to-fit=no">
    <title>Đăng ký</title>
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
  <jsp:include page="../header.jsp" ></jsp:include>
<!-- Kiểm tra đăng nhập -->
	<%
		Object obj = session.getAttribute("khachHang");
		KhachHang khachHang = null;
		if (obj!=null)
			khachHang = (KhachHang)obj;		
			if(khachHang==null){		
	%>
	<h1>Bạn chưa đăng nhập vào hệ thống. Vui lòng quay lại trang chủ!</h1>
	<%
			}else {

				}
	%>
    <div class="container">
  	<%
		String baoLoi = request.getAttribute("baoLoi")+"";
		baoLoi = (baoLoi.equals("null"))?"":baoLoi;
	
		
		String tenDangNhap= request.getAttribute("tenDangNhap")+"";	
		tenDangNhap = (tenDangNhap.equals("null"))?"":tenDangNhap;
		
		String hoVaTen= khachHang.getHoVaTen();
		
		String gioiTinh= khachHang.getGioiTinh();
		
		String ngaySinh= khachHang.getNgaySinh().toString();
		
		String diaChiKhachHang= khachHang.getDiaChi();
		
		String diaChiMuaHang= khachHang.getDiaChiMuaHang();
		
		String diaChiNhanHang= khachHang.getDiaChiNhanHang();
		
		String dienThoai= khachHang.getSoDienThoai();
		
		String email= khachHang.getEmail();
		
		Boolean dongYNhanMail= khachHang.getDangKy();
	%>
    <div class="container">
      <div class="text-center"><h1>THÔNG TIN TÀI KHOẢN</h1></div>
      <div class="red" id="baoLoi">
        <%=baoLoi%>
        <%
	String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
	%>
      </div>
      <form class="form" action="<%=url%>/khach-hang" method="post">
      <input type="hidden" name="hanhDong" value="update-profile">
        <div class="row">
          <div class="col-md-6">
   
            <h3>Thông tin khách hàng</h3>
            <div class="form-group mb-3">
              <label for="hoVaTen" class="form-label">Họ và tên</label>
              <input
                type="text"
                class="form-control"
                id="hoVaTen"
                name="hoVaTen"
                value="<%=hoVaTen%>"
              />
            </div>
            <div class="form-group mb-3">
              			<label for="gioiTinh" class="form-label">Giới tính</label> 
              			<select		  
							class="form-control" id="gioiTinh" name="gioiTinh">
							<option></option>
							<option value="Nam" <%=(gioiTinh.equals("Nam"))?"selected='selected'":"" %> >Nam</option>
							<option value="Nữ" <%=(gioiTinh.equals("Nữ"))?"selected='selected'":"" %> >Nữ</option>
							<option value="Khác" <%=(gioiTinh.equals("Khác"))?"selected='selected'":"" %> >Khác</option>
						</select>
            </div>
            
            <div class="form-group mb-3">
              <label for="ngaySinh" class="form-label">Ngày sinh</label>
              <input
                type="date"
                class="form-control"
                id="ngaySinh"
                name="ngaySinh"
                value="<%=ngaySinh%>"
              />
            </div>
          </div>

          <div class="col-md-6">
            <h3>Địa chỉ</h3>
            <div class="mb-3">
              <label for="diaChiKhachHang" class="form-label"
                >Địa chỉ khách hàng</label
              >
              <input
                type="text"
                class="form-control"
                id="diaChiKhachHang"
                name="diaChiKhachHang"
                value="<%=diaChiKhachHang%>"
              />
            </div>
            <div class="mb-3">
              <label for="diaChiMuaHang" class="form-label"
                >Địa chỉ mua hàng</label
              >
              <input
                type="text"
                class="form-control"
                id="diaChiMuaHang"
                name="diaChiMuaHang"
                value="<%=diaChiMuaHang%>"
              />
            </div>
            <div class="mb-3">
              <label for="diaChiNhanHang" class="form-label"
                >Địa chỉ nhận hàng</label
              >
              <input
                type="text"
                class="form-control"
                id="diaChiNhanHang"
                name="diaChiNhanHang"
                value="<%=diaChiNhanHang%>"
              />
            </div>
            <div class="mb-3">
              <label for="dienThoai" class="form-label">Điện thoại</label>
              <input
                type="number"
                class="form-control"
                id="dienThoai"
                name="dienThoai"
                value="<%=dienThoai%>"
              />
            </div>
            <div class="mb-3">
              <label for="email" class="form-label">Email</label>
              <input
                type="email"
                class="form-control"
                id="email"
                name="email"
                value="<%=email%>"
              />
            </div>

     		<div class="mb-3">
              <label for="dongYNhanMail" class="form-label"
                >Đồng ý nhận mail </label
              >
              <input
                type="checkbox"
                class="form-check-input"
                id="dongYNhanMail"
                name="dongYNhanMail"
                 <%= (dongYNhanMail?"checked":"") %> 
              />
            </div>

            <div>
                <input type="submit" class="btn btn-primary form-control" value="Lưu thông tin" 
                name="submit" id="submit" >
            </div>
          </div>

        </div>
      </form>
    </div>
  </div>
  <jsp:include page="../footer.jsp" ></jsp:include>
  </body>
  
</html>