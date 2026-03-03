package p6;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Laptop {

    @Id
    private int lid;
    private String brand;
    private String model;
    private String ram;
    @ManyToMany(mappedBy = "laptops")
    private List<Alien> aliens;

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

    public void setAliens(List<Alien> aliens) {
        this.aliens = aliens;
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

    public List<Alien> getAliens() {
        return aliens;
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
