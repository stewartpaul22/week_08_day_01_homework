package db;

import models.Author;
import models.Book;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DBAuthor {

    private static Transaction transaction;
    private static Session session;

    public static void saveAuthor(Author author) {

        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public static List<Author> getAuthors() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Author> authors = null;
        try {
            transaction = session.beginTransaction();
            String hql = "from Author";
            authors = session.createQuery(hql).list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return authors;
    }

    public static void updateAuthor(Author author) {

        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(author);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public static void deleteAll(){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            String hql = "delete from Author";
            Query query = session.createQuery(hql);
            query.executeUpdate();
        } catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List<Book> getBooks(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Book> books = null;
        try {
            transaction = session.beginTransaction();
            String hql = "from Book WHERE author_id = :id";
            Query query = session.createQuery(hql);
            query.setInteger("id", id);
            books = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return books;
    }

}
