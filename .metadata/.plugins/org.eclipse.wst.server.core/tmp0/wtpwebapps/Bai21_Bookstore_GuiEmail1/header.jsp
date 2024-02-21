   <%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1,shrink-to-fit=no">
    <title>Bookstore</title>
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
  
      <%
    	String url = request.getScheme() + "://" + request.getServerName()+ ":"+request.getServerPort() + request.getContextPath(); 
    %>
    <!-- NavBar -->
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">
          <img
            src="https://titv.vn/wp-content/uploads/2022/08/Screenshot-2023-01-29-230321.png"
            alt="Bootstrap"
            height="24"
          />
        </a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="#"
                >Trang chur</a
              >
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Combo giảm giá</a>
            </li>
            <li class="nav-item dropdown">
              <a
                class="nav-link dropdown-toggle"
                href="#"
                role="button"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                Thể loại
              </a>
              
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="#">Quần Jean</a></li>
                <li><a class="dropdown-item" href="#">Áo Thun</a></li>
                <li><hr class="dropdown-divider" /></li>
                <li><a class="dropdown-item" href="#">Áo sơ mi</a></li>
              </ul>
            </li>
            <li class="nav-item">
              <a class="nav-link disabled" aria-disabled="true">Hết hàng</a>
            </li>
          </ul>
          <form class="d-flex" role="search">
            <div >
              <input
              class="form-control me-2"
              type="search"
              placeholder="Nội dung tìm kiếm"
              aria-label="Search"
            />
            <button class="btn btn-outline-success" type="submit">
              Tìm
            </button>
            </div>
            <div class="row">
              <!-- Login Button -->
              <%
              	Object obj = session.getAttribute("khachHang");
              	KhachHang khachHang = null;
              	if(obj != null)
              		khachHang = (KhachHang)obj;
              	
              	if(khachHang == null) {
              %>
              <a href="khachhang/login.jsp" class="btn btn-primary" style="white-space: nowrap;" >
                Đăng nhập
              </a>
              <%} else { %>
                <!-- dropdown menu -->
                  <ul class="navbar-nav me-auto mb-2 mb-lg-0 bg-infor" >
                    <li class="nav-item dropdown dropstart">
                      <a href="#" class="nav-link dropdown-toggle" aria-expanded="false"
                      role="button" data-bs-toggle="dropdown">Tài khoản</a>
	                      <ul class="dropdown-menu">
	                        <li><a class="dropdown-item" href="#">Đơn hàng của tôi</a></li>
	                        <li><a class="dropdown-item" href="#">Thông báo</a></li>
	                        <li><a class="dropdown-item" href="<%=url %>/khachhang/update.jsp">Thay đổi thông tin</a></li>
	                        <li><a class="dropdown-item" href="<%=url %>/khachhang/changePassword.jsp">Đổi mật khẩu</a></li>
	                        <li><hr class="dropdown-divider"></li>
	                        <li><a class="dropdown-item" href="<%=url %>/khach-hang?hanhDong=log-out&">Thoát tài khoản</a></li>
	                      </ul>
                    </li>
                  </ul>
                
                <!-- <div class="row text-center" style="margin-left: 0.25em;">
                  <div class="row">Xin chào <b><%=khachHang.getTenDangNhap() %></b><br></div>
                  <div class="row"><a style="white-space: nowrap;" href="log-out">
                    Đăng xuất
                  </a></div>                
                </div> -->
              <% } %>
            </div>
            
          </form>
        </div>
      </div>
    </nav>
    <!-- End NavBar -->