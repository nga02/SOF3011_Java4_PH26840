package repository;

import View_models.QLCTSP;


import java.util.ArrayList;

public class ChiTietSPRepository {
    private ArrayList<QLCTSP> ds;

    public ChiTietSPRepository(){
        this.ds = new ArrayList<>();
    }
    public void insert(QLCTSP ctsp) {
        this.ds.add(ctsp);
    }

    public void update(QLCTSP ctsp) {
        for (int i = 0; i < this.ds.size(); i++) {
            QLCTSP vm = this.ds.get(i);
            if (vm.getIdsp().equals(ctsp.getIdsp())) {
                this.ds.set(i, ctsp);
            }
        }
    }

    public void delete(QLCTSP ctsp) {
        for (int i = 0; i < this.ds.size(); i++) {
            QLCTSP vm = this.ds.get(i);
            if (vm.getIdsp().equals(ctsp.getIdsp())) {
                this.ds.remove(i);
            }
        }
    }

    public ArrayList<QLCTSP> findAll() {
        return this.ds;
    }

    public QLCTSP findById(String id) {
        for (QLCTSP vm : this.ds) {
            if (vm.getIdsp().equals(id)) {
                return vm;
            }
        }
        return null;
    }
}
