package repository;


import DomainModel.ChucVu;
import DomainModel.CuaHang;
import Utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import view_models.QLCuaHang;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CuaHangRepository {
    private Session hSession;

    public CuaHangRepository() {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(CuaHang ch) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(ch);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void update(CuaHang ch) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.update(ch);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void delete(CuaHang ch) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(ch);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public List<CuaHang> findAll() {
        String hql = "SELECT h FROM CuaHang h";
        TypedQuery<CuaHang> q = this.hSession.createQuery(hql, CuaHang.class);
        return q.getResultList();
    }

    public CuaHang findByMa(String ma) {
        String hql = "SELECT h FROM CuaHang h WHERE h.ma = ?1";
        TypedQuery<CuaHang> q = this.hSession.createQuery(hql, CuaHang.class);
        q.setParameter(1, ma);
        return q.getSingleResult();
    }

    public CuaHang findById(UUID id) {
        String hql = "SELECT h FROM CuaHang h WHERE h.id = ?1";
        TypedQuery<CuaHang> q = this.hSession.createQuery(hql, CuaHang.class);
        q.setParameter(1, id);
        return q.getSingleResult();
    }
}
