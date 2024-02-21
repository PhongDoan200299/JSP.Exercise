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
  </head>
  <body>
    <div class="container">
      <h1>Chọn cấu hình máy tính bạn cần mua</h1>
      <hr />
      <form action="datMuaMayTinh.jsp">
        <h2>Processor</h2>
        <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="processor"
            value="Core I9"
            id="coreI9"
          />
          <label class="form-check-label" for="coreI9"> core I9 </label>
        </div>
        <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="processor"
            value="Core I7"
            id="coreI7"
            checked
          />
          <label class="form-check-label" for="coreI7"> Core I7 </label>
        </div>
        <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="processor"
            value="Core I5"
            id="coreI5"
            checked
          />
          <label class="form-check-label" for="coreI5"> Core I5 </label>
        </div>
		<h2>RAM</h2>
		<div class="form-check">
		  <input
		    class="form-check-input"
		    type="radio"
		    name="ram"
		    value="RAM 16GB"
		    id="ram16Gb"
		  />
		  <label class="form-check-label" for="ram16Gb">RAM 16GB</label>
		</div>
		<div class="form-check">
		  <input
		    class="form-check-input"
		    type="radio"
		    name="ram"
		    value="RAM 8GB"
		    id="ram8Gb"
		    checked
		  />
		  <label class="form-check-label" for="ram8Gb">RAM 8GB</label>
		</div>
		<div class="form-check">
		  <input
		    class="form-check-input"
		    type="radio"
		    name="ram"
		    value="RAM 4GB"
		    id="ram4Gb"
		  />
		  <label class="form-check-label" for="ram4Gb">RAM 4GB</label>
		</div>
        <h2>OUTSIDE</h2>
        <div class="form-check">
          <input
            class="form-check-input"
            type="checkbox"
            value="Monitor"
            id="monitor"
            name=""
            checked
          />
          <label class="form-check-label" for="monitor"> Monitor </label>
        </div>
        <h2>Accessories</h2>
        <select
          class="form-select"
          multiple aria-label="multiple select example"
          aria-label="Default select example"
          name="accessories"
        >
          <option value="Camera">Camera</option>
          <option value="Printer">Printer</option>
          <option value="Scanner">Scanner</option>
        </select>
        <button class="btn btn-primary mt-2">Buy</button>
      </form>
    </div>
  </body>
</html>
