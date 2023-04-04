package repository;

import DomainModel.ChiTietSP;

import Utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;
import java.util.UUID;

public class ChiTietSPRepository {
    private Session hSession;

    public ChiTietSPRepository(){
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }
    public void insert(ChiTietSP ctsp) {
        try{
            this.hSession.getTransaction().begin();
            this.hSession.persist(ctsp);
            this.hSession.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }

    }

    public void update(ChiTietSP ctsp) {
        try{
            this.hSession.getTransaction().begin();
            this.hSession.update(ctsp);
            this.hSession.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void delete(ChiTietSP ctsp) {
        try{
            this.hSession.getTransaction().begin();
            this.hSession.delete(ctsp);
            this.hSession.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public List<ChiTietSP> findAll() {
        String hql = "SELECT c FROM ChiTietSP c";
        TypedQuery<ChiTietSP> q = this.hSession.createQuery(hql,ChiTietSP.class);
        return q.getResultList();
    }

    public ChiTietSP findById(UUID id) {
        String hql = "SELECT c FROM ChiTietSP c WHERE  c.id = :Id";
        TypedQuery<ChiTietSP> q = this.hSession.createQuery(hql, ChiTietSP.class);
        q.setParameter("Id", id);
        return q.getSingleResult();
    }
}
