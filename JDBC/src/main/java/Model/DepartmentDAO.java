package Model;

public class DepartmentDAO {

private int id;
private String nameD;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameD() {
        return nameD;
    }

    public void setNameD(String nameD) {
        this.nameD = nameD;
    }

    public DepartmentDAO(int id, String nameD) {
        this.id = id;
        this.nameD = nameD;
    }
}
