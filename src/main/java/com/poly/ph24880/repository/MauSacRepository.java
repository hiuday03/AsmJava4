package com.poly.ph24880.repository;

import com.poly.ph24880.entity.MauSac;
import com.poly.ph24880.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MauSacRepository {

    public List<MauSac> getAll() {
        List<MauSac> listMS = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM MauSac ", MauSac.class);
            listMS = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listMS;
    }

    public MauSac getOne(String id){
        MauSac mauSac = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM MauSac WHERE Id=:id", MauSac.class);
            query.setParameter("id", id);
            mauSac = (MauSac) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return mauSac;
    }

    public Boolean add(MauSac mauSac){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(mauSac);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean update(MauSac mauSac){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(mauSac);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean delete(MauSac mauSac){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(mauSac);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

}
