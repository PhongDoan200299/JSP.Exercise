package model;

import java.util.Objects;

public class KhachHang {
	private String maKhachHang;
	private String tenDangNhap;
	private String matKhau;
	private String hoVaTen;
	private GioiTinh gioiTinh;
	private String gioiTinh1;
	private String diaChi;
	private String diaChiNhanHang;
	private String diaChiMuaHang;
	private	int soDienThoai;
	private String email;
	private DangKy dangKy;
	
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



	public KhachHang(String maKhachHang, String tenDangNhap, String matKhau, String hoVaTen, GioiTinh gioiTinh,
			String gioiTinh1, String diaChi, String diaChiNhanHang, String diaChiMuaHang, int soDienThoai, String email,
			DangKy dangKy) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.hoVaTen = hoVaTen;
		this.gioiTinh = gioiTinh;
		this.gioiTinh1 = gioiTinh1;
		this.diaChi = diaChi;
		this.diaChiNhanHang = diaChiNhanHang;
		this.diaChiMuaHang = diaChiMuaHang;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.dangKy = dangKy;
	}



	public String getGioiTinh1() {
		return gioiTinh1;
	}



	public void setGioiTinh1(String gioiTinh1) {
		this.gioiTinh1 = gioiTinh1;
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

	public GioiTinh getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(GioiTinh gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

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

	public DangKy getDangKy() {
		return dangKy;
	}

	public void setDangKy(DangKy dangKy) {
		this.dangKy = dangKy;
	}



	@Override
	public int hashCode() {
		return Objects.hash(dangKy, diaChi, diaChiMuaHang, diaChiNhanHang, email, gioiTinh, gioiTinh1, hoVaTen,
				maKhachHang, matKhau, soDienThoai, tenDangNhap);
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
		return  Objects.equals(maKhachHang, other.maKhachHang);
				
	}
	
	
}


