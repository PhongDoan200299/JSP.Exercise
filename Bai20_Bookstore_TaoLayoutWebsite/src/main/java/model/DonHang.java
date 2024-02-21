package model;

import java.sql.Date;
import java.util.Objects;

public class DonHang {
	private String maDonHang;
	private KhachHang khachHang;
	private String diaChiMuaHang;
	private String diaChiNhanHang;
//	private TrangThai trangThai1;
	private String trangThai;
	private String hinhThucThanhToan;
	private String trangThaiThanhToan;
//	private HinhThucThanhToan hinhThucThanhToan1;
//	private TrangThaiThanhToan trangThaiThanhToan1;
	private double soTienThanhToan;
	private double soTienDaThanhToan;
	private double soTienConThieu;
	private Date ngayDathang;
	private Date ngayGiaoHang;

	public enum TrangThai {
		MOI_TAO, DANG_XU_LY, DANG_GIAO_HANG, DA_GIAO_HANG, DA_GIAO_HANG_THANH_CONG
	}

	public enum HinhThucThanhToan {
		THE_TIN_DUNG, THANH_TOAN_TRUC_TUYEN, CHUYEN_KHOAN, TIEN_MAT
	}

	public enum TrangThaiThanhToan {
		CHUA_THANH_TOAN, DA_THANH_TOAN, THAT_BAI
	}

//	public DonHang(String maDonHang, TrangThai trangThai) {
//		this.maDonHang = maDonHang;
//		this.trangThai = trangThai;
//	}

	public DonHang() {
		super();
	}

	public DonHang(String maDonHang, KhachHang khachHang, String diaChiMuaHang, String diaChiNhanHang, String trangThai,
			String hinhThucThanhToan, String trangThaiThanhToan, double soTienThanhToan, double soTienDaThanhToan,
			double soTienConThieu, Date ngayDathang, Date ngayGiaoHang) {
		super();
		this.maDonHang = maDonHang;
		this.khachHang = khachHang;
		this.diaChiMuaHang = diaChiMuaHang;
		this.diaChiNhanHang = diaChiNhanHang;
		this.trangThai = trangThai;
		this.hinhThucThanhToan = hinhThucThanhToan;
		this.trangThaiThanhToan = trangThaiThanhToan;
		this.soTienThanhToan = soTienThanhToan;
		this.soTienDaThanhToan = soTienDaThanhToan;
		this.soTienConThieu = soTienConThieu;
		this.ngayDathang = ngayDathang;
		this.ngayGiaoHang = ngayGiaoHang;
	}

//	public String getTrangThai1() {
//		return trangThai1;
//	}
//
//	public void setTrangThai1(String trangThai1) {
//		this.trangThai1 = trangThai1;
//	}
//
//	public String getHinhThucThanhToan1() {
//		return hinhThucThanhToan1;
//	}
//
//	public void setHinhThucThanhToan1(String hinhThucThanhToan1) {
//		this.hinhThucThanhToan1 = hinhThucThanhToan1;
//	}
//
//	public String getTrangThaiThanhToan1() {
//		return trangThaiThanhToan1;
//	}
//
//	public void setTrangThaiThanhToan1(String trangThaiThanhToan1) {
//		this.trangThaiThanhToan1 = trangThaiThanhToan1;
//	}

	public String getMaDonHang() {
		return maDonHang;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getHinhThucThanhToan() {
		return hinhThucThanhToan;
	}

	public void setHinhThucThanhToan(String hinhThucThanhToan) {
		this.hinhThucThanhToan = hinhThucThanhToan;
	}

	public String getTrangThaiThanhToan() {
		return trangThaiThanhToan;
	}

	public void setTrangThaiThanhToan(String trangThaiThanhToan) {
		this.trangThaiThanhToan = trangThaiThanhToan;
	}

	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
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

//	public TrangThai getTrangThai() {
//		return trangThai;
//	}
//
//	public void setTrangThai(TrangThai trangThai) {
//		this.trangThai = trangThai;
//	}
//
//	public HinhThucThanhToan getHinhThucThanhToan() {
//		return hinhThucThanhToan;
//	}
//
//	public void setHinhThucThanhToan(HinhThucThanhToan hinhThucThanhToan) {
//		this.hinhThucThanhToan = hinhThucThanhToan;
//	}
//
//	public TrangThaiThanhToan getTrangThaiThanhToan() {
//		return trangThaiThanhToan;
//	}
//
//	public void setTrangThaiThanhToan(TrangThaiThanhToan trangThaiThanhToan) {
//		this.trangThaiThanhToan = trangThaiThanhToan;
//	}

	public double getSoTienThanhToan() {
		return soTienThanhToan;
	}

	public void setSoTienThanhToan(double soTienThanhToan) {
		this.soTienThanhToan = soTienThanhToan;
	}

	public double getSoTienDaThanhToan() {
		return soTienDaThanhToan;
	}

	public void setSoTienDaThanhToan(double soTienDaThanhToan) {
		this.soTienDaThanhToan = soTienDaThanhToan;
	}

	public double getSoTienConThieu() {
		return soTienConThieu;
	}

	public void setSoTienConThieu(double soTienConThieu) {
		this.soTienConThieu = soTienConThieu;
	}

	public Date getNgayDathang() {
		return ngayDathang;
	}

	public void setNgayDathang(Date ngayDathang) {
		this.ngayDathang = ngayDathang;
	}

	public Date getNgayGiaoHang() {
		return ngayGiaoHang;
	}

	public void setNgayGiaoHang(Date ngayGiaoHang) {
		this.ngayGiaoHang = ngayGiaoHang;
	}

	@Override
	public int hashCode() {
		return Objects.hash(diaChiMuaHang, diaChiNhanHang, hinhThucThanhToan, khachHang, maDonHang, ngayDathang,
				ngayGiaoHang, soTienConThieu, soTienDaThanhToan, soTienThanhToan, trangThai, trangThaiThanhToan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DonHang other = (DonHang) obj;
		return Objects.equals(diaChiMuaHang, other.diaChiMuaHang)
				&& Objects.equals(diaChiNhanHang, other.diaChiNhanHang)
				&& Objects.equals(hinhThucThanhToan, other.hinhThucThanhToan)
				&& Objects.equals(khachHang, other.khachHang) && Objects.equals(maDonHang, other.maDonHang)
				&& Objects.equals(ngayDathang, other.ngayDathang) && Objects.equals(ngayGiaoHang, other.ngayGiaoHang)
				&& Double.doubleToLongBits(soTienConThieu) == Double.doubleToLongBits(other.soTienConThieu)
				&& Double.doubleToLongBits(soTienDaThanhToan) == Double.doubleToLongBits(other.soTienDaThanhToan)
				&& Double.doubleToLongBits(soTienThanhToan) == Double.doubleToLongBits(other.soTienThanhToan)
				&& Objects.equals(trangThai, other.trangThai)
				&& Objects.equals(trangThaiThanhToan, other.trangThaiThanhToan);
	}
}
