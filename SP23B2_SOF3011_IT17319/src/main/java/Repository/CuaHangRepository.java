package Repository;



import View_models.QLCuaHang;

import java.util.ArrayList;

public class CuaHangRepository {
    private ArrayList<QLCuaHang> ds;

    public CuaHangRepository() {
        this.ds = new ArrayList<>();
    }
    public void insert(QLCuaHang qlch){
        ds.add(qlch);
    }
    public void update(QLCuaHang qlch){
        for (int i = 0; i < this.ds.size(); i++) {
            QLCuaHang vm = this.ds.get(i);
            if(vm.getMa().equals(qlch.getMa())){
                this.ds.set(i,qlch);
            }
        }
    }

    public void delete(QLCuaHang qlch){

        for (int i = 0; i < this.ds.size(); i++) {
            QLCuaHang vm = this.ds.get(i);
            if(vm.getMa().equals(qlch.getMa())){
                this.ds.remove(i);
            }
        }
    }

    public ArrayList<QLCuaHang> findAll(){

        return this.ds;
    }
    public QLCuaHang findByMa(String ma){
        for(QLCuaHang vm: this.ds){
            if(vm.getMa().equals(ma)){
                return vm;
            }
        }
        return null;
    }
}
