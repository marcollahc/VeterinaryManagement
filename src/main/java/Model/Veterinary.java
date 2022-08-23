package Model;

public class Veterinary {
    private int id;
    private String name;
    private String document;
    private String phone;
    private String email;
    private String zip_code;
    private int street_number;
    private String street_complement;
    private String crmv;

    public Veterinary(int id, String name, String document, String phone, String email, String zip_code, int street_number, String street_complement, String crmv) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.email = email;
        this.zip_code = zip_code;
        this.street_number = street_number;
        this.street_complement = street_complement;
        this.crmv = crmv;
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

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZipCode() {
        return zip_code;
    }

    public void setZipCode(String zip_code) {
        this.zip_code = zip_code;
    }

    public int getStreetNumber() {
        return street_number;
    }

    public void setStreetNumber(int street_number) {
        this.street_number = street_number;
    }

    public String getStreetComplement() {
        return street_complement;
    }

    public void setStreetComplement(String street_complement) {
        this.street_complement = street_complement;
    }

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }
}
