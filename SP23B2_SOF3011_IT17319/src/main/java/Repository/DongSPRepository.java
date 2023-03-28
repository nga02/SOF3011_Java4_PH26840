package repository;

import View_models.QLDongSP;

import java.util.ArrayList;

public class DongSPRepository {
    private ArrayList<QLDongSP> ds;

    public DongSPRepository() {
        this.ds = new ArrayList<>();
    }
    public void insert(QLDongSP qldsp){
        this.ds.add(qldsp);
    }
    public void update(QLDongSP qldsp){
        for (int i = 0; i < this.ds.size(); i++) {
            QLDongSP spvm = this.ds.get(i);
            if(spvm.getMa().equals(qldsp.getMa())){
                this.ds.set(i,qldsp);
            }
        }
    }
    public void delete(QLDongSP qldsp){
        for (int i = 0; i < this.ds.size(); i++) {
            QLDongSP spvm = this.ds.get(i);
            if(spvm.getMa().equals(qldsp.getMa())){
                this.ds.remove(i);
            }
        }
    }
    public ArrayList<QLDongSP> findAll(){
        return this.ds;
    }

    public QLDongSP findByMa(String ma){
        for (QLDongSP spvm:this.ds) {
            if(spvm.getMa().equals(ma)){
                return spvm;
            }
        }
        return null;
    }
}
