package model;

import java.util.Objects;

public class ChiTietDonHang {
	private String maChiTietDonHang;
	private DonHang donHang;
	private SanPham sanPham;
	private double soLuong;
	private double giaGoc;
	private double giamGia;
	private double giaBan;
	private double VAT;
	private double tongThanhTien;

	public ChiTietDonHang() {
		super();
	}

	public ChiTietDonHang(String maChiTietDonHang, DonHang donHang, SanPham sanPham, double soLuong, double giaGoc,
			double giamGia, double giaBan, double vAT, double tongThanhTien) {
		super();
		this.maChiTietDonHang = maChiTietDonHang;
		this.donHang = donHang;
		this.sanPham = sanPham;
		this.soLuong = soLuong;
		this.giaGoc = giaGoc;
		this.giamGia = giamGia;
		this.giaBan = giaBan;
		this.VAT = vAT;
		this.tongThanhTien = tongThanhTien;
	}

	public double getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}

	public String getMaChiTietDonHang() {
		return maChiTietDonHang;
	}

	public void setMaChiTietDonHang(String maChiTietDonHang) {
		this.maChiTietDonHang = maChiTietDonHang;
	}

	public DonHang getDonHang() {
		return donHang;
	}

	public void setDonHang(DonHang donHang) {
		this.donHang = donHang;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public double getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(double soLuong) {
		this.soLuong = soLuong;
	}

	public void setGiaGoc(double giaGoc) {
		this.giaGoc = giaGoc;
	}

	public double getGiaGoc() {
		return giaGoc;
	}

	public void setGiaBia(double giaGoc) {
		this.giaGoc = giaGoc;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public double getVAT() {
		return VAT;
	}

	public void setVAT(double vAT) {
		this.VAT = vAT;
	}

	public double getTongThanhTien() {
		return tongThanhTien;
	}

	public void setTongThanhTien(double tongThanhTien) {
		this.tongThanhTien = tongThanhTien;
	}

	@Override
	public int hashCode() {
		return Objects.hash(VAT, donHang, giaBan, giaGoc, giamGia, maChiTietDonHang, sanPham, soLuong, tongThanhTien);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietDonHang other = (ChiTietDonHang) obj;
		return Double.doubleToLongBits(VAT) == Double.doubleToLongBits(other.VAT)
				&& Objects.equals(donHang, other.donHang)
				&& Double.doubleToLongBits(giaBan) == Double.doubleToLongBits(other.giaBan)
				&& Double.doubleToLongBits(giaGoc) == Double.doubleToLongBits(other.giaGoc)
				&& Double.doubleToLongBits(giamGia) == Double.doubleToLongBits(other.giamGia)
				&& Objects.equals(maChiTietDonHang, other.maChiTietDonHang) && Objects.equals(sanPham, other.sanPham)
				&& Double.doubleToLongBits(soLuong) == Double.doubleToLongBits(other.soLuong)
				&& Double.doubleToLongBits(tongThanhTien) == Double.doubleToLongBits(other.tongThanhTien);
	}

}
