package com.poly.ph24880.repository;

import com.poly.ph24880.entity.KhachHang;
import com.poly.ph24880.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class KhachHangRepository {

    public List<KhachHang> getAll() {
        List<KhachHang> listKH = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM KhachHang ", KhachHang.class);
            listKH = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
    }

    public KhachHang getOne(String id){
        KhachHang khachHang = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM KhachHang WHERE ID=:id", KhachHang.class);
            query.setParameter("id", id);
            khachHang = (KhachHang) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return khachHang;
    }

    public Boolean add(KhachHang khachHang){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean update(KhachHang khachHang){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean delete(KhachHang khachHang){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

}
