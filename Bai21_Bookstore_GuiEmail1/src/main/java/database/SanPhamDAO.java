package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.SanPham;
import model.TacGia;
import model.TheLoai;

public class SanPhamDAO implements DAOInterfare<SanPham> {

	public ArrayList<SanPham> data = new ArrayList<SanPham>();

	@Override
	public ArrayList<SanPham> selectAll() {
		ArrayList<SanPham> ketQua = new ArrayList<SanPham>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM sanpham";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				String maSanPham = rs.getString("ma_san_pham");
				String tenSanPham = rs.getString("ten_san_pham");
				String maTacGia = rs.getString("ma_tac_gia");
				int namXuatBan = rs.getInt("nam_xuat_ban");
				double giaNhap = rs.getDouble("gia_nhap");
				double giaGoc = rs.getDouble("gia_goc");
				double giaBan = rs.getDouble("gia_ban");
				int soLuong = (int) rs.getDouble("so_luong");
				String maTheLoai = rs.getString("ma_the_loai");
				String ngonNgu = rs.getString("ngon_ngu");
				String moTa = rs.getString("mo_ta");

				TacGia tacGia = (new TacGiaDAO().selectById(new TacGia(maTacGia, "", null, "")));
				TheLoai theLoai = (new TheLoaiDAO().selectById(new TheLoai(maTheLoai, "")));
				SanPham sanPham = new SanPham(maSanPham, tenSanPham, tacGia, namXuatBan, giaNhap, giaGoc, giaBan,
						soLuong, theLoai, moTa, ngonNgu);
				ketQua.add(sanPham);
			}

			// Bước 5: Dong CSDL
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public SanPham selectById(SanPham t) {
		SanPham ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM sanpham where ma_san_pham=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaSanPham());

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String maSanPham = rs.getString("ma_san_pham");
				String tenSanPham = rs.getString("ten_san_pham");
				String maTacGia = rs.getString("ma_tac_gia");
				int namXuatBan = rs.getInt("nam_xuat_ban");
				double giaNhap = rs.getDouble("gia_nhap");
				double giaGoc = rs.getDouble("gia_goc");
				double giaBan = rs.getDouble("gia_ban");
				int soLuong = (int) rs.getDouble("so_luong");
				String maTheLoai = rs.getString("ma_the_loai");
				String ngonNgu = rs.getString("ngon_ngu");
				String moTa = rs.getString("mo_ta");

				TacGia tacGia = (new TacGiaDAO().selectById(new TacGia(maTacGia, "", null, "")));
				TheLoai theLoai = (new TheLoaiDAO().selectById(new TheLoai(maTheLoai, "")));
				ketQua = new SanPham(maSanPham, tenSanPham, tacGia, namXuatBan, giaNhap, giaGoc, giaBan, soLuong,
						theLoai, moTa, ngonNgu);
				break;

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
	public int insert(SanPham t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO sanpham (ma_san_pham,ten_san_pham, ma_tac_gia, nam_xuat_ban,"
					+ " gia_nhap, gia_goc, gia_ban, so_luong, ma_the_loai, ngon_ngu, mota) "
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaSanPham());
			st.setString(2, t.getTenSanPham());
			st.setString(3, t.getTacGia().getMaTacGia());
			st.setInt(4, t.getNamXuatBan());
			st.setDouble(5, t.getGiaNhap());
			st.setDouble(6, t.getGiaGoc());
			st.setDouble(7, t.getGiaBan());
			st.setInt(8, t.getSoLuong());
			st.setString(9, t.getTheLoai().getMaTheLoai());
			st.setString(10, t.getNgonNgu());
			st.setString(11, t.getMoTa());

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
	public int insertAll(ArrayList<SanPham> arr) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO sanpham (ma_san_pham,ten_san_pham, ma_tac_gia, nam_xuat_ban,"
					+ " gia_nhap, gia_goc, gia_ban, so_luong, ma_the_loai, ngon_ngu, mota) "
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: Thực hiện lặp qua danh sách sản phẩm và thêm các tham số vào câu lệnh
			// SQL
			for (SanPham sanPham : arr) {
				st.setString(1, sanPham.getMaSanPham());
				st.setString(2, sanPham.getTenSanPham());
				st.setString(3, sanPham.getTacGia().getMaTacGia());
				st.setInt(4, sanPham.getNamXuatBan());
				st.setDouble(5, sanPham.getGiaNhap());
				st.setDouble(6, sanPham.getGiaGoc());
				st.setDouble(7, sanPham.getGiaBan());
				st.setInt(8, sanPham.getSoLuong());
				st.setString(9, sanPham.getTheLoai().getMaTheLoai());
				st.setString(10, sanPham.getNgonNgu());
				st.setString(11, sanPham.getMoTa());

				// Thêm câu lệnh SQL vào batch
				st.addBatch();
			}

			// Bước 4: Thực thi tất cả các câu lệnh SQL trong batch
			int[] results = st.executeBatch();

			// Bước 5: Đếm số lượng bản ghi được thêm vào
			for (int result : results) {
				ketQua += result;
			}

			// Bước 6: In kết quả thành công
			System.out.println("Bạn đã thêm thành công " + ketQua + " bản ghi!");

			// Bước 7: Đóng kết nối
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int delete(SanPham t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from sanpham " + " WHERE ma_san_pham=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaSanPham());

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
	public int deleteAll(ArrayList<SanPham> arr) {
		int dem = 0;
		for (SanPham SanPham : arr) {
			dem += this.delete(SanPham);
		}
		return dem;
	}

	@Override
	public int update(SanPham t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE sanpham " + " SET " + "tensanpham=?, matacgia=?, namxuatban=?, gianhap=?, giagoc=?, "
					+ "giaban=?, soluong=?, matheloai=?, ngonngu=?, mota=?" + " WHERE masanpham=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getTenSanPham());
			st.setString(2, t.getTacGia().getMaTacGia());
			st.setInt(3, t.getNamXuatBan());
			st.setDouble(4, t.getGiaNhap());
			st.setDouble(5, t.getGiaGoc());
			st.setDouble(6, t.getGiaBan());
			st.setInt(7, t.getSoLuong());
			st.setString(8, t.getTheLoai().getMaTheLoai());
			st.setString(9, t.getNgonNgu());
			st.setString(10, t.getMoTa());
			st.setString(11, t.getMaSanPham());
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
