package database;

import java.util.ArrayList;

import model.ChiTietDonHang;
import model.DonHang;
import model.SanPham;

public class ChiTietDonHangDAO {
	private ArrayList<ChiTietDonHang> data = new ArrayList<ChiTietDonHang>();
	
	public ArrayList<ChiTietDonHang> selectAll(){
		return data;
	}
	
	public ChiTietDonHang selectById(String id) {
		ChiTietDonHang tim = new ChiTietDonHang();
		tim.setMaChiTietDonHang(id);
		
		for(ChiTietDonHang chiTietDonHang: data) {
			if(chiTietDonHang.equals(tim)) {
				return chiTietDonHang;
			}
		}
		return null;
	}
	
	public int insert(ChiTietDonHang chitiet) {
		ChiTietDonHang kiemTraTonTai = this.selectById(chitiet.getMaChiTietDonHang());
		if(kiemTraTonTai == null) {
			data.add(chitiet);
			return 1;			
		} else {
			return 0;
		}
	}
	
	public int insertAll(ArrayList<ChiTietDonHang> list) {
		int dem = 0;
		for(ChiTietDonHang chiTietDonHang : list) {
			dem += this.insert(chiTietDonHang);
		}
		return dem;
	}
	
	public int delete (ChiTietDonHang ctdh) {
		ChiTietDonHang kiemTraTonTai = this.selectById(ctdh.getMaChiTietDonHang());
		if(kiemTraTonTai != null) {
			data.remove(ctdh);
			return 1;
		}else {
			return 0;
		}
	}
	
	public int deleteAll(DonHang dh) {
		int dem = 0;
		for(ChiTietDonHang chiTietDonHang: data) {
			if(chiTietDonHang.getDonHang().equals(dh)) {
				this.delete(chiTietDonHang);
				dem++;
			}
		}
		return dem;
	}
	
	public int update(ChiTietDonHang chiTiet) {
		ChiTietDonHang kiemTraDonHang = this.selectById(chiTiet.getMaChiTietDonHang());
		if(kiemTraDonHang != null) {
			data.remove(kiemTraDonHang);
			data.add(chiTiet);
			return 1;
		} else {
			return 0;
		}
	}
}
