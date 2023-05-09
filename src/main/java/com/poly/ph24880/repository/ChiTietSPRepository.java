package com.poly.ph24880.repository;

import com.poly.ph24880.entity.ChiTietSP;
import com.poly.ph24880.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ChiTietSPRepository {

    public List<ChiTietSP> getAll() {
        List<ChiTietSP> listCTSP = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChiTietSP ", ChiTietSP.class);
            listCTSP = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listCTSP;
    }

    public ChiTietSP getOne(String id){
        ChiTietSP chiTietSP = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChiTietSP WHERE Id=:id", ChiTietSP.class);
            query.setParameter("id", id);
            chiTietSP = (ChiTietSP) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return chiTietSP;
    }

    public Boolean add(ChiTietSP chiTietSP){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(chiTietSP);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean update(ChiTietSP chiTietSP){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(chiTietSP);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean delete(ChiTietSP chiTietSP){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(chiTietSP);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ChiTietSPRepository().getAll());
    }

}
