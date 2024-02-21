package database;

import java.util.ArrayList;

import model.SanPham;

public class SanPhamDAO {
	private ArrayList<SanPham> data = new ArrayList<SanPham>();
	
	public ArrayList<SanPham> selectAll(){
		return data;
	}
	
	public SanPham selectById(String Id) {
		SanPham tim = new SanPham();
		tim.setMaSanPham(Id);
		
		for(SanPham sanPham : data) {
			if(sanPham.equals(tim)) {
				return sanPham;
			}
		}
		return null;
	}
	
	public int insert(SanPham sp) {
		SanPham kiemTraTonTai = this.selectById(sp.getMaSanPham());
		if(kiemTraTonTai == null) {
			data.add(sp);
			return 1;
		} else {
			return 0;
		}
	}
	
	public int insertAll(ArrayList<SanPham> list) {
		int dem = 0;
		for(SanPham sanPham : list) {
			dem += this.insert(sanPham);
		}
		return dem;
	}
	
	public int delete(SanPham sp) {
		SanPham kiemTraTonTai = this.selectById(sp.getMaSanPham());
		if(kiemTraTonTai != null) {
			data.remove(sp);
			return 1;
		} else {
			return 0;
		}
	}
	
	public void deteleAll(ArrayList<SanPham> list) {
		list.clear(); 
	}
	
	public int update(SanPham sp) {
		SanPham kiemTraTonTai = this.selectById(sp.getMaSanPham());
		if(kiemTraTonTai != null) {
			data.remove(kiemTraTonTai);
			data.add(sp);
			return 1;
		} else {
			return 0;
		}
	}
}
