package Model;

public class Animal {
    private int id;
    private String name;
    private String birthdate;
    private int sex;

    public Animal(int id, String name, String birthdate, int sex) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
