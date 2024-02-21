package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.TacGia;
import model.TheLoai;

public class TheLoaiDAO implements DAOInterfare<TheLoai> {

	private ArrayList<TheLoai> data = new ArrayList<TheLoai>();
	
	@Override
	public ArrayList<TheLoai> selectAll() {
		ArrayList<TheLoai> ketQua = new ArrayList<TheLoai>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM theloai";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String maTheLoai = rs.getString("ma_the_loai");
				String tenTheLoai = rs.getString("ten_the_loai");
				
				
				TheLoai theLoai = new TheLoai(maTheLoai, tenTheLoai);
				ketQua.add(theLoai);
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
	public TheLoai selectById(TheLoai t) {
		TheLoai ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM theloai where ma_the_loai=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaTheLoai());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String maTheLoai = rs.getString("ma_the_loai");
				String tenTheLoai = rs.getString("ten_the_loai");
				
				ketQua = new TheLoai(maTheLoai, tenTheLoai);
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
	public int insert(TheLoai t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO theloai (ma_the_loai, ten_the_loai) "+
					" VALUES (?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaTheLoai());
			st.setString(2, t.getTenTheLoai());
			
			// Bước 3: thực thi câu lệnh SQL
			ketQua = st.executeUpdate();
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<TheLoai> arr) {
	    int ketQua = 0;
	    try {
	        // Bước 1: tạo kết nối đến CSDL
	        Connection con = JDBCUtil.getConnection();

	        // Bước 2: tạo ra đối tượng statement
	        String sql = "INSERT INTO tacgia (ma_tac_gia, ten_tac_gia, nam_sinh) VALUES (?, ?, ?)";

	        PreparedStatement st = con.prepareStatement(sql);

	        // Bước 3: Thực hiện lặp qua danh sách tác giả và thêm các tham số vào câu lệnh SQL
	        for (TheLoai theLoai : arr) {
				st.setString(1, theLoai.getMaTheLoai());
				st.setString(2, theLoai.getTenTheLoai());

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
	public int delete(TheLoai t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from theloai "+
					 " WHERE ma_the_loai=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaTheLoai());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ketQua = st.executeUpdate();
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}


	@Override
	public int deleteAll(ArrayList<TheLoai> arr) {
		 int ketQua = 0;
		    try {
		        // Bước 1: tạo kết nối đến CSDL
		        Connection con = JDBCUtil.getConnection();

		        // Bước 2: tạo ra đối tượng statement
		        String sql = "DELETE FROM theloai";

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
	public int update(TheLoai t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE theloai "+
					 " SET " +
					 " ten_the_loai=?"+
					 " WHERE ma_tac_gia=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaTheLoai());
			st.setString(2, t.getTenTheLoai());

			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			ketQua = st.executeUpdate();
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}
	
	
	
}
