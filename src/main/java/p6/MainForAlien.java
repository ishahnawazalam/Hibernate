// ManytoMany mapping
package p6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class MainForAlien {

    public static void main(String[] args) {
        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("Asus");
        l1.setModel("Rog");
        l1.setRam("16");

        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setBrand("Dell");
        l2.setModel("XPS");
        l2.setRam("32");

        Laptop l3 = new Laptop();
        l3.setLid(3);
        l3.setBrand("Apple");
        l3.setModel("Macbook");
        l3.setRam("8");

        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("Naveen");
        a1.setTech("Java");

        Alien a2 = new Alien();
        a2.setAid(102);
        a2.setAname("Harsh");
        a2.setTech("Python");

        Alien a3 = new Alien();
        a3.setAid(103);
        a3.setAname("Kiran");
        a3.setTech("SpringBoot");

        a1.setLaptops(Arrays.asList(l1,l2));
        a2.setLaptops(Arrays.asList(l2,l3));
        a3.setLaptops(Arrays.asList(l1));

//        laptops belong to which aliens
        l1.setAliens(Arrays.asList(a1,a3));
        l2.setAliens(Arrays.asList(a1,a2));
        l3.setAliens(Arrays.asList(a2));



        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();


        Transaction transaction = session.beginTransaction();
        // u also need to persist laptop also
        session.persist(l1);
        session.persist(l2);
        session.persist(l3);

        session.persist(a1);
        session.persist(a2);
        session.persist(a3);
        transaction.commit();

        // Fetch the data
//        Alien a5 = session.find(Alien.class,102);
//        System.out.println(a5);

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