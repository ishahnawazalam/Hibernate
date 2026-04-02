// ONEtoMany mapping
package p5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class MainForAlien {

    public static void main(String[] args) {
        Laptop l1 = new Laptop();
        l1.setLid(201);
        l1.setBrand("Asus");
        l1.setModel("Rog");
        l1.setRam("16");

        Laptop l2 = new Laptop();
        l2.setLid(202);
        l2.setBrand("Dell");
        l2.setModel("XPS");
        l2.setRam("32");

        Alien a1 = new Alien();
        a1.setAid(301);
        a1.setAname("Naveen");
        a1.setTech("Java");
        a1.setLaptops(Arrays.asList(l1,l2));

        // Both laptops belong to a1
        l1.setAlien(a1);
        l2.setAlien(a1);



        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();


        Transaction transaction = session.beginTransaction();
        // u also need to persist laptop also l1 ko phle kiye qk mujhe laptop_id as fk chahiye in Alien Table
        session.persist(l1);
        session.persist(l2);
        session.persist(a1);
        transaction.commit();

        // Fetch the data
//        Alien a2 = session.find(Alien.class,101);
//        System.out.println(a2);

        session.close();
        sf.close();

        System.out.println(a1);
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