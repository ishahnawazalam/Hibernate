// Hibernate Query Language
package p8;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;


public class MainForAlien {

    public static void main(String[] args) {
//        Laptop l1 = new Laptop();
//        l1.setLid(5);
//        l1.setBrand("Asus");
//        l1.setModel("Strix");
//        l1.setRam("32");

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

//        Transaction transaction = session.beginTransaction();
//        session.persist(l1);
//        transaction.commit();

// Now we want to fetch based on primary key. So for that we don't even need Transaction
//        Laptop l1 = session.find(Laptop.class,3);
//        System.out.println(l1);

// Now we want to fetch based on other column except pk
// In SQL we do like this: select * from laptop where ram = 32;
// In HQl : From laptop where ram = 8;
//        Query query = session.createQuery("from Laptop where ram='32'", Laptop.class);
//        Query query = session.createQuery("from Laptop where brand like 'Asus'", Laptop.class);
        String brand = "Asus";
//        Query query = session.createQuery("from Laptop where brand like ?1", Laptop.class);
//        Query query = session.createQuery("select model from Laptop where brand like ?1");
//        query.setParameter(1,brand);
//        List<Laptop> laptops = query.getResultList();
//        System.out.println(laptops);

        // we also want to print brand with model
        Query query = session.createQuery("select brand,model from Laptop where brand like ?1");
        query.setParameter(1,brand);
        List<Object[]> laptops = query.getResultList();
        // we get list of objects, And from that object we fetch brand and model for each laptop
        for(Object[] data : laptops){
            System.out.println((String)data[0] + " " + (String)data[1] );
        }

        System.out.println(laptops);



        session.close();
        sf.close();
    }
}

/*
-> Internally: Laptop[] arr = { l1, l2 };
-> Arrays.asList() us array par List ka wrapper bana deta hai
      List<Laptop> list = Arrays.asList(arr);
- Same memory reference hota hai. Copy nahi banti

->
Laptop l1 = new Laptop();  // object1
Laptop l2 = new Laptop();  // object2
List<Laptop> list = Arrays.asList(l1, l2);
 */