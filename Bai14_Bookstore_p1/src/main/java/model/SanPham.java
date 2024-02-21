package model;

import java.util.Objects;

public class SanPham {
	private String maSanPham;
	private String tenSanPham;
	private String tacGia;
	private int namXuatBan;
	private double giaNhap;
	private double giaGoc;
	private double giaBan;
	private int soLuong;
	private String moTa;
	public SanPham() {
		super();
	}
	public SanPham(String maSanPham, String tenSanPham, String tacGia, int namXuatBan, double giaNhap, double giaGoc,
			double giaBan, int soLuong, String moTa) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.tacGia = tacGia;
		this.namXuatBan = namXuatBan;
		this.giaNhap = giaNhap;
		this.giaGoc = giaGoc;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
		this.moTa = moTa;
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
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
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
	@Override
	public int hashCode() {
		return Objects.hash(giaBan, giaGoc, giaNhap, maSanPham, moTa, namXuatBan, soLuong, tacGia, tenSanPham);
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
		return  Objects.equals(maSanPham, other.maSanPham);
	
	}
}
