<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <meta charset="UTF-8" />
    <title>Bai 13 - Thuc hanh Bookstore</title>
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
            <input
              class="form-control me-2"
              type="search"
              placeholder="Nội dung tìm kiếm"
              aria-label="Search"
            />
            <button class="btn btn-outline-success" type="submit">
              Tìm
            </button>
            
          </form>
        </div>
      </div>
    </nav>
    <!-- End NavBar -->
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
	<footer class="py-3 my-4">
		<ul class="nav justify-content-center border-bottom pb-3 mb-3">
		  <li class="nav-item"><a href="#" class="nav-link px-2 text-body-secondary">Home</a></li>
		  <li class="nav-item"><a href="#" class="nav-link px-2 text-body-secondary">Features</a></li>
		  <li class="nav-item"><a href="#" class="nav-link px-2 text-body-secondary">Pricing</a></li>
		  <li class="nav-item"><a href="#" class="nav-link px-2 text-body-secondary">FAQs</a></li>
		  <li class="nav-item"><a href="#" class="nav-link px-2 text-body-secondary">About</a></li>
		</ul>
		<p class="text-center text-body-secondary">© 2023 Company, Inc</p>
	  </footer>
  </body>
</html>
