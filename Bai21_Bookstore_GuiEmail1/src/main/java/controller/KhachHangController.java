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
import javax.servlet.http.HttpSession;

import database.KhacHangDAO;
import model.KhachHang;
import util.CodesVerification;
import util.MaHoa;

/**
 * Servlet implementation class KhachHang
 */
@WebServlet("/khach-hang")
public class KhachHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KhachHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hanhDong = request.getParameter("hanhDong");
		if(hanhDong.equals("do-login")) {
			this.dangNhap(request, response);
		}else if (hanhDong.equals("log-out")) {
			this.dangXuat(request, response);
		}else if (hanhDong.equals("register")) {
			this.register(request, response);
		}else if (hanhDong.equals("change-password")) {
			this.changePassword(request, response);
		}else if (hanhDong.equals("update-profile")) {
			this.updateProfile(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void dangNhap(HttpServletRequest request, HttpServletResponse response) {
		try {
			String tenDangNhap = request.getParameter("tenDangNhap");
			String matKhau = request.getParameter("matKhau");
			matKhau = MaHoa.toSHA1(matKhau);
			
			
			KhachHang kh = new KhachHang();
			kh.setTenDangNhap(tenDangNhap);
			kh.setMatKhau(matKhau);
			
			
			
			KhacHangDAO khd = new KhacHangDAO();
			KhachHang khachHang = khd.selectByUsernameAndPassword(kh);
			String url = "";
			if (khachHang != null) {
				HttpSession session = request.getSession();
				session.setAttribute("khachHang", khachHang);
				url = "/index.jsp";
				
			} else {
				request.setAttribute("baoLoi", "Tên đăng nhập hoặc mật khẩu không chính xác");
				url = "/khachhang/login.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private void dangXuat(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			//Hủy bỏ session
			session.invalidate();
			
			String url = request.getScheme() + "://" + request.getServerName()+ ":"+request.getServerPort() + request.getContextPath(); 
			response.sendRedirect(url+"/index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void register(HttpServletRequest request, HttpServletResponse response)  {
		try {
			String tenDangNhap = request.getParameter("tenDangNhap");
			String matKhau = request.getParameter("matKhau");
			String matKhauNhapLai = request.getParameter("matKhauNhapLai");
			String hoVaTen = request.getParameter("hoVaTen");
			String ngaySinh = request.getParameter("ngaySinh");
			String gioiTinh = request.getParameter("gioiTinh");
			String diaChiKhachHang = request.getParameter("diaChiKhachHang");
			String diaChiMuaHang = request.getParameter("diaChiMuaHang");
			String diaChiNhanHang = request.getParameter("diaChiNhanHang");
			String soDienThoai = request.getParameter("dienThoai");


			String email = request.getParameter("email");
			String dongYNhanMail = request.getParameter("dongYNhanMail");
			request.setAttribute("tenDangNhap", tenDangNhap);
			request.setAttribute("hoVaTen", hoVaTen);
			request.setAttribute("ngaySinh", ngaySinh);
			request.setAttribute("gioiTinh", gioiTinh);
			request.setAttribute("diaChiKhachHang", diaChiKhachHang);
			request.setAttribute("diaChiMuaHang", diaChiMuaHang);
			request.setAttribute("diaChiNhanHang", diaChiNhanHang);
			request.setAttribute("dienThoai", soDienThoai);
			request.setAttribute("email", email);
			request.setAttribute("dongYNhanMail", dongYNhanMail);

			String url = "";

			String baoLoi = "";
			KhacHangDAO khacHangDAO = new KhacHangDAO();

			if (khacHangDAO.kiemTraTenDangNhap(tenDangNhap)) {
				baoLoi += "Tên đăng nhập đã tồn tại, vui lòng chọn tên đăng nhập khác.<br/>";
			}

			if (!matKhau.equals(matKhauNhapLai)) {
				baoLoi += "Mật khẩu không khớp.<br/>";
			} else {
				matKhau = MaHoa.toSHA1(matKhau);
			}
			request.setAttribute("baoLoi", baoLoi);

			if (baoLoi.length() > 0) {
				url = "/khachhang/register.jsp";

			} else {
				Random rd = new Random();
				String maKhachHang = System.currentTimeMillis() + rd.nextInt(1000) + "";
				KhachHang kh = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChiKhachHang, diaChiNhanHang, diaChiMuaHang, Date.valueOf(ngaySinh),soDienThoai, email, dongYNhanMail != null);
				if(khacHangDAO.insert(kh)>0) {
					String codesVerification = CodesVerification.getCodesVerification();
					
					
				}

				url = "/khachhang/success.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	private void changePassword(HttpServletRequest request, HttpServletResponse response) {
		try {
			String matKhauHienTai = request.getParameter("matKhauHienTai");
			String matKhauMoi = request.getParameter("matKhauMoi");
			String matKhauMoiNhapLai = request.getParameter("matKhauMoiNhapLai");
			
			String matKhauHienTai_Sha1 = MaHoa.toSHA1(matKhauHienTai);
			
			String baoLoi = "null";
			String url = "/khachhang/changePassword.jsp";
			
			// Kiem tra mat khau cu co giong hay khong
			Object obj = request.getSession().getAttribute("khachHang");
			KhachHang khachHang = null;
			if (obj!=null)
				khachHang = (KhachHang)obj;		
			if(khachHang==null) {
				baoLoi = "Bạn chưa đăng nhập vào hệ thống!";
			}else {
				// Neu khach hang da dang nhap
				if(!matKhauHienTai_Sha1.equals(khachHang.getMatKhau())){
					baoLoi = "Mật khẩu hiện tại không chính xác!";
				}else {
					if(!matKhauMoi.equals(matKhauMoiNhapLai)) {
						baoLoi = "Mật khẩu nhập lại không khớp!";
					}else {
						String matKhauMoi_Sha1 = MaHoa.toSHA1(matKhauMoi);
						khachHang.setMatKhau(matKhauMoi_Sha1);
						KhacHangDAO khd = new KhacHangDAO();
						if(khd.changePassword(khachHang) != 0) {
							baoLoi = "Mật khẩu đã thay đổi thành công!";
						}else {
							baoLoi = "Quá trình thay đổi mật khẩu không thành công!";
						}
					}
				}
			}
			
			request.setAttribute("baoLoi", baoLoi);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	

	private void updateProfile(HttpServletRequest request, HttpServletResponse response) {
		try {
			String hoVaTen = request.getParameter("hoVaTen");
			String ngaySinh = request.getParameter("ngaySinh");
			String gioiTinh = request.getParameter("gioiTinh");
			String diaChiKhachHang = request.getParameter("diaChiKhachHang");
			String diaChiMuaHang = request.getParameter("diaChiMuaHang");
			String diaChiNhanHang = request.getParameter("diaChiNhanHang");
			String soDienThoai = request.getParameter("dienThoai");

			String email = request.getParameter("email");
			String dongYNhanMail = request.getParameter("dongYNhanMail");
			
			request.setAttribute("hoVaTen", hoVaTen);
			request.setAttribute("ngaySinh", ngaySinh);
			request.setAttribute("gioiTinh", gioiTinh);
			request.setAttribute("diaChiKhachHang", diaChiKhachHang);
			request.setAttribute("diaChiMuaHang", diaChiMuaHang);
			request.setAttribute("diaChiNhanHang", diaChiNhanHang);
			request.setAttribute("dienThoai", soDienThoai);
			request.setAttribute("email", email);
			request.setAttribute("dongYNhanMail", dongYNhanMail);

			String url = "";

			String baoLoi = "";
			KhacHangDAO khacHangDAO = new KhacHangDAO();
			request.setAttribute("baoLoi", baoLoi);

			if (baoLoi.length() > 0) {
				url = "/khachhang/register.jsp";

			} else {
				Object obj = request.getSession().getAttribute("khachHang");
				KhachHang khachHang = null;
				if (obj!=null)
					khachHang = (KhachHang)obj;		
					if(khachHang!=null){	
						String maKhachHang = khachHang.getMaKhachHang();
						KhachHang kh = new KhachHang(maKhachHang, "", "", hoVaTen, gioiTinh, diaChiKhachHang, diaChiNhanHang, diaChiMuaHang, Date.valueOf(ngaySinh), soDienThoai, email, dongYNhanMail != null);
						khacHangDAO.updateInfo(kh);
						KhachHang kh2 = khacHangDAO.selectById(kh);
						request.getSession().setAttribute("khachHang", kh2);
						url = "/khachhang/success.jsp";
					}

			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
