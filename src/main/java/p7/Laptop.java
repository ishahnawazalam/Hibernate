package p7;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Laptop {

    @Id
    private int lid;
    private String brand;
    private String model;
    private String ram;

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


    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getRam() {
        return ram;
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
