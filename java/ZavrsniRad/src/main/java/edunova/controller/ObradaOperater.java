/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Operater;
import edunova.util.EdunovaException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Feecho
 */
public class ObradaOperater extends Obrada<Operater> {

    @Override
    public List<Operater> read() {
        return session.createQuery("from Operater", Operater.class).list();
    }

    public void unosAdminOperatera() {
        Operater o = new Operater();
        o.setUsername("Admin");
        o.setLozinka(BCrypt.hashpw("edunova", BCrypt.gensalt()).toCharArray());

        entitet = o;
        try {
            create();
        } catch (EdunovaException ex) {

        }
    }

    public Operater Autoriziraj(String username, char[] lozinka) {
        Operater o = null;
        try {
            o = session.createQuery("from Operater o where username=:username ", Operater.class)
                    .setParameter("username", username)
                    .getSingleResult();

        } catch (Exception e) {
            return null;
        }

        if (BCrypt.checkpw(new String(lozinka), new String(o.getLozinka()))) {
            return o;
        }
        return null;
    }

    @Override
    public void kontrolaUnos() throws EdunovaException {
    }

    @Override
    public void kontrolaPromjena() throws EdunovaException {
    }

    @Override
    public void kontrolaBrisanje() throws EdunovaException {
    }

    public void unosOperatera(String username, String password) {
        Operater o = new Operater();
        o.setUsername(username);
        o.setLozinka(BCrypt.hashpw(password, BCrypt.gensalt()).toCharArray());

        entitet = o;
        try {
            create();
        } catch (EdunovaException ex) {

        }
    }

}
