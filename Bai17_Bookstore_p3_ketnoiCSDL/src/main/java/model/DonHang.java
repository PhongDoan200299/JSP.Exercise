package model;

import java.sql.Date;
import java.util.Objects;

public class DonHang {
	private String maDonHang;
	private String khachHang;
	private String diaChiNhanHang;
	private TrangThai trangThai;
	private String trangThai1;
	private String hinhThucThanhToan1;
	private String trangThaiThanhToan1;
	private HinhThucThanhToan hinhThucThanhToan;
	private TrangThaiThanhToan trangThaiThanhToan;
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

	public DonHang(String maDonHang, TrangThai trangThai) {
		this.maDonHang = maDonHang;
		this.trangThai = trangThai;
	}

	public DonHang() {
		super();
	}

	public String getTrangThai1() {
		return trangThai1;
	}

	public void setTrangThai1(String trangThai1) {
		this.trangThai1 = trangThai1;
	}

	public String getHinhThucThanhToan1() {
		return hinhThucThanhToan1;
	}

	public void setHinhThucThanhToan1(String hinhThucThanhToan1) {
		this.hinhThucThanhToan1 = hinhThucThanhToan1;
	}

	public String getTrangThaiThanhToan1() {
		return trangThaiThanhToan1;
	}

	public void setTrangThaiThanhToan1(String trangThaiThanhToan1) {
		this.trangThaiThanhToan1 = trangThaiThanhToan1;
	}

	public DonHang(String maDonHang, String khachHang, String diaChiNhanHang, TrangThai trangThai, String trangThai1,
			String hinhThucThanhToan1, String trangThaiThanhToan1, HinhThucThanhToan hinhThucThanhToan,
			TrangThaiThanhToan trangThaiThanhToan, double soTienDaThanhToan, double soTienConThieu, Date ngayDathang,
			Date ngayGiaoHang) {
		super();
		this.maDonHang = maDonHang;
		this.khachHang = khachHang;
		this.diaChiNhanHang = diaChiNhanHang;
		this.trangThai = trangThai;
		this.trangThai1 = trangThai1;
		this.hinhThucThanhToan1 = hinhThucThanhToan1;
		this.trangThaiThanhToan1 = trangThaiThanhToan1;
		this.hinhThucThanhToan = hinhThucThanhToan;
		this.trangThaiThanhToan = trangThaiThanhToan;
		this.soTienDaThanhToan = soTienDaThanhToan;
		this.soTienConThieu = soTienConThieu;
		this.ngayDathang = ngayDathang;
		this.ngayGiaoHang = ngayGiaoHang;
	}

	public String getMaDonHang() {
		return maDonHang;
	}

	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}

	public String getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(String khachHang) {
		this.khachHang = khachHang;
	}

	public String getDiaChiNhanHang() {
		return diaChiNhanHang;
	}

	public void setDiaChiNhanHang(String diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}

	public TrangThai getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(TrangThai trangThai) {
		this.trangThai = trangThai;
	}

	public HinhThucThanhToan getHinhThucThanhToan() {
		return hinhThucThanhToan;
	}

	public void setHinhThucThanhToan(HinhThucThanhToan hinhThucThanhToan) {
		this.hinhThucThanhToan = hinhThucThanhToan;
	}

	public TrangThaiThanhToan getTrangThaiThanhToan() {
		return trangThaiThanhToan;
	}

	public void setTrangThaiThanhToan(TrangThaiThanhToan trangThaiThanhToan) {
		this.trangThaiThanhToan = trangThaiThanhToan;
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
		return Objects.hash(diaChiNhanHang, hinhThucThanhToan, hinhThucThanhToan1, khachHang, maDonHang, ngayDathang,
				ngayGiaoHang, soTienConThieu, soTienDaThanhToan, trangThai, trangThai1, trangThaiThanhToan,
				trangThaiThanhToan1);
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
		return Objects.equals(maDonHang, other.maDonHang);
	}

}
