package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import model.KhachHang;

public class KhacHangDAO implements DAOInterfare<KhachHang> {
	private ArrayList<KhachHang> data = new ArrayList<KhachHang>();
	@Override
	public ArrayList<KhachHang> selectAll() {
		ArrayList<KhachHang> ketQua = new ArrayList<KhachHang>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM khachhang";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				String maKhacHang = rs.getString("ma_khach_hang");
				String tenDangNhap = rs.getString("ten_dang_nhap");
				String matKhau = rs.getString("mat_khau");
				String hoVaTen = rs.getString("ho_ten");
				String gioiTinh = rs.getString("gioi_tinh");
				String diaChi = rs.getString("dia_chi");
				String diaChiNhanHang = rs.getString("dia_chi_nhan_hang");
				String diaChiMuaHang = rs.getString("dia_chi_mua_hang");
				Date ngaySinh = rs.getDate("ngay_sinh");
				String soDienThoai = rs.getString("so_dien_thoai");
				String email = rs.getString("email");
				boolean dangKyNhanBangTin = rs.getBoolean("dang_ki_nhan_bang_tin");

				KhachHang kh = new KhachHang(maKhacHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, diaChiNhanHang, diaChiMuaHang, ngaySinh, 0, email, dangKyNhanBangTin);
				ketQua.add(kh);
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
	@Override
	public KhachHang selectById(KhachHang t) {
		KhachHang ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM khachhang WHERE makhama_khach_hangchhang=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaKhachHang());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				String maKhacHang = rs.getString("ma_khach_hang");
				String tenDangNhap = rs.getString("ten_dang_nhap");
				String matKhau = rs.getString("mat_khau");
				String hoVaTen = rs.getString("ho_ten");
				String gioiTinh = rs.getString("gioi_tinh");
				String diaChi = rs.getString("dia_chi");
				String diaChiNhanHang = rs.getString("dia_chi_nhan_hang");
				String diaChiMuaHang = rs.getString("dia_chi_mua_hang");
				Date ngaySinh = rs.getDate("ngay_sinh");
				String soDienThoai = rs.getString("so_dien_thoai");
				String email = rs.getString("email");
				boolean dangKyNhanBangTin = rs.getBoolean("dang_ki_nhan_bang_tin");

				ketQua = new KhachHang(maKhacHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, diaChiNhanHang, diaChiMuaHang, ngaySinh, 0, email, dangKyNhanBangTin);
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int insert(KhachHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO khachhang (ma_khach_hang, ten_dang_nhap, mat_khau, ho_ten, gioi_tinh, dia_chi, dia_chi_nhan_hang, dia_chi_mua_hang, ngay_sinh, so_dien_thoai, email, dang_ki_nhan_bang_tin) "
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaKhachHang());
			st.setString(2, t.getTenDangNhap());
			st.setString(3, t.getMatKhau());
			st.setString(4, t.getHoVaTen());
			st.setString(5, t.getGioiTinh());
			st.setString(6, t.getDiaChi());
			st.setString(7, t.getDiaChiNhanHang());
			st.setString(8, t.getDiaChiMuaHang());
			st.setDate(9, t.getNgaySinh());
			st.setInt(10, t.getSoDienThoai());
			st.setString(11, t.getEmail());
			st.setBoolean(12, t.getDangKy());

			// Bước 3: thực thi câu lệnh SQL
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<KhachHang> arr) {
		int dem = 0;
		for(KhachHang kh : arr) {
			
			dem += this.insert(kh);
		}
		return dem;
	}

	@Override
	public int delete(KhachHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from khachhang " + " WHERE ma_khach_hang=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaKhachHang());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int deleteAll(ArrayList<KhachHang> arr) {
		int dem = 0;
		for(KhachHang kh : arr) {
			dem += this.delete(kh);
		}
		return dem;
	}

	@Override
	public int update(KhachHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE khachhang " + " SET " + " ten_dang_nhap=?" + ", mat_khau=?" + ", ho_ten=?" + ", gioi_tinh=?"
					+ ", dia_chi=?" + ", dia_chi_nhan_hang=?" + ", dia_chi_mua_hang=?" + ", ngay_sinh=?" + ", so_dien_thoai=?"
					+ ", email=?" + ", dang_ki_nhan_bang_tin=?" + " WHERE ma_khach_hang=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getTenDangNhap());
			st.setString(2, t.getMatKhau());
			st.setString(3, t.getHoVaTen());
			st.setString(4, t.getGioiTinh());
			st.setString(5, t.getDiaChi());
			st.setString(6, t.getDiaChiNhanHang());
			st.setString(7, t.getDiaChiMuaHang());
			st.setDate(8, t.getNgaySinh());
			st.setInt(9, t.getSoDienThoai());
			st.setString(10, t.getEmail());
			st.setBoolean(11, t.getDangKy());
			st.setString(12, t.getMaKhachHang());
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

}
