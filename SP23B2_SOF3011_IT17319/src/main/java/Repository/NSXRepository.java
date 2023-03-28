package repository;

import View_models.QLNSX;

import java.util.ArrayList;

public class NSXRepository {
    private ArrayList<QLNSX> ds;

    public NSXRepository() {
        this.ds = new ArrayList<>();
    }

    public void insert(QLNSX qlnsx) {
        ds.add(qlnsx);
    }

    public void update(QLNSX qlnsx) {
        for (int i = 0; i < this.ds.size(); i++) {
            QLNSX vm = this.ds.get(i);
            if (vm.getMa().equals(qlnsx.getMa())) {
                this.ds.set(i, qlnsx);
            }
        }
    }
    public void delete(QLNSX qlnsx){
        for (int i = 0; i < this.ds.size(); i++) {
            QLNSX nsxvm = this.ds.get(i);
            if(nsxvm.getMa().equals(qlnsx.getMa())){
                this.ds.remove(i);
            }
        }
    }
    public ArrayList<QLNSX> findAll(){
        return this.ds;
    }
    public QLNSX findByMa(String ma){
        for (QLNSX nsxvm:this.ds) {
            if(nsxvm.getMa().equals(ma)){
                return nsxvm;
            }
        }
        return null;
    }
}
