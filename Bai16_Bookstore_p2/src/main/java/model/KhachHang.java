package model;

import java.sql.Date;
import java.util.Objects;

public class KhachHang {
	private String maKhachHang;
	private String tenDangNhap;
	private String matKhau;
	private String hoVaTen;
	//private GioiTinh gioiTinh1;
	private String gioiTinh;
	private String diaChi;
	private String diaChiNhanHang;
	private String diaChiMuaHang;
	private Date ngaySinh;
	private	int soDienThoai;
	private String email;
	//private DangKy dangKy1;
	private boolean dangKy;
	
	public enum GioiTinh {
		Nam,
		Nu,
		Khac
	}
	
	public class DangKy  {
		private String email;
		private String hoVaTen;
		
		public DangKy(String email,String hoVaTen) {
			this.email = email;
			this.hoVaTen = hoVaTen;
		}
	}

	public KhachHang() {
		super();
	}

	public KhachHang(String maKhachHang, String tenDangNhap, String matKhau, String hoVaTen, String gioiTinh,
			String diaChi, String diaChiNhanHang, String diaChiMuaHang, Date ngaySinh, int soDienThoai, String email,
			boolean dangKy) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.hoVaTen = hoVaTen;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.diaChiNhanHang = diaChiNhanHang;
		this.diaChiMuaHang = diaChiMuaHang;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.dangKy = dangKy;
	}


	
	public boolean getDangKy() {
		return dangKy;
	}

	public void setDangKy(boolean dangKy) {
		this.dangKy = dangKy;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

//	public GioiTinh getGioiTinh() {
//		return gioiTinh;
//	}
//
//	public void setGioiTinh(GioiTinh gioiTinh) {
//		this.gioiTinh = gioiTinh;
//	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getDiaChiNhanHang() {
		return diaChiNhanHang;
	}

	public void setDiaChiNhanHang(String diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}

	public String getDiaChiMuaHang() {
		return diaChiMuaHang;
	}

	public void setDiaChiMuaHang(String diaChiMuaHang) {
		this.diaChiMuaHang = diaChiMuaHang;
	}

	public int getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(int soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
//	public DangKy getDangKy() {
//	return dangKy;
//}
//
//public void setDangKy(DangKy dangKy) {
//	this.dangKy = dangKy;
//}

	@Override
	public int hashCode() {
		return Objects.hash(dangKy, diaChi, diaChiMuaHang, diaChiNhanHang, email, gioiTinh, hoVaTen, maKhachHang,
				matKhau, ngaySinh, soDienThoai, tenDangNhap);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return dangKy == other.dangKy && Objects.equals(diaChi, other.diaChi)
				&& Objects.equals(diaChiMuaHang, other.diaChiMuaHang)
				&& Objects.equals(diaChiNhanHang, other.diaChiNhanHang) && Objects.equals(email, other.email)
				&& Objects.equals(gioiTinh, other.gioiTinh) && Objects.equals(hoVaTen, other.hoVaTen)
				&& Objects.equals(maKhachHang, other.maKhachHang) && Objects.equals(matKhau, other.matKhau)
				&& Objects.equals(ngaySinh, other.ngaySinh) && soDienThoai == other.soDienThoai
				&& Objects.equals(tenDangNhap, other.tenDangNhap);
	}

}


