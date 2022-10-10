/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Animal;
import Model.AnimalDAO;
import Model.Client;
import Model.ClientDAO;
import Model.MedicalAppointment;
import Model.MedicalAppointmentDAO;
import Model.MedicalExam;
import Model.MedicalExamDAO;
import Model.Specie;
import Model.SpecieDAO;
import Model.Treatment;
import Model.TreatmentDAO;
import Model.Veterinary;
import Model.VeterinaryDAO;
import java.util.List;

/**
 *
 * @author marcos-medeiros
 */
public class Service {
    private static Animal selectedAnimal = null;
    private static Client selectedClient = null;
    private static MedicalAppointment selectedMedicalAppointment = null;
    private static MedicalExam selectedMedicalExam = null;
    private static Specie selectedSpecie = null;
    private static Treatment selectedTreatment = null;
    private static Veterinary selectedVeterinary = null;

    // public Animal create(String name, String birthdate, int sex, int specie_id, int client_id) {}
    public static List<Animal> retrieveAllAnimals() {
        return AnimalDAO.getInstance().retrieveAll();
    }
    
    // public List retrieveLast() {}
    
    public static Animal retrieveAnimalByID(int id) {
        return AnimalDAO.getInstance().retrieveByID(id);
    }
    
    public static List<Animal> retrieveAnimalsByClientID(Object client) {
        int client_id = 0;
        
        if (client != null) {
            Client client_row = (Client) client;
            client_id = client_row.getId();
        }
        
        
        return AnimalDAO.getInstance().retrieveByClientID(client_id);
    }
    // public List retrieveBySimilarName(String name) {}
    // public void update(Animal animal) {}
    // public void delete(Animal animal) {}
    
    
    // public Client create(String name, String document, String phone, String email, String zip_code, int street_number, String street_complement) {}
    public static List<Client> retrieveAllClients() {
        return ClientDAO.getInstance().retrieveAll();
    }
    // public List retrieveLast() {}
    public static Client retrieveClientByID(int id) {
        return ClientDAO.getInstance().retrieveByID(id);
    }
    // public List retrieveBySimilarName(String name) {}
    // public void update(Client client) {}
    // public void delete(Client client) {}
    
    
    // public MedicalAppointment create(String date_appointment, String history, int treatment_id, int veterinary_id) {}
    public static List retrieveAllMedicalAppointments() {
        return MedicalAppointmentDAO.getInstance().retrieveAll();
    }
    // public List retrieveLast() {}
    public static MedicalAppointment retrieveMedicalAppointmentByID(int id) {
        return MedicalAppointmentDAO.getInstance().retrieveByID(id);
    }
    // public List retrieveByTreatmentId(int id) {}
    // public List retrieveByVeterinaryId(int id) {}
    // public void update(MedicalAppointment medical_appointment) {}
    // public void delete(MedicalAppointment medical_appointment) {}
    
    
    // public MedicalExam create(String exam_description, int medical_appointment_id) {}
    public static List retrieveAllMedicalExams() {
        return MedicalExamDAO.getInstance().retrieveAll();
    }
    // public List retrieveLast() {}
    public static MedicalExam retrieveMedicalExamByID(int id) {
        return MedicalExamDAO.getInstance().retrieveByID(id);
    }
    // public List retrieveByMedicalAppointmentId(String id) {}
    // public void update(MedicalExam medical_exam) {}
    // public void delete(MedicalExam medical_exam) {}
    
    
    // public Specie create(String name) {}
    public static List retrieveAllSpecies() {
        return SpecieDAO.getInstance().retrieveAll();
    }
    // public List retrieveLast() {}
    public static Specie retrieveSpecieByID(int id) {
        return SpecieDAO.getInstance().retrieveByID(id);
    }
    // public List retrieveBySimilarName(String name) {}
    // public void update(Specie specie) {}
    // public void delete(Specie specie) {}
    
    
    // public Treatment create(String start_date, String final_date, int animal_id) {}
    public static List retrieveAllTreatments() {
        return TreatmentDAO.getInstance().retrieveAll();
    }
    // public List retrieveLast() {}
    public static Treatment retrieveTreatmentByID(int id) {
        return TreatmentDAO.getInstance().retrieveByID(id);
    }
    // public List retrieveByAnimalId(int id) {}
    // public List retrieveByDate(String start_date, String final_date) {}
    // public void update(Treatment treatment) {}
    // public void delete(Treatment treatment) {}
    
    
    // public Veterinary create(String name, String document, String phone, String email, String zip_code, int street_number, String street_complement, String crmv) {}
    public static List retrieveAllVeterinarians() {
        return VeterinaryDAO.getInstance().retrieveAll();
    }
    // public List retrieveLast() {}
    public static Veterinary retrieveVeterinaryByID(int id) {
        return VeterinaryDAO.getInstance().retrieveByID(id);
    }
    // public List retrieveBySimilarName(String name) {}
    // public void update(Veterinary veterinary) {}
    // public void delete(Veterinary veterinary) {} */
    
}
