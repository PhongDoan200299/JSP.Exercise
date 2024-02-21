package model;

import java.util.Objects;

public class SanPham {
	private String maSanPham;
	private String tenSanPham;
	private TacGia tacGia;
	private int namXuatBan;
	private double giaNhap;
	private double giaGoc;
	private double giaBan;
	private int soLuong;
	private TheLoai theLoai;
	private String moTa;
	private String ngonNgu;

	public SanPham() {
		super();
	}

	public SanPham(String maSanPham, String tenSanPham, TacGia tacGia, int namXuatBan, double giaNhap, double giaGoc,
			double giaBan, int soLuong, TheLoai theLoai, String moTa, String ngonNgu) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.tacGia = tacGia;
		this.namXuatBan = namXuatBan;
		this.giaNhap = giaNhap;
		this.giaGoc = giaGoc;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
		this.theLoai = theLoai;
		this.moTa = moTa;
		this.ngonNgu = ngonNgu;
	}

	public TheLoai getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(TheLoai theLoai) {
		this.theLoai = theLoai;
	}

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public TacGia getTacGia() {
		return tacGia;
	}

	public void setTacGia(TacGia tacGia) {
		this.tacGia = tacGia;
	}

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	public double getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}

	public double getGiaGoc() {
		return giaGoc;
	}

	public void setGiaGoc(double giaGoc) {
		this.giaGoc = giaGoc;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getNgonNgu() {
		return ngonNgu;
	}

	public void setNgonNgu(String ngonNgu) {
		this.ngonNgu = ngonNgu;
	}

	@Override
	public int hashCode() {
		return Objects.hash(giaBan, giaGoc, giaNhap, maSanPham, moTa, namXuatBan, ngonNgu, soLuong, tacGia, tenSanPham,
				theLoai);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		return Double.doubleToLongBits(giaBan) == Double.doubleToLongBits(other.giaBan)
				&& Double.doubleToLongBits(giaGoc) == Double.doubleToLongBits(other.giaGoc)
				&& Double.doubleToLongBits(giaNhap) == Double.doubleToLongBits(other.giaNhap)
				&& Objects.equals(maSanPham, other.maSanPham) && Objects.equals(moTa, other.moTa)
				&& namXuatBan == other.namXuatBan && Objects.equals(ngonNgu, other.ngonNgu) && soLuong == other.soLuong
				&& Objects.equals(tacGia, other.tacGia) && Objects.equals(tenSanPham, other.tenSanPham)
				&& Objects.equals(theLoai, other.theLoai);
	}

}
