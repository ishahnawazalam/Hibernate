// Get vs Load(depreciated)
// Only Laptop class par kaam ho rha (No Alien class involved)

package p9;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainForAlien {

    public static void main(String[] args) {

        // Note: Laptop data already set hai DB mei

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

// 1. Fetching data using Get: Eager
//        Laptop laptop1 = session.get(Laptop.class, 3); // It(using get) will fire the select query even u comment below line. When u uncomment it will fire select query plus also give result.
//        System.out.println(laptop1);

// 2. Fetching using Load
//        Laptop laptop2 = session.load(Laptop.class, 3);
        // When u comment sout(laptop2) , it will not even firing select query and not give result. Load 'laptop2' variable mei data load kr de rha so jab tak usko use nhi krenge wo result nhi dega
//        System.out.println(laptop2);  // Mangoge tab hee data deta and select query fire krega console par

// 3. Fetching using getReference(i.e., byId)(Lazy Loading)
//        Laptop laptop3 = session.byId(Laptop.class).getReference(3);
        Laptop laptop3 = session.getReference(Laptop.class,3); // depreciated-> confirm kar chuke hai gpt par
        System.out.println(laptop3);


        session.close();
        sf.close();
    }
}
