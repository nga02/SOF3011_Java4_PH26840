package Repository;

import View_models.QLKhachHang;

import java.util.ArrayList;

public class KhachHangRepository {
    private ArrayList<QLKhachHang> ds;

    public KhachHangRepository() {
        this.ds = new ArrayList<>();
    }

    public void insert(QLKhachHang qlkh) {
        this.ds.add(qlkh);
    }

    public void update(QLKhachHang qlkh) {
        for (int i = 0; i < this.ds.size(); i++) {
            QLKhachHang vm = this.ds.get(i);
            if (vm.getMa().equals(qlkh.getMa())) {
                this.ds.set(i, qlkh);
            }
        }
    }

    public void delete(QLKhachHang qlkh) {

        for (int i = 0; i < this.ds.size(); i++) {
            QLKhachHang vm = this.ds.get(i);
            if (vm.getMa().equals(qlkh.getMa())) {
                this.ds.remove(i);
            }
        }
    }

    public ArrayList<QLKhachHang> findAll() {
        return this.ds;
    }

    public QLKhachHang findByMa(String ma) {
        for (QLKhachHang vm : this.ds) {
            if (vm.getMa().equals(ma)) {
                return vm;
            }
        }
        return null;
    }
}
