package database;

import java.util.ArrayList;

import model.SanPham;

public class SanPhamDAO implements DAOInterfare<SanPham>{
	
	private ArrayList<SanPham> data = new ArrayList<SanPham>();
	
	@Override
	public ArrayList<SanPham> selectAll() {
		return this.data;
	}

	@Override
	public SanPham selectById(SanPham t) {
		for(SanPham sp: data) {
			if(data.equals(t)) {
				return sp;
			}
		} return null;
	}

	@Override
	public int insert(SanPham t) {
		if(this.selectById(t)==null) {
			this.data.add(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<SanPham> arr) {
		int dem = 0;
		for(SanPham sp: arr) {
			dem += this.insert(sp);
		}
		return dem;
	}

	@Override
	public int delete(SanPham t) {
		if(this.selectById(t)!= null) {
			this.data.remove(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<SanPham> arr) {
		int dem = 0;
		for(SanPham sp :arr) {
			dem += this.delete(sp);
		}
		return dem;
	}

	@Override
	public int update(SanPham t) {
		if(this.selectById(t)!= null) {
			this.data.remove(t);
		}
		return 0;
	}

}
