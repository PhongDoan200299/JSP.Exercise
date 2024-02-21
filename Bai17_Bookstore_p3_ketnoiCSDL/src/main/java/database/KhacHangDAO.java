package database;

import java.util.ArrayList;
import java.util.Iterator;

import model.KhachHang;

public class KhacHangDAO implements DAOInterfare<KhachHang> {
	private ArrayList<KhachHang> data = new ArrayList<KhachHang>();
	@Override
	public ArrayList<KhachHang> selectAll() {
		return this.data;
	}

	@Override
	public KhachHang selectById(KhachHang t) {
		for(KhachHang kh : data) {
			if(data.equals(t)) {
				return kh;
			}
		}
		return null;
	}

	@Override
	public int insert(KhachHang t) {
		if(this.selectById(t)==null) {
			this.data.add(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<KhachHang> arr) {
		int dem = 0;
		for(KhachHang kh : arr) {
			
			dem += this.insert(kh);
		}
		return dem;
	}

	@Override
	public int delete(KhachHang t) {
		if(this.selectById(t)!= null) {
			this.data.remove(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<KhachHang> arr) {
		int dem = 0;
		for(KhachHang kh : arr) {
			dem += this.delete(kh);
		}
		return dem;
	}

	@Override
	public int update(KhachHang t) {
		if(this.selectById(t)!= null) {
			this.data.remove(t);
			this.data.add(t);
		}
		return 0;
	}

}
