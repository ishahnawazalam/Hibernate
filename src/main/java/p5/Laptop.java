package p5;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Laptop {

    @Id
    private int lid;
    private String brand;
    private String model;
    private String ram;
    // don't want 3rd table
    // from laptop perspective
    @ManyToOne
    private Alien alien;

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public void setAlien(Alien alien) {
        this.alien = alien;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getRam() {
        return ram;
    }

    public Alien getAlien() {
        return alien;
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
