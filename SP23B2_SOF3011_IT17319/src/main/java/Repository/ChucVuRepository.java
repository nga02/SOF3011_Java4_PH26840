package repository;

import DomainModel.ChucVu;
import Utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ChucVuRepository {
    private Session hSession;

    public ChucVuRepository() {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(ChucVu cv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void update(ChucVu cv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.update(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void delete(ChucVu cv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public List<ChucVu> findAll() {
        String hql = "SELECT c FROM ChucVu c";
        TypedQuery<ChucVu> q = this.hSession.createQuery(hql, ChucVu.class);
        return q.getResultList();
    }

    public ChucVu findByMa(String ma) {
        String hql = "SELECT c FROM ChucVu c  WHERE c.ma = ?1";
        TypedQuery<ChucVu> q = this.hSession.createQuery(hql, ChucVu.class);
        q.setParameter(1, ma);
        return q.getSingleResult();
    }
}
