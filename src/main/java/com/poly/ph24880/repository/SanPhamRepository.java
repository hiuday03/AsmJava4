package com.poly.ph24880.repository;

import com.poly.ph24880.entity.SanPham;
import com.poly.ph24880.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class SanPhamRepository {

    public List<SanPham> getAll() {
        List<SanPham> listSP = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM SanPham ", SanPham.class);
            listSP = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listSP;
    }

    public SanPham getOne(String id){
        SanPham sanPham = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM SanPham WHERE Id=:id", SanPham.class);
            query.setParameter("id", id);
            sanPham = (SanPham) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return sanPham;
    }

    public Boolean add(SanPham sanPham){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(sanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean update(SanPham sanPham){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(sanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean delete(SanPham sanPham){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(sanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

}
