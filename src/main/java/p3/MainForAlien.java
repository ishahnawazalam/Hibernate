package p3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainForAlien {

    public static void main(String[] args) {
        Laptop l1 = new Laptop();
        l1.setBrand("Asus");
        l1.setModel("Rog");
        l1.setRam("16");

        Alien a1 = new Alien();
        a1.setAid(1);
        a1.setAname("Naveen");
        a1.setTech("Java");
        a1.setLaptop(l1);



        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Alien.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();


        Transaction transaction = session.beginTransaction();
        session.persist(a1);
        transaction.commit();

        // Fetch the data
        Alien a2 = session.find(Alien.class,101);
        System.out.println(a2);

        session.close();
        sf.close();

        System.out.println(a1);
    }
}
