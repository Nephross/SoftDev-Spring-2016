/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResourcesPools;

/**
 *
 * @author Nephross
 */
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.AnnotationConfiguration;
import Domain.*;

public class HibernateSessionManager {
    
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
        // Create the SessionFactory from hibernate.cfg.xml
            return new AnnotationConfiguration().configure("/main/resources/hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();
        } catch (Throwable ex) {
        // Make sure you log the exception, as it might be swallowed
            System.err.println("SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
            }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}