package database;

import java.util.ArrayList;
import java.util.Iterator;

import model.KhachHang;

public class KhachHangDAO {
	private ArrayList<KhachHang> data = new ArrayList<KhachHang>();
	
	public ArrayList<KhachHang> selectAll(){
		return data;
	}
	
	public KhachHang selectById(String id) {
		KhachHang tim = new KhachHang();
		tim.setMaKhachHang(id);
		
		for(KhachHang kh : data) {
			if(kh.equals(tim)) {
				return kh;
			}
		}
		return null;
	}
	
	public int insert(KhachHang kh) {
		KhachHang kiemTraTonTai = this.selectById(kh.getMaKhachHang());
		if(kiemTraTonTai == null) {
			data.add(kh);
			return 1;
		} else {
			return 0;
		}
	}
	
	private int insertAll(ArrayList<KhachHang> list) {
		int dem = 0;
		for(KhachHang kh : list) {
			dem += this.insert(kh);
		}
		return dem;
	}
	
	public int delete(KhachHang kh) {
		KhachHang kiemTraTonTai = this.selectById(kh.getMaKhachHang());
		if(kiemTraTonTai != null) {
			data.remove(kh);
			return 1;
		} else {
			return 0;
		}
	}
	
	public void deleteAll(ArrayList<KhachHang> list) {
		list.clear();
	}
	
	public int update(KhachHang kh) {
		KhachHang kiemTraTonTai = this.selectById(kh.getMaKhachHang());
		if(kiemTraTonTai != null) {
			data.remove(kiemTraTonTai);
			data.add(kh);
			return 1;
		} else {
			return 0;
		}
	}
}
