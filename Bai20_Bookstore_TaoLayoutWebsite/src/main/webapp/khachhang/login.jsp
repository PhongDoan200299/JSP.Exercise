<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
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
    <style>
      .red {
        color: red;
      }
    </style>
    <!-- Custom styles for this template -->
    <%
    	String url = request.getScheme() + "://" + request.getServerName()+ ":"+request.getServerPort() + request.getContextPath(); 
    %>
    <link href="<%=url%>/css/signin.css" rel="stylesheet" />
  </head>
  <body>
  <jsp:include page="../header.jsp" ></jsp:include>
    <main class="form-signin w-100 m-auto">
      <form class="text-center" action="<%=url%>/khach-hang" method="POST">
      	<input type="hidden" name="hanhDong" value="do-login">
        
        <img
          class="mb-4"
          src="<%=url%>/img/logo/logo.png"
          alt=""
          width="72"
          
        />
        <h1 class="h3 mb-3 fw-normal">ĐĂNG NHẬP</h1>
        <%
        	String baoLoi = request.getAttribute("baoLoi") + "";
        	if(baoLoi.equals("null")){
        		baoLoi="";
        	}
        %>
        
        <div class="text-center"><span class="red"><%=baoLoi%></span></div>
        <div class="form-floating">
          <input
            type="text"
            class="form-control"
            id="tenDangNhap"
            placeholder="Tên đăng nhập"
            name="tenDangNhap"
          />
          <label for="tenDangNhap"name="tenDangNhap">Tên Đăng nhập</label>
        </div>
        <div class="form-floating">
          <input
            type="password"
            class="form-control"
            id="matKhau"
            placeholder="Mật khẩu"
            name="matKhau"
          />
          <label for="matKhau" name="matKhau">Mật khẩu</label>
        </div>

        <div class="form-check text-start my-3">
          <input
            class="form-check-input"
            type="checkbox"
            value="remember-me"
            id="flexCheckDefault"
          />
          <label class="form-check-label" for="flexCheckDefault">
            Ghi nhớ tài khoản này
          </label>
        </div>
        <button class="btn btn-primary w-100 py-2" type="submit">
          Đăng nhập
        </button>
        <a href="register.jsp">Đăng ký tài khoản mới</a>
        <p class="mt-5 mb-3 text-body-secondary">&copy; 2017–2025</p>
      </form>
    </main>
    <jsp:include page="../footer.jsp" ></jsp:include>
  </body>
</html>
