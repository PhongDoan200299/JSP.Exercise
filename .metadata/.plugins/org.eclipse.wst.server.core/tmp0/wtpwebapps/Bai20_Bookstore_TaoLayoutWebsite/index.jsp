<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
  <body>
  <!-- Header -->
    <!-- NavBar -->

    <%@include file="header.jsp" %>
    <!-- End NavBar -->
    <!-- End Header -->
    <!-- Page content -->
    <div class="container">
      <div class="row">
        <!-- Menu left -->
        <div class="col-lg-3">
          <div class="list-group">
            <a
              href="#"
              class="list-group-item list-group-item-action"
              aria-current="true"
            >
              Thời trang nam
            </a>
            <a href="#" class="list-group-item list-group-item-action"
              >Thời trang nữ</a
            >
            <a href="#" class="list-group-item list-group-item-action"
              >Dành cho bé</a
            >
          </div>
        </div>
        <!--End Menu left -->
        <!-- Slider and Products  -->

        <div class="col-lg-9 ">
			<!-- slider -->
			<div id="carouselExample" class="carousel slide">
				<div class="carousel-inner">
				  <div class="carousel-item active">
					<img src="img/slider/1.jpg" class="d-block w-100" alt="...">
				  </div>
				  <div class="carousel-item">
					<img src="img/slider/2.jpg" class="d-block w-100" alt="...">
				  </div>
				  <div class="carousel-item">
					<img src="img/slider/3.jpg" class="d-block w-100" alt="...">
				  </div>
				</div>
				<button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
				  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
				  <span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
				  <span class="carousel-control-next-icon" aria-hidden="true"></span>
				  <span class="visually-hidden">Next</span>
				</button>
			  </div>
			  <!--End Slider -->
			  <!-- Product -->
			  <div class="row">
				<div class="col-lg-4 col-md-6 mb-4">
					<div class="card h-100">
						<a href="#"><img src="img/product/1.png" alt="" height="250px" class="card-img-top"></a>
						<div class="card-body">
							<h4 class="card-title">
								<a href="#">Aó thun Pro-S1</a>
							</h4>
							<h5>50.000VND</h5>
							<p class="card-text">Sản phẩm thoáng mát, màu sắc tốt</p>
						</div>
						<div class="card-footer">
							<small class="text-muted">&#9733; &#9733;&#9733;&#9733;&#9734</small>
						</div>
					</div>
					
				</div>
				<div class="col-lg-4 col-md-6 mb-4">
					<div class="card h-100">
						<a href="#"><img src="img/product/2.png" alt="" height="250px" class="card-img-top"></a>
						<div class="card-body">
							<h4 class="card-title">
								<a href="#">Aó thun Pro-S1</a>
							</h4>
							<h5>50.000VND</h5>
							<p class="card-text">Sản phẩm thoáng mát, màu sắc tốt</p>
						</div>
						<div class="card-footer">
							<small class="text-muted">&#9733; &#9733;&#9733;&#9733;&#9734</small>
						</div>
					</div>
					
				</div>
				<div class="col-lg-4 col-md-6 mb-4">
					<div class="card h-100">
						<a href="#"><img src="img/product/3.png" alt="" height="250px" class="card-img-top"></a>
						<div class="card-body">
							<h4 class="card-title">
								<a href="#">Aó thun Pro-S1</a>
							</h4>
							<h5>50.000VND</h5>
							<p class="card-text">Sản phẩm thoáng mát, màu sắc tốt</p>
						</div>
						<div class="card-footer">
							<small class="text-muted">&#9733; &#9733;&#9733;&#9733;&#9734</small>
						</div>
					</div>
					
				</div>
			  </div>
			  <!-- End Product -->
		</div>
		        <!--End Slider and Products  -->
      </div>
    </div>
	<!-- End Page content -->
	<!-- Footer -->
	    <%@include file="footer.jsp" %>
	    <!-- End Footer -->
  </body>
</html>
