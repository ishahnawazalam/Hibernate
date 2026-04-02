// Hibernate Query Language
// Only Laptop class par kaam ho rha (No Alien class involved)
package p8;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class MainForAlien1 {

    public static void main(String[] args) {
        Laptop l1 = new Laptop();
        l1.setLid(5);
        l1.setBrand("Asus");
        l1.setModel("Strix");
        l1.setRam("32");

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(l1);
        transaction.commit();

        session.close();
        sf.close();
    }
}
