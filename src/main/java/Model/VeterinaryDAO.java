package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VeterinaryDAO {
    private List<Veterinary> veterinarians = new ArrayList<Veterinary>();
    private int veterinary_id = 1;

    public List<Veterinary> create(String name, String document, String phone, String email, String zip_code, int street_number, String street_complement, String crmv) {
        Veterinary veterinary = new Veterinary(veterinary_id, name, document, phone, email, zip_code, street_number, street_complement, crmv);
        this.veterinarians.add(veterinary);
        veterinary_id++;
        return this.veterinarians;
    }

    public List<Veterinary> retrieveAll() {
        return this.veterinarians;
    }

    public List<Veterinary> retrieveByID(int id) {
        return (List<Veterinary>) this.veterinarians.stream().filter(item -> item.getId() == id).collect(Collectors.toList());
    }

    public int update(int id, String name, String document, String phone, String email, String zip_code, int street_number, String street_complement, String crmv) {
        int index = 0;

        for (Veterinary veterinary:this.veterinarians) {
            if (veterinary.getId() == id) {
                Veterinary veterinary_update = this.veterinarians.get(index);
                veterinary_update.setName(name);
                veterinary_update.setDocument(document);
                veterinary_update.setPhone(phone);
                veterinary_update.setEmail(email);
                veterinary_update.setZipCode(zip_code);
                veterinary_update.setStreetNumber(street_number);
                veterinary_update.setStreetComplement(street_complement);
                break;
            }
            index++;
        }

        return 1;
    }

    public int delete(int id) {
        int index = 0;

        for (Veterinary veterinary:this.veterinarians) {
            if (veterinary.getId() == id) {
                this.veterinarians.remove(index);
                break;
            }
            index++;
        }

        return 1;
    }
}
