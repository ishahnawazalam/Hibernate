package p2;

import jakarta.persistence.*;

//@Entity(name = "alien_table")
@Entity
@Table(name = "alien_table")
public class Alien {

    @Id
    private int aid;
    @Column(name = "alien_name")
    private String aname;
    @Transient
    private String tech;

    public void setAid(int aid) {
        this.aid = aid;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public void setTech(String tech) {
        this.tech = tech;
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

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }
}
