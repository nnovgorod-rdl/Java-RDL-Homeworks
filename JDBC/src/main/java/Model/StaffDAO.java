package Model;

import java.math.BigDecimal;

public class StaffDAO {
    private String FIO;
    private BigDecimal salary;
    private String position;
    private int id;

    public StaffDAO(String FIO, BigDecimal salary, String position, int id) {
        this.FIO = FIO;
        this.salary = salary;
        this.position = position;
        this.id = id;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StaffDAO{" +
                "FIO='" + FIO + '\'' +
                ", salary=" + salary +
                ", position='" + position + '\'' +
                ", id=" + id +
                '}';
    }
}