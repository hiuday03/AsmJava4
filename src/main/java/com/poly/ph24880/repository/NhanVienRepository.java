package com.poly.ph24880.repository;

import com.poly.ph24880.entity.NhanVien;
import com.poly.ph24880.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class NhanVienRepository {

    public List<NhanVien> getAll() {
        List<NhanVien> listNV = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM NhanVien ", NhanVien.class);
            listNV = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listNV;
    }

    public NhanVien getOne(String id){
        NhanVien nhanVien = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM NhanVien WHERE Id=:id", NhanVien.class);
            query.setParameter("id", id);
            nhanVien = (NhanVien) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return nhanVien;
    }

    public Boolean add(NhanVien nhanVien){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean update(NhanVien nhanVien){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean delete(NhanVien nhanVien){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

}
