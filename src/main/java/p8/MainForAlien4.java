package p8;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class MainForAlien4 {
    public static void main(String[] args) {

        // Note: Laptop data already set hai DB mei

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

// we also want to print brand with model
        String brand = "Asus";
        Query query = session.createQuery("select brand,model from Laptop where brand like ?1");
        query.setParameter(1,brand);
        List<Object[]> laptops = query.getResultList();
        // we get list of objects, And from that object we fetch brand and model for each laptop
        for(Object[] data : laptops){
            System.out.println((String)data[0] + " " + (String)data[1] );
        }

//        System.out.println(laptops); // print object

        session.close();
        sf.close();
    }
}
