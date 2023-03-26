package Repository;

import View_models.QLNhanVien;

import java.util.ArrayList;

public class NhanVienRepository {
    private ArrayList<QLNhanVien> ds;

    public NhanVienRepository() {

        this.ds = new ArrayList<>();
    }

    public void insert(QLNhanVien qlnv) {
        this.ds.add(qlnv);
    }

    public void update(QLNhanVien qlnv) {
        for (int i = 0; i < this.ds.size(); i++) {
            QLNhanVien vm = this.ds.get(i);
            if (vm.getMa().equals(qlnv.getMa())) {
                this.ds.set(i, qlnv);
            }
        }
    }

    public void delete(QLNhanVien qlnv) {
        for (int i = 0; i < this.ds.size(); i++) {
            QLNhanVien vm = this.ds.get(i);
            if (vm.getMa().equals(qlnv.getMa())) {
                this.ds.remove(i);
            }
        }
    }

    public ArrayList<QLNhanVien> findAll() {

        return this.ds;
    }

    public QLNhanVien findByMa(String ma) {
        for (QLNhanVien vm : this.ds) {
            if (vm.getMa().equals(ma)) {
                return vm;
            }
        }
        return null;
    }
}
