// 1.

package p1;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    private int rollNo;
    private String sName;
    private int sAge;

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public void setsAge(int sAge) {
        this.sAge = sAge;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getsName() {
        return sName;
    }

    public int getsAge() {
        return sAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", sName='" + sName + '\'' +
                ", sAge=" + sAge +
                '}';
    }
}
