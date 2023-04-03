package repository;

import DomainModel.ChiTietSP;
import DomainModel.NhanVien;
import Utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import view_models.QLNhanVien;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NhanVienRepository {
    private Session hSession;

    public NhanVienRepository() {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(NhanVien nv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(nv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }

    }

    public void update(NhanVien nv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.update(nv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }

    }

    public void delete(NhanVien nv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(nv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }

    }

    public List<NhanVien> findAll() {
        String hql = "SELECT c FROM NhanVien c";
        TypedQuery<NhanVien> q = this.hSession.createQuery(hql,NhanVien.class);
        return q.getResultList();
    }

    public NhanVien findById(UUID id) {
        String hql = "SELECT c FROM NhanVien c WHERE  c.id = ?1";
        TypedQuery<NhanVien> q = this.hSession.createQuery(hql, NhanVien.class);
        q.setParameter(1, id);
        return q.getSingleResult();
    }

    public NhanVien findByMa(String ma) {
        String hql = "SELECT c FROM NhanVien c WHERE  c.ma = ?1";
        TypedQuery<NhanVien> q = this.hSession.createQuery(hql, NhanVien.class);
        q.setParameter(1, ma);
        return q.getSingleResult();
    }
}
