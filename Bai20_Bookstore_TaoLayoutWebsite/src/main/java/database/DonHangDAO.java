package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.ChiTietDonHang;
import model.DonHang;
import model.KhachHang;
import model.TacGia;

public class DonHangDAO implements DAOInterfare<DonHang> {
	private ArrayList<DonHang> data = new ArrayList<DonHang>();

	@Override
	public ArrayList<DonHang> selectAll() {
		ArrayList<DonHang> ketQua = new ArrayList<DonHang>();
		Connection con = JDBCUtil.getConnection();
		String sql = "SELECT * FROM donhang";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String maDH = rs.getString(1);
				String maKH = rs.getString(2);
				String diaChiNguoiMua = rs.getString(3);
				String diaChiNhanHang = rs.getString(4);
				String hinhThucThanhToan = rs.getString(5);
				String trangThai = rs.getString(6);
				double soTienThanhToan = rs.getDouble(7);
				double soTienDaThanhToan = rs.getDouble(8);
				double soTienConThieu = rs.getDouble(9);
				Date ngayDatHang = rs.getDate(10);
				Date ngayGiaoHang = rs.getDate(11);

				KhachHang khachHang = new KhacHangDAO().selectById(new KhachHang(maKH, trangThai, sql, maDH, maKH, diaChiNguoiMua, diaChiNhanHang, diaChiNhanHang, null, hinhThucThanhToan, trangThai, false));
				DonHang dh = new DonHang(maDH, khachHang, diaChiNguoiMua, diaChiNhanHang, trangThai, hinhThucThanhToan,
						trangThai, soTienThanhToan, soTienDaThanhToan, soTienConThieu, null, null);

				ketQua.add(dh);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public DonHang selectById(DonHang t) {
		DonHang ketQua = null;
		Connection con = JDBCUtil.getConnection();
		String sql = "SELECT * FROM donhang WHERE madonhang = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaDonHang());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String maDH = rs.getString(1);
				String maKH = rs.getString(2);
				String diaChiNguoiMua = rs.getString(3);
				String diaChiNhanHang = rs.getString(4);
				String hinhThucThanhToan = rs.getString(5);
				String trangThai = rs.getString(6);
				double soTienThanhToan = rs.getDouble(7);
				double soTienDaThanhToan = rs.getDouble(8);
				double soTienConThieu = rs.getDouble(9);
				Date ngayDatHang = rs.getDate(10);
				Date ngayGiaoHang = rs.getDate(11);

				KhachHang khachHang = new KhacHangDAO().selectById(new KhachHang(maKH, trangThai, sql, maDH, maKH, diaChiNguoiMua, diaChiNhanHang, diaChiNhanHang, null, hinhThucThanhToan, trangThai, false));
				DonHang dh = new DonHang(maDH, khachHang, diaChiNguoiMua, diaChiNhanHang, trangThai, hinhThucThanhToan,
						trangThai, soTienThanhToan, soTienDaThanhToan, soTienConThieu, null, null);

				ketQua = dh;
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int insert(DonHang t) {
		int kq = 0;
		Connection con = JDBCUtil.getConnection();
		String sql = "INSERT INTO donhang(ma_don_hang, khach_hang, dia_chi_nguoi_mua, dia_chi_nguoi_nhan, hinh_thuc_thanh_toan, trang_thai_thanh_toan,so_tien_thanh_toan, so_tien_da_thanh_toan,so_tien_con_thieu,ngay_dat_hang,ngay_giao_hang)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaDonHang());
			st.setString(2, t.getKhachHang().getMaKhachHang());
			st.setString(3, t.getDiaChiMuaHang());
			st.setString(4, t.getDiaChiNhanHang());
			st.setString(5, t.getHinhThucThanhToan());
			st.setString(6, t.getTrangThai());
			st.setDouble(7, t.getSoTienThanhToan());
			st.setDouble(8, t.getSoTienDaThanhToan());
			st.setDouble(8, t.getSoTienConThieu());
			st.setDate(9, t.getNgayDathang());
			st.setDate(10, t.getNgayGiaoHang());

			kq = st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int insertAll(ArrayList<DonHang> arr) {
		int dem = 0;
		for (DonHang dh : arr) {
			dem += this.insert(dh);
		}
		return dem;
	}

	@Override
	public int delete(DonHang t) {
		int kq = 0;
		Connection con = JDBCUtil.getConnection();
		String sql = "DELETE FROM donhang WHERE ma_don_hang = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaDonHang());
			kq = st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int deleteAll(ArrayList<DonHang> arr) {
		int dem = 0;
		for (DonHang dh : arr) {
			dem += this.delete(dh);
		}
		return dem;
	}

	@Override
	public int update(DonHang t) {
		int kq = 0;
		Connection con = JDBCUtil.getConnection();

		String sql = "UPDATE donhang" + " SET " + "ma_khachh_hang=?" + ", dia_chi_mua_hang=?" + ",dia_chi_nhan_hang=?"
				+ ",hinh_thuc_thanh_toan=?" + ",trang_thai_thanh_toan=?" + ",so_tien_thanh_toan=?"
				+ ",so_tien_da_thanh_toan=?" + ",so_tien_con_thieu=?" + ",ngay_dat_hang=?" + ",ngay_giao_hang=?"
				+ " WHERE ma_don_hang=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getKhachHang().getMaKhachHang());
			st.setString(2, t.getDiaChiMuaHang());
			st.setString(3, t.getDiaChiNhanHang());
			st.setString(4, t.getHinhThucThanhToan());
			st.setString(5, t.getTrangThaiThanhToan());
			st.setDouble(6, t.getSoTienThanhToan());
			st.setDouble(7, t.getSoTienDaThanhToan());
			st.setDouble(8, t.getSoTienConThieu());
			st.setDate(9, t.getNgayDathang());
			st.setDate(10, t.getNgayGiaoHang());
			st.setString(11, t.getMaDonHang());

			kq = st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

}
