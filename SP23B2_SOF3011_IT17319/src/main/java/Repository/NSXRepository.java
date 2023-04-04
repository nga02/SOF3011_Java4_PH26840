package repository;

import DomainModel.NhaSX;
import Utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;


import java.util.List;
import java.util.UUID;

public class NSXRepository {
    private Session hSession;

    public NSXRepository() {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(NhaSX nsx) {
      try{
          this.hSession.getTransaction().begin();
          this.hSession.persist(nsx);
          this.hSession.getTransaction().commit();
      }catch(Exception e){
          e.printStackTrace();
          this.hSession.getTransaction().rollback();
      }
    }

    public void update(NhaSX nsx) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.update(nsx);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void delete(NhaSX nsx) {
        try{
            this.hSession.getTransaction().begin();
            this.hSession.delete(nsx);
            this.hSession.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public List<NhaSX> findAll(){
        String hql = "SELECT n FROM NhaSX n";
        TypedQuery<NhaSX> q = this.hSession.createQuery(hql,NhaSX.class);
        return q.getResultList();
    }
    public NhaSX findByMa(String ma){
        String hql = "SELECT n FROM NhaSX n WHERE n.ma = ?1";
        TypedQuery<NhaSX> q = this.hSession.createQuery(hql,NhaSX.class);
        q.setParameter(1,ma);
        return q.getSingleResult();
    }
    public NhaSX findById(UUID id){
        String hql = "SELECT n FROM NhaSX n WHERE n.id = ?1";
        TypedQuery<NhaSX> q = this.hSession.createQuery(hql,NhaSX.class);
        q.setParameter(1,id);
        return q.getSingleResult();
    }
}
