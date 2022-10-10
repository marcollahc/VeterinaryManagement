package Model;


public class Animal {
    private int id;
    private String name;
    private String birthdate;
    private int sex;
    private int specie_id;
    private int client_id;

    public Animal(int id, String name, String birthdate, int sex, int specie_id, int client_id) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.sex = sex;
        this.specie_id = specie_id;
        this.client_id = client_id;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public int getSex() {
        return this.sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSpecieId() {
        return this.specie_id;
    }

    public void setSpecieId(int specie_id) {
        this.specie_id = specie_id;
    }

    public int getClientId() {
        return this.client_id;
    }

    public void setClientId(int client_id) {
        this.client_id = client_id;
    }
}
