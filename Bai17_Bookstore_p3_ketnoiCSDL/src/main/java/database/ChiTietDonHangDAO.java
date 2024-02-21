package database;

import java.util.ArrayList;

import model.ChiTietDonHang;
import model.DonHang;

public class ChiTietDonHangDAO implements DAOInterfare<ChiTietDonHang> {
	private ArrayList<ChiTietDonHang> data = new ArrayList<ChiTietDonHang>();
	@Override
	public ArrayList<ChiTietDonHang> selectAll() {
		return this.data;
	}

	@Override
	public ChiTietDonHang selectById(ChiTietDonHang t) {
		for(ChiTietDonHang chiTiet : data) {
			if(data.equals(t)) {
				return chiTiet;
			}
		}
		return null;
	}

	@Override
	public int insert(ChiTietDonHang t) {
		if(this.selectById(t) == null) {
			this.data.add(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<ChiTietDonHang> arr) {
		int dem = 0;
		for(ChiTietDonHang chiTiet : arr) {
			dem+= this.insert(chiTiet);
		}
		return dem;
	}

	@Override
	public int delete(ChiTietDonHang t) {
		if(this.selectById(t) != null) {
			this.data.remove(t);
			return 1;
		}
		 return 0;
	}


	@Override
	public int deleteAll(ArrayList<ChiTietDonHang> arr) {
		int dem = 0;
		for(ChiTietDonHang chiTiet : arr) {
			dem += this.delete(chiTiet);
		}
		return dem;
	}
	
	public int deleteAll(DonHang dh) {
		int dem = 0;
		for(ChiTietDonHang chiTietDonHang : data) {
			if(chiTietDonHang.getDonHang().equals(dh)) {
				this.delete(chiTietDonHang);
			}
		}
		return dem;
	}

	@Override
	public int update(ChiTietDonHang t) {
		if(this.selectById(t)!= null) {
			this.data.add(t);
			this.data.remove(t);
			return 1;
		}
		return 0;
	}

}
