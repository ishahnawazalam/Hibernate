package p8;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class MainForAlien3 {
    public static void main(String[] args) {

        // Note: Laptop data already set hai DB mei

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

// 1. Pass value from outside just like prepared statement('?')
// SQL : SELECT * FROM Laptop WHERE brand LIKE 'Asus%';
// HQL : "from Laptop where brand like 'Asus'"

        String brand = "Asus";
//        Query query = session.createQuery("from Laptop where brand like ?1", Laptop.class);
        Query query = session.createQuery("select model from Laptop where brand like ?1");
        query.setParameter(1,brand);
//        List<Laptop> laptops = query.getResultList();
        List<String> laptops = query.getResultList();
        System.out.println(laptops);



        session.close();
        sf.close();
    }
}

// - Without the %, LIKE acts exactly like an '=' sign
// - 'Asus%' finds anything starting with Asus (e.g., "Asus Vivobook").
// - or HQL: FROM Laptop WHERE brand LIKE 'Asus%'
