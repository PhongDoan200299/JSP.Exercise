package database;

import java.util.ArrayList;

import model.ChiTietDonHang;
import model.DonHang;

public class DonHangDAO implements DAOInterfare<DonHang>{
	private ArrayList<DonHang> data = new ArrayList<DonHang>();
	@Override
	public ArrayList<DonHang> selectAll() {
		return this.data;
	}

	@Override
	public DonHang selectById(DonHang t) {
		for(DonHang dh: data) {
			if(data.equals(t)) {
				return dh;
			}
		}
		return null;
	}

	@Override
	public int insert(DonHang t) {
		if(this.selectById(t)==null) {
			this.data.add(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<DonHang> arr) {
		int dem = 0;
		for(DonHang dh : arr) {
			dem += this.insert(dh);
		}
		return dem;
	}

	@Override
	public int delete(DonHang t) {
		if(this.selectById(t) != null) {
			this.data.remove(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<DonHang> arr) {
		int dem = 0;
		for(DonHang dh : arr) {
			dem+= this.delete(dh);
		}
		return dem;
	}

	@Override
	public int update(DonHang t) {
		if(this.selectById(t)!=null) {
			this.data.remove(t);
			this.data.add(t);
			return 1;
		}
		return 0;
	}

}
