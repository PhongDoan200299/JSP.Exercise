package database;

import java.util.ArrayList;
import java.util.Iterator;

import model.DonHang;
import model.TacGia;

public class DonHangDAO {
	private ArrayList<DonHang> data = new ArrayList<DonHang>();
	
	public ArrayList<DonHang> selectAll(){
		return data;
	}
	
	public DonHang selecById(String id) {
		DonHang tim = new DonHang();
		tim.setMaDonHang(id);
		
		for(DonHang donHang : data) {
			if (donHang.equals(tim)) {
				return donHang;
			}
		}
		return null;
	}
	
	public int insert(DonHang dh) {
		DonHang kiemTraTonTai = this.selecById(dh.getMaDonHang());
		if (kiemTraTonTai == null) {
			data.add(dh);
			return 1;
		} else {
			return 0;
		}
	}
	
	public int insertAll(ArrayList<DonHang> list) {
		int dem = 0;
		for(DonHang dh : list) {
			dem += this.insert(dh);
		}
		return dem;
	}
	
	public int delete(DonHang dh) {
		DonHang kiemTraTonTai = this.selecById(dh.getMaDonHang());
		if(kiemTraTonTai != null) {
			// Xoa di cac chi tiet don hang
			ChiTietDonHangDAO cttdh = new ChiTietDonHangDAO();
			cttdh.deleteAll(dh);
			// xoa don hang
			data.remove(dh);
			return 1;
		} else {
			return 0;
		}	
	}
	
	public void deleteAll(ArrayList<DonHang> list) {
		list.clear();
	}
	
	public int update(DonHang dh) {
		DonHang kiemTraTonTai = this.selecById(dh.getMaDonHang());
		if(kiemTraTonTai != null) {
			data.remove(kiemTraTonTai);
			data.add(dh);
			return 1;
		} else {
			return 0;
		}
	}
}
