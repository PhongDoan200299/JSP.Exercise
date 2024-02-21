package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ChiTietDonHang;
import model.DonHang;
import model.SanPham;

public class ChiTietDonHangDAO implements DAOInterfare<ChiTietDonHang> {
	private ArrayList<ChiTietDonHang> data = new ArrayList<ChiTietDonHang>();
	@Override
	public ArrayList<ChiTietDonHang> selectAll() {
		ArrayList<ChiTietDonHang> ketQua = new ArrayList<ChiTietDonHang>();

		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM chitietdonhang";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:

			while (rs.next()) {
				String maChiTietDonHang = rs.getString("ma_chi_tiet_don_hang");
				String donhang = rs.getString("don_hang");
				String sanpham = rs.getString("san_pham");
				double soluong = rs.getDouble("so_luong");
				double giagoc = rs.getDouble("gia_goc");
				double giamgia = rs.getDouble("gia_giam");
				double giaban = rs.getDouble("gia_ban");
				double thuevat = rs.getDouble("VAT");
				double tongtien = rs.getDouble("tong_tien");

				DonHang dh = new DonHangDAO().selectById(new DonHang(donhang, null, sql, donhang, maChiTietDonHang, donhang, sanpham, giaban, thuevat, tongtien, null, null));
				SanPham sp = new SanPhamDAO().selectById(new SanPham("", "", null, 0, 0, 0, 0, 0, null, "", ""));

				ChiTietDonHang ctdh = new ChiTietDonHang(maChiTietDonHang, dh, sp, soluong, giagoc, giamgia, giaban, thuevat, tongtien);
				ketQua.add(ctdh);
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
	public ChiTietDonHang selectById(ChiTietDonHang t) {
		ChiTietDonHang ketQua = null;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT * FROM chitietdonhang WHERE ma_chi_tiet_don_hang=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaChiTietDonHang());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maChiTietDonHang = rs.getString("ma_chi_tiet_don_hang");
				String donhang = rs.getString("don_hang");// o
				String sanpham = rs.getString("san_pham");// o
				double soluong = rs.getDouble("so_luong");
				double giagoc = rs.getDouble("gia_goc");
				double giamgia = rs.getDouble("giam_gia");
				double giaban = rs.getDouble("gia_ban");
				double thuevat = rs.getDouble("VAT");
				double tongtien = rs.getDouble("tong_tien");

				DonHang dh = new DonHangDAO().selectById(new DonHang(donhang, null, sql, donhang, maChiTietDonHang, donhang, sanpham, giaban, thuevat, tongtien, null, null));
				SanPham sp = new SanPhamDAO().selectById(new SanPham(sanpham, "", null, 0, 0, 0, 0, 0, null, "", ""));

				ketQua = new ChiTietDonHang(maChiTietDonHang, dh, sp, soluong, giagoc, giamgia, giaban, thuevat, tongtien);
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
	public int insert(ChiTietDonHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO chitietdonhang (ma_chi_tiet_don_hang, don_hang,san_pham, so_luong, gia_goc,giam_gia,gia_ban,VAT,tong_tien) "
					+ " VALUES (?,?,?,?,?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaChiTietDonHang());
			st.setString(2, t.getDonHang().getMaDonHang());
			st.setString(3, t.getSanPham().getMaSanPham());
			st.setDouble(4, t.getSoLuong());
			st.setDouble(5, t.getGiaGoc());
			st.setDouble(7, t.getGiamGia());
			st.setDouble(6, t.getGiaBan());
			st.setDouble(8, t.getVAT());
			st.setDouble(9, t.getTongThanhTien());
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
	public int insertAll(ArrayList<ChiTietDonHang> arr) {
		int dem = 0;
		for(ChiTietDonHang chiTiet : arr) {
			dem+= this.insert(chiTiet);
		}
		return dem;
	}

	@Override
	public int delete(ChiTietDonHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from chitietdonhang " + " WHERE ma_chi_tiet_don_hang=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaChiTietDonHang());

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
	public int deleteAll(ArrayList<ChiTietDonHang> arr) {
		int dem = 0;
		for(ChiTietDonHang chiTiet : arr) {
			dem += this.delete(chiTiet);
		}
		return dem;
	}
	
	public int deleteAll(DonHang dh) {
		int dem = 0;
		for(ChiTietDonHang chiTietDonHang : data) {
			if(chiTietDonHang.getDonHang().equals(dh)) {
				this.delete(chiTietDonHang);
			}
		}
		return dem;
	}

	@Override
	public int update(ChiTietDonHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE chitietdonhang SET don_hang=?, san_pham=?, so_luong=?, gia_goc=?, giam_gia=?, gia_ban=?, VAT=?, tong_tien=?"
					+ " WHERE ma_chi_tiet_don_hang=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getDonHang().getMaDonHang());
			st.setString(2, t.getSanPham().getMaSanPham());
			st.setDouble(3, t.getSoLuong());
			st.setDouble(4, t.getGiaGoc());
			st.setDouble(5, t.getGiamGia());
			st.setDouble(6, t.getGiaBan());
			st.setDouble(7, t.getVAT());
			st.setDouble(8, t.getTongThanhTien());
			st.setString(9, t.getMaChiTietDonHang());

			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			ketQua = st.executeUpdate();

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}


}
