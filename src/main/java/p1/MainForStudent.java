package p1;// 2.
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainForStudent {
    public static void main(String[] args) {
        Student s1 = new Student();
//        s1.setRollNo(105);
//        s1.setsName("Avni");
//        s1.setsAge(22);

// 1. we want these into database
/*

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Student.class);
//        when u call this method, it actually loads the cfg.xml.
        cfg.configure();

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(s1 );
        transaction.commit();

        session.close();
        sf.close();

        // printing the data
        System.out.println(s1);

 */


// 2. OPTIMISING ABOVE CODE::
/*
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        // Creating
        Transaction transaction = session.beginTransaction();
        session.persist(s1 );
        transaction.commit();

        session.close();
        sf.close();

        // printing the data
        System.out.println(s1);

 */

// 3. Fetching the data
/*
        Student s2 = null;
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        // Fetching or read
       // session.get(); // It is depreciated in 7.1.0 but not removed
        s2 = session.find(Student.class,102);

        session.close();
        sf.close();

        // printing the data
        System.out.println(s2);

 */

// 4. Updating. update() is depreciated.
/*
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        // Suppose change Avni age 20 -> 22
        Transaction transaction = session.beginTransaction();
        session.merge(s1);
        transaction.commit();

        session.close();
        sf.close();

        // printing the data
        System.out.println(s1);

 */

// 5. Deleting. 'delete()' is depreciated. '.set()' ka sara method comment kar do. qk delete kar rhe, set nhi kar rhe

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        // Suppose delete ankit from table
        // first fetch then delete
        s1 = session.find(Student.class,104);
        Transaction transaction = session.beginTransaction();
        session.remove(s1);
        transaction.commit();

        session.close();
        sf.close();

        // printing the data
        System.out.println(s1);


    }
}
