package model;

import java.util.Objects;

public class ChiTietDonHang {
	private String maChiTietDonHang;
	private DonHang donHang;
	private SanPham maSanPham;
	private double soLuong;
	private double giaGoc;
	private double giaBan;
	private double VAT;
	private double tongThanhTien;
	
	public ChiTietDonHang() {
		super();
	}

	public ChiTietDonHang(String maChiTietDonHang, DonHang donHang, SanPham maSanPham, double giaGoc, double giaBan,
			double vAT, double tongThanhTien) {
		super();
		this.maChiTietDonHang = maChiTietDonHang;
		this.donHang = donHang;
		this.maSanPham = maSanPham;
		this.giaGoc = giaGoc;
		this.giaBan = giaBan;
		this.VAT = vAT;
		this.tongThanhTien = tongThanhTien;
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

	public SanPham getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(SanPham maSanPham) {
		this.maSanPham = maSanPham;
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
		return Objects.hash(VAT, donHang, giaBan, giaGoc, maChiTietDonHang, maSanPham, soLuong, tongThanhTien);
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
				&& Objects.equals(maChiTietDonHang, other.maChiTietDonHang)
				&& Objects.equals(maSanPham, other.maSanPham)
				&& Double.doubleToLongBits(soLuong) == Double.doubleToLongBits(other.soLuong)
				&& Double.doubleToLongBits(tongThanhTien) == Double.doubleToLongBits(other.tongThanhTien);
	}
	
	
}
