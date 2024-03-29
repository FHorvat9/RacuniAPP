/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.util;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author dell
 */
// https://www.geeksforgeeks.org/singleton-class-java/
// ostalo čitati na https://sourcemaking.com/design_patterns
//Singleton
public class HibernateUtil {

    private static Session session = null;

    protected HibernateUtil() {

    }

    public static Session getSession() {
        if (session == null) {
            session = new Configuration().configure().buildSessionFactory().openSession();
        }
        return session;
    }

    public static void CloseSession() {
        session = null;
    }
}
