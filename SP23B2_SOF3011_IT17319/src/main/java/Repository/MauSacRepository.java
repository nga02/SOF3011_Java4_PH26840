package Repository;

import View_models.QLMauSac;

import java.util.ArrayList;

public class MauSacRepository {
    private ArrayList<QLMauSac> ds;
    public MauSacRepository(){
        this.ds = new ArrayList<>();
    }
    public void insert(QLMauSac qlms){
        ds.add(qlms);
    }
    public void update(QLMauSac qlms){
        for (int i = 0; i < this.ds.size() ; i++) {
            QLMauSac vm = this.ds.get(i);
            if(vm.getMa().equals(qlms.getMa())){
                this.ds.set(i,qlms);
            }
        }
    }
    public void delete(QLMauSac qlms){
        for (int i = 0; i < this.ds.size(); i++) {
            QLMauSac vm = this.ds.get(i);
            if(vm.getMa().equals(qlms.getMa())){
                this.ds.remove(i);
            }
        }
    }
    public ArrayList<QLMauSac> findAll(){
        return this.ds;
    }
    public QLMauSac findByMa(String ma){
        for(QLMauSac vm: this.ds){
            if(vm.getMa().equals(ma)){
                return vm;
            }
        }
        return null;
    }
}
