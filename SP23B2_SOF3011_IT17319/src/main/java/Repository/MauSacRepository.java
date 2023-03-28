package repository;

import DomainModel.ChucVu;
import DomainModel.MauSac;
import Utils.HibernateUtil;
import View_models.QLMauSac;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class MauSacRepository {
    private Session hSession;

    public MauSacRepository() {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(MauSac ms) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(ms);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void update(MauSac ms) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.update(ms);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void delete(MauSac ms) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(ms);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public List<MauSac> findAll() {
        String hql = "SELECT m FROM MauSac m";
        TypedQuery<MauSac> q = this.hSession.createQuery(hql, MauSac.class);
        return q.getResultList();
    }

    public MauSac findByMa(String ma) {
        String hql = "SELECT c FROM MauSac c  WHERE c.ma = ?1";
        TypedQuery<MauSac> q = this.hSession.createQuery(hql, MauSac.class);
        q.setParameter(1, ma);
        return q.getSingleResult();
    }
}
