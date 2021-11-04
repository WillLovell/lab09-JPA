package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Role;
import models.User;

/**
 * This class was adapted from the Module 7 Demo
 * Credit to author and owner
 * Edited by Dynamic Duo
 * 
 */
public class UserDB {

    public List<User> getAll() throws Exception {
        List<User> users = new ArrayList<>();
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

       
        users = em.createNamedQuery("User.findAll", User.class).getResultList();
        
        return users;
    }

    public User get(String email) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try{
            
        User user = em.find(User.class, email);
        return user;
        }finally{
            em.close();
        }
        
    }

    public void insert(User user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try{
           trans.begin();
        em.persist(user);
        em.merge(user);
        trans.commit(); 
        }catch (Exception ex){
        trans.rollback();
    }finally{
            em.close();
        }
        
       
    }

    public void update(User user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {

            trans.begin();
            em.merge(user);
            trans.commit();
        }catch(Exception ex){
            trans.rollback();
        }
        finally {
           em.close();
        }
    }

    public void delete(User user) throws Exception {
         EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
       User user2 = em.find(User.class, user.getEmail());
        try {
            
            trans.begin();
            em.remove(user2);
            trans.commit();

        }catch (Exception ex){
            trans.rollback();
    }finally {
            em.close();
        }

}
}
