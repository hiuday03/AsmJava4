package com.poly.ph24880.repository;

import com.poly.ph24880.entity.CuaHang;
import com.poly.ph24880.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CuaHangRepository {

    public List<CuaHang> getAll() {
        List<CuaHang> listCH = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM CuaHang ", CuaHang.class);
            listCH = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listCH;
    }

    public CuaHang getOne(String id){
        CuaHang cuaHang = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM CuaHang WHERE Id=:id", CuaHang.class);
            query.setParameter("id", id);
            cuaHang = (CuaHang) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return cuaHang;
    }

    public Boolean add(CuaHang cuaHang){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(cuaHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean update(CuaHang cuaHang){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(cuaHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean delete(CuaHang cuaHang){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(cuaHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

}
