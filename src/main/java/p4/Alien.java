package p4;

import jakarta.persistence.*;


@Entity
public class Alien {

    @Id
    private int aid;
    private String aname;
    private String tech;
    @OneToOne
    private Laptop laptop;

    public void setAid(int aid) {
        this.aid = aid;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public int getAid() {
        return aid;
    }

    public String getAname() {
        return aname;
    }

    public String getTech() {
        return tech;
    }

    public Laptop getLaptop() {
        return laptop;
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
