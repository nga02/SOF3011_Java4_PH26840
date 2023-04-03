package repository;

import DomainModel.SanPham;
import Utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;
import java.util.UUID;

public class SanPhamRepository {
    private Session hSession;

    public SanPhamRepository() {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(SanPham sp) {
        try{
            this.hSession.getTransaction().begin();
            this.hSession.persist(sp);
            this.hSession.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void update(SanPham sp) {
        try{
            this.hSession.getTransaction().begin();
            this.hSession.update(sp);
            this.hSession.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void delete(SanPham sp) {
        try{
            this.hSession.getTransaction().begin();
            this.hSession.delete(sp);
            this.hSession.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public List<SanPham> findAll() {
        String hql = "SELECT s FROM SanPham s";
        TypedQuery<SanPham> q = this.hSession.createQuery(hql,SanPham.class);
        return q.getResultList();
    }

    public SanPham findByMa(String ma) {
        String hql = "SELECT s FROM SanPham s  WHERE s.ma = ?1";
        TypedQuery<SanPham> q = this.hSession.createQuery(hql, SanPham.class);
        q.setParameter(1, ma);
        return q.getSingleResult();
    }

    public SanPham findById(UUID id) {
        String hql = "SELECT s FROM SanPham s  WHERE s.id = ?1";
        TypedQuery<SanPham> q = this.hSession.createQuery(hql, SanPham.class);
        q.setParameter(1, id);
        return q.getSingleResult();
    }
}
