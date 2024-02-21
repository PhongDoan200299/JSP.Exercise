package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.TacGia;

public class TacGiaDAO implements DAOInterfare<TacGia> {

	private ArrayList<TacGia> data = new ArrayList<TacGia>();

	@Override
	public ArrayList<TacGia> selectAll() {
		ArrayList<TacGia> ketQua = new ArrayList<TacGia>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM tacgia";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				String maTacGia = rs.getString("ma_tac_gia");
				String hoVaTen = rs.getString("ho_va_ten");
				Date ngaySinh_String = rs.getDate("ngay_sinh");
				String tieuSu = rs.getString("tieu_su");

				TacGia tacGia = new TacGia(maTacGia, hoVaTen, ngaySinh_String, tieuSu);
				ketQua.add(tacGia);
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
	public TacGia selectById(TacGia t) {
		TacGia ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM tacgia where ma_tac_gia=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaTacGia());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				String maTacGia = rs.getString("ma_tac_gia");
				String hoVaTen = rs.getString("ho_va_ten");
				Date ngaySinh_String = rs.getDate("ngay_sinh");
				String tieuSu = rs.getString("tieu_su");

				ketQua = new TacGia(maTacGia, hoVaTen, ngaySinh_String, tieuSu);
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
	public int insert(TacGia t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO tacgia (ma_tac_gia, ten_tac_gia, ngay_sinh, tieu_su) " + " VALUES (?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaTacGia());
			st.setString(2, t.getHoVaTen());
			st.setDate(3, t.getNgaySinh());
			st.setString(4, t.getTieuSu());

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
	public int insertAll(ArrayList<TacGia> arr) {

		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO tacgia (ma_tac_gia, ten_tac_gia, nam_sinh) VALUES (?, ?, ?)";

			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: Thực hiện lặp qua danh sách tác giả và thêm các tham số vào câu lệnh
			// SQL
			for (TacGia tacGia : arr) {
				st.setString(1, tacGia.getMaTacGia());
				st.setString(2, tacGia.getHoVaTen());
				st.setDate(3, tacGia.getNgaySinh());

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
	public int delete(TacGia t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from tacgia " + " WHERE ma_tac_gia=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaTacGia());

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
	public int deleteAll(ArrayList<TacGia> arr) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE FROM tacgia";

			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int update(TacGia t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE tacgia " + " SET " + " ho_va_ten=?" + ", ngay_sinh=?" + ", tieu_su=?"
					+ " WHERE ma_tac_gia=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaTacGia());
			st.setString(2, t.getHoVaTen());
			st.setDate(3, t.getNgaySinh());
			st.setString(4, t.getTieuSu());
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
