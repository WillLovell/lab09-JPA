package dataaccess;

import java.sql.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * This class was adapted from the Module 7 Demo
 * Credit to author and owner
 * 
 */
public class DBUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab9_userDBPU");

    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
}
