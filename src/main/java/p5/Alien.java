package p5;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;


@Entity
public class Alien {

    @Id
    private int aid;
    private String aname;
    private String tech;
    @OneToMany(mappedBy = "alien")
    private List<Laptop> laptops;

    public void setAid(int aid) {
        this.aid = aid;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
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

    public List<Laptop> getLaptops() {
        return laptops;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", tech='" + tech + '\'' +
                ", laptops=" + laptops +
                '}';
    }
}
