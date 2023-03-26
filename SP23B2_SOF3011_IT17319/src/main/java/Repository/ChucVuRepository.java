package Repository;

import View_models.QLChucVu;
import java.util.ArrayList;

public class ChucVuRepository {
    private ArrayList<QLChucVu> ds;

    public ChucVuRepository() {
        this.ds = new ArrayList<>();
    }
    public void insert(QLChucVu qlcv){

        this.ds.add(qlcv);
    }
    public void update(QLChucVu qlcv){
        for (int i = 0; i < this.ds.size(); i++) {
            QLChucVu vm = this.ds.get(i);
            if(vm.getMa().equals(qlcv.getMa())){
                this.ds.set(i,qlcv);
            }
        }
    }

    public void delete(QLChucVu qlcv){
        for (int i = 0; i < this.ds.size(); i++) {
            QLChucVu vm = this.ds.get(i);
            if(vm.getMa().equals(qlcv.getMa())){
                this.ds.remove(i);
            }
        }
    }

    public ArrayList<QLChucVu> findAll(){
        return this.ds;
    }
    public QLChucVu findByMa(String ma){
        for(QLChucVu vm: this.ds){
            if(vm.getMa().equals(ma)){
                return vm;
            }
        }
        return null;
    }
}
