package com.poly.ph24880.repository;

import com.poly.ph24880.entity.DongSanPham;
import com.poly.ph24880.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DongSanPhamRepository {

    public List<DongSanPham> getAll() {
        List<DongSanPham> listDSP = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM DongSanPham ", DongSanPham.class);
            listDSP = query.getResultList();
        } catch (Exception e) {
        }
        return listDSP;
    }

    public DongSanPham getOne(String id){
        DongSanPham dongSanPham = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM DongSanPham WHERE Id=:id", DongSanPham.class);
            query.setParameter("id", id);
            dongSanPham = (DongSanPham) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return dongSanPham;
    }

    public Boolean add(DongSanPham dongSanPham){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(dongSanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean update(DongSanPham dongSanPham){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(dongSanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean delete(DongSanPham dongSanPham){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(dongSanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

}
