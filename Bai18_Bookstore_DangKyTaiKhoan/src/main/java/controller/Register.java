package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.KhacHangDAO;
import model.KhachHang;

/**
 * Servlet implementation class Register
 */
@WebServlet(name = "Register", urlPatterns = { "/do-register" })
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tenDangNhap = request.getParameter("tenDangNhap");
		String matKhau = request.getParameter("matKhau");
		String matKhauNhapLai = request.getParameter("matKhauNhapLai");
		String hoVaTen = request.getParameter("hoVaTen");
		String ngaySinh = request.getParameter("ngaySinh");
		String gioiTinh = request.getParameter("gioiTinh");
		String diaChiKhachHang = request.getParameter("diaChiKhachHang");
		String diaChiMuaHang = request.getParameter("diaChiMuaHang");
		String diaChiNhanHang = request.getParameter("diaChiNhanHang");
		String dienThoaiString = request.getParameter("dienThoai");
		int dienThoai = Integer.parseInt(dienThoaiString);

		String email = request.getParameter("email");
		String dongYNhanMail = request.getParameter("dongYNhanMail");
		request.setAttribute("tenDangNhap", tenDangNhap);
		request.setAttribute("hoVaTen", hoVaTen);
		request.setAttribute("ngaySinh", ngaySinh);
		request.setAttribute("gioiTinh", gioiTinh);
		request.setAttribute("diaChiKhachHang", diaChiKhachHang);
		request.setAttribute("diaChiMuaHang", diaChiMuaHang);
		request.setAttribute("diaChiNhanHang", diaChiNhanHang);
		request.setAttribute("dienThoai", dienThoai);
		request.setAttribute("email", email);
		request.setAttribute("dongYNhanMail", dongYNhanMail);

		String url = "";

		String baoLoi = "";
		KhacHangDAO khacHangDAO = new KhacHangDAO();


		if(khacHangDAO.kiemTraTenDangNhap(tenDangNhap)){
			baoLoi += "Tên đăng nhập đã tồn tại, vui lòng chọn tên đăng nhập khác.<br/>";
		}

		if(!matKhau.equals(matKhauNhapLai)){
			baoLoi += "Mật khẩu không khớp.<br/>";
		}
		request.setAttribute("baoLoi", baoLoi);

		if(baoLoi.length() > 0){
			url = "/register.jsp";
			
		}else{
			Random rd = new Random();
			String maKhachHang = System.currentTimeMillis() + rd.nextInt(1000) + "";
			KhachHang kh = new KhachHang(maKhachHang, tenDangNhap, matKhauNhapLai, hoVaTen, gioiTinh, diaChiKhachHang, diaChiNhanHang, diaChiMuaHang, Date.valueOf(ngaySinh), dienThoai, email, dongYNhanMail!=null);
			khacHangDAO.insert(kh);
			
			url ="/success.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
