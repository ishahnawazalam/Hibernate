// Eager and lazy Fetch
package p7;

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


        a1.setLaptops(Arrays.asList(l1,l2));
        a2.setLaptops(Arrays.asList(l3));

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();


        Transaction transaction = session.beginTransaction();
        // u also need to persist laptop
        session.persist(l1);
        session.persist(l2);
        session.persist(l3);

        session.persist(a1);
        session.persist(a2);

        transaction.commit();

//      Fetch the data : select query fire nhi hoga agar persist and fetch ek session mei kar rhe ho to
//        Alien a5 = session.find(Alien.class,101);
//        System.out.println(a5);

        session.close();

//        // new session bna rhe: qk select show nhi ho rha tha console mei even after fetching data using find method(caching concept)
        Session session1 = sf.openSession();
        Alien a5 = session1.find(Alien.class,101); // ye sirf Alien ka hee data dega (id,name,tech) no laptop data in select(It is lazy fetching by default hota hai-: Jab mangoge data tab hee milega) but when u uncomment the below line(i.e.,sout(a5) then it gives whole alien data including laptop data.Aur agar eager Fetch kar diye to uncommnet(sout(a5)) nhi bhi kroge to phir bhi Alien ka sara data including laptop data dega
//        System.out.println(a5);
        session1.close();

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