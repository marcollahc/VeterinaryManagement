/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Animal;
import Model.Client;
import Model.ClientDAO;
import Model.MedicalAppointment;
import Model.MedicalExam;
import Model.Specie;
import Model.Treatment;
import Model.Veterinary;
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

    /* public Animal create(String name, String birthdate, int sex, int specie_id, int client_id) {}
    public List retrieveAll() {}
    public List retrieveLast() {}
    public Animal retrieveByID(int id) {}
    public List retrieveAnimalsByID(int id) {}
    public List retrieveBySimilarName(String name) {}
    public void update(Animal animal) {}
    public void delete(Animal animal) {} */
    
    
    // public Client create(String name, String document, String phone, String email, String zip_code, int street_number, String street_complement) {}
    public static List<Client> retrieveAllClients() {
        System.out.println("Test!");
        return ClientDAO.getInstance().retrieveAll();
    }    
    // public List retrieveLast() {}
    // public Client retrieveByID(int id) {}
    // public List retrieveBySimilarName(String name) {}
    // public void update(Client client) {}
    // public void delete(Client client) {}
    
    
    /* public MedicalAppointment create(String date_appointment, String history, int treatment_id, int veterinary_id) {}
    public List retrieveAll() {}
    public List retrieveLast() {}
    public MedicalAppointment retrieveByID(int id) {}
    public List retrieveByTreatmentId(int id) {}
    public List retrieveByVeterinaryId(int id) {}
    public void update(MedicalAppointment medical_appointment) {}
    public void delete(MedicalAppointment medical_appointment) {}
    
    
    public MedicalExam create(String exam_description, int medical_appointment_id) {}
    public List retrieveAll() {}
    public List retrieveLast() {}
    public MedicalExam retrieveByID(int id) {}
    public List retrieveByMedicalAppointmentId(String id) {}
    public void update(MedicalExam medical_exam) {}
    public void delete(MedicalExam medical_exam) {}
    
    
    public Specie create(String name) {}
    public List retrieveAll() {}
    public List retrieveLast() {}
    public Specie retrieveByID(int id) {}
    public List retrieveBySimilarName(String name) {}
    public void update(Specie specie) {}
    public void delete(Specie specie) {}
    
    
    public Treatment create(String start_date, String final_date, int animal_id) {}
    public List retrieveAll() {}
    public List retrieveLast() {}
    public Treatment retrieveByID(int id) {}
    public List retrieveByAnimalId(int id) {}
    public List retrieveByDate(String start_date, String final_date) {}
    public void update(Treatment treatment) {}
    public void delete(Treatment treatment) {}
    
    
    public Veterinary create(String name, String document, String phone, String email, String zip_code, int street_number, String street_complement, String crmv) {}
    public List retrieveAll() {}
    public List retrieveLast() {}
    public Veterinary retrieveByID(int id) {}
    public List retrieveBySimilarName(String name) {}
    public void update(Veterinary veterinary) {}
    public void delete(Veterinary veterinary) {} */
    
}
