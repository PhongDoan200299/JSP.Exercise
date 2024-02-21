package database;

import java.util.ArrayList;
import java.util.Iterator;

import model.TheLoai;

public class TheLoaiDAO {
	private ArrayList<TheLoai> data = new ArrayList<TheLoai>();
	
	public ArrayList<TheLoai> selectAll(){
		return data;
	}
	
	public TheLoai selectById(String id) {
		TheLoai tim = new TheLoai();
		tim.setMaTheLoai(id);
		
		for(TheLoai theLoai : data) {
			if(theLoai.equals(tim)) {
				return theLoai;
			}
		}
		return null;
	}
	
	public int insert(TheLoai tl) {
		TheLoai kiemTraTonTai = this.selectById(tl.getMaTheLoai());
		if(kiemTraTonTai == null) {
			data.add(tl);
			return 1;
		} else {
			return 0;
		}
	}
	
	public int insertAll(ArrayList<TheLoai>list) {
		int dem = 0;
		for(TheLoai theLoai: list) {
			dem += this.insert(theLoai);
		}
		return dem;
	}
	
	public int delete (TheLoai tl) {
		TheLoai kiemTraTonTai = this.selectById(tl.getMaTheLoai());
		if(kiemTraTonTai != null) {
			data.remove(tl);
			return 1;
		} else {
			return 0;
		}
	}
	
	public void deleteAll(ArrayList<TheLoai>list) {
		list.clear();
	}
	
	public int update(TheLoai tl) {
		TheLoai kiemTraTonTai = this.selectById(tl.getMaTheLoai());
		if(kiemTraTonTai != null) {
			data.remove(kiemTraTonTai);
			data.add(tl);
			return 1;
		} else {
			return 0;
		}
	}
}
