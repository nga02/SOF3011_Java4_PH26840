package repository;

import DomainModel.DongSP;
import DomainModel.NhaSX;
import Utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import view_models.QLDongSP;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DongSPRepository {
    private Session hSession;

    public DongSPRepository() {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }
    public void insert(DongSP dsp){
       try{
           this.hSession.getTransaction().begin();
           this.hSession.persist(dsp);
           this.hSession.getTransaction().commit();
       }catch(Exception e){
           e.printStackTrace();
           this.hSession.getTransaction().rollback();
       }
    }
    public void update(DongSP dsp){
        try{
            this.hSession.getTransaction().begin();
            this.hSession.update(dsp);
            this.hSession.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void delete(DongSP dsp){
        try{
            this.hSession.getTransaction().begin();
            this.hSession.delete(dsp);
            this.hSession.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public List<DongSP> findAll(){
        String hql = "SELECT d FROM DongSP d";
        TypedQuery<DongSP> q = this.hSession.createQuery(hql,DongSP.class);
        return q.getResultList();
    }
    public DongSP findByMa(String ma){
        String hql = "SELECT d FROM DongSP d WHERE d.ma = ?1";
        TypedQuery<DongSP> q = this.hSession.createQuery(hql,DongSP.class);
        q.setParameter(1,ma);
        return q.getSingleResult();
    }

    public DongSP findById(UUID id){
        String hql = "SELECT d FROM DongSP d WHERE d.id = ?1";
        TypedQuery<DongSP> q = this.hSession.createQuery(hql,DongSP.class);
        q.setParameter(1,id);
        return q.getSingleResult();
    }
}
