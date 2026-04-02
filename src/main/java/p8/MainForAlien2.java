package p8;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class MainForAlien2 {
    public static void main(String[] args) {

        // Note: Laptop data already set hai DB mei

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

// 1.
// Now we want to fetch based on primary key. So for that we don't even need Transaction
//        Laptop l2 = session.find(Laptop.class,3);
//        System.out.println(l2);

// 2.
// Now we want to fetch based on other column except pk
// In SQL we do like this: select * from laptop where ram = 32;
// In HQl : From laptop where ram = '32';

        // Query query = session.createQuery("from Laptop", Laptop.class); // Give all rows of Laptop table
        Query query = session.createQuery("from Laptop where ram='32'", Laptop.class);
        List<Laptop> laptops = query.getResultList(); // Here executing the query just like JDBC and getResultList(): Give the list of value
        System.out.println(laptops);

        session.close();
        sf.close();

    }


}
