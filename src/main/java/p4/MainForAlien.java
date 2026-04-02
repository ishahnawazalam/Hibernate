// ONEtoONE mapping
package p4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainForAlien {

    public static void main(String[] args) {
        Laptop l1 = new Laptop();
        l1.setLid(6);
        l1.setBrand("Samsung ");
        l1.setModel("Samsung 360");
        l1.setRam("16");

        Alien a1 = new Alien();
        a1.setAid(104);
        a1.setAname("Aaisha");
        a1.setTech("Python");
        a1.setLaptop(l1);



        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();


        Transaction transaction = session.beginTransaction();
        // u also need to persist laptop also l1 ko phle kiye qk mujhe laptop_id as fk chahiye in Alien Table(false statement check kar ke dekh chuka hu
        // Actually I think Laptop class mei OnetoOne krte hai to then Laptop table mei alien_id as Fk aayegi
//        session.persist(a1);
        session.persist(l1);
        session.persist(a1);
        transaction.commit();

        session.close();
        sf.close();

        System.out.println(a1);
    }
}

/*
CODE FOR alien_id AS FK IN LAPTOP TABLE
----------- MAIN KA CODE ------------
package p4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainForAlien1 {

    public static void main(String[] args) {

        Laptop l1 = new Laptop();
        l1.setLid(6);
        l1.setBrand("Samsung");
        l1.setModel("Samsung 360");
        l1.setRam("16GB");

        Alien a1 = new Alien();
        a1.setAid(104);
        a1.setAname("Aaisha");
        a1.setTech("Python");

        // 🔥 Relationship set (both sides)
        a1.setLaptop(l1);
        l1.setAlien(a1);

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(a1);
        session.persist(l1);

        transaction.commit();

        session.close();
        sf.close();

        System.out.println(a1);
    }
}

--------------- ALIEN CLASS KA CODE ----------------
package p4;

import jakarta.persistence.*;

@Entity
public class Alien {

    @Id
    private int aid;
    private String aname;
    private String tech;

    @OneToOne(mappedBy = "alien")
    private Laptop laptop;

    // Getters & Setters

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", tech='" + tech + '\'' +
                ", laptop=" + laptop +
                '}';
    }
}
---------------------- LAPTOP CLASS KA CODE -----------------
package p4;

import jakarta.persistence.*;

@Entity
public class Laptop {

    @Id
    private int lid;
    private String brand;
    private String model;
    private String ram;

    @OneToOne
    @JoinColumn(name = "alien_id") // 🔥 FK yaha banega
    private Alien alien;

    // Getters & Setters

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public Alien getAlien() {
        return alien;
    }

    public void setAlien(Alien alien) {
        this.alien = alien;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lid=" + lid +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ram='" + ram + '\'' +
                '}';
    }
}
 */
