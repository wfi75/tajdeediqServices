package net.tajdeediq.helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import net.tajdeediq.model.User;

public class DBHandler {
    private static final String PERSISTENCE_UNIT_NAME = "tajdeed";
    private static EntityManagerFactory sessionFactory;

    public static void addUesr(String username, String password, String email) throws NoSuchAlgorithmException {
        sessionFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = sessionFactory.createEntityManager();
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i]) + 0x100, 16).substring(1));
        }
        password = sb.toString();
        em.getTransaction().begin();
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        user.setEmail(email);
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }
}
