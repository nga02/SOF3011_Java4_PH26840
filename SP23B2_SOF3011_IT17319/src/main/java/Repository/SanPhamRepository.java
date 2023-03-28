package repository;

import View_models.QLSanPham;

import java.util.ArrayList;

public class SanPhamRepository {
    private ArrayList<QLSanPham> ds;

    public SanPhamRepository() {
        this.ds = new ArrayList<>();
    }

    public void insert(QLSanPham qlsp) {
        this.ds.add(qlsp);
    }

    public void update(QLSanPham qlsp) {
        for (int i = 0; i < this.ds.size(); i++) {
            QLSanPham vm = this.ds.get(i);
            if (vm.getMa().equals(qlsp.getMa())) {
                this.ds.set(i, qlsp);
            }
        }
    }

    public void delete(QLSanPham qlsp) {
        for (int i = 0; i < this.ds.size(); i++) {
            QLSanPham spvm = this.ds.get(i);
            if (spvm.getMa().equals(qlsp.getMa())) {
                this.ds.remove(i);
            }
        }
    }

    public ArrayList<QLSanPham> findAll() {
        return this.ds;
    }

    public QLSanPham findByMa(String ma) {
        for (QLSanPham spvm : this.ds) {
            if (spvm.getMa().equals(ma)) {
                return spvm;
            }
        }
        return null;
    }
}
