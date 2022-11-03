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
    
    public static Animal getAnimal() {
        return Service.selectedAnimal;
    }
    
    public static void setAnimal(Object animal) {
        Service.selectedAnimal = (Animal) animal;
    }
    
    public static Client getClient() {
        return Service.selectedClient;
    }
    
    public static void setClient(Object client) {
        Service.selectedClient = (Client) client;
    }
    
    public static Specie getSpecie() {
        return Service.selectedSpecie;
    }
    
    public static void setSpecie(Object specie) {
        Service.selectedSpecie = (Specie) specie;
    }
    
    public static MedicalAppointment getMedicalAppointment() {
        return Service.selectedMedicalAppointment;
    }
    
    public static void setMedicalAppointment(Object medical_appointment) {
        Service.selectedMedicalAppointment = (MedicalAppointment) medical_appointment;
    }
    
    public static MedicalExam getMedicalExam() {
        return Service.selectedMedicalExam;
    }
    
    public static void setMedicalExam(Object medical_exam) {
        Service.selectedMedicalExam = (MedicalExam) medical_exam;
    }
    
    public static Treatment getTreatment() {
        return Service.selectedTreatment;
    }
    
    public static void setTreatment(Object treatment) {
        Service.selectedTreatment = (Treatment) treatment;
    }
    
    public static Veterinary getVeterinary() {
        return Service.selectedVeterinary;
    }
    
    public static void setVeterinary(Object veterinary) {
        Service.selectedVeterinary = (Veterinary) veterinary;
    }

    // public Animal createAnimal(String name, String birthdate, int sex, int specie_id, int client_id) {}
    public static List<Animal> retrieveAllAnimals() {
        return AnimalDAO.getInstance().retrieveAll();
    }
    
    // public List retrieveLastAnimal() {}
    
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
    // public List retrieveAnimalsBySimilarName(String name) {}
    // public void updateAnimal(Animal animal) {}
    // public void deleteAnimal(Animal animal) {}
    
    
    // public Client createClient(String name, String document, String phone, String email, String zip_code, int street_number, String street_complement) {}
    public static List<Client> retrieveAllClients() {
        return ClientDAO.getInstance().retrieveAll();
    }
    // public List retrieveLastClient() {}
    public static Client retrieveClientByID(int id) {
        return ClientDAO.getInstance().retrieveByID(id);
    }
    // public List retrieveBySimilarName(String name) {}
    // public void updateClient(Client client) {}
    // public void deleteClient(Client client) {}
    
    
    // public MedicalAppointment createMedicalAppointment(String date_appointment, String history, int treatment_id, int veterinary_id) {}
    public static List<MedicalAppointment> retrieveAllMedicalAppointments() {
        return MedicalAppointmentDAO.getInstance().retrieveAll();
    }
    // public List retrieveLastMedicalAppointment() {}
    public static MedicalAppointment retrieveMedicalAppointmentByID(int id) {
        return MedicalAppointmentDAO.getInstance().retrieveByID(id);
    }
    // public List retrieveMedicalAppointmentByTreatmentId(int id) {}
    // public List retrieveMedicalAppointmentByVeterinaryId(int id) {}
    // public void updateMedicalAppointment(MedicalAppointment medical_appointment) {}
    // public void deleteMedicalAppointment(MedicalAppointment medical_appointment) {}
    
    
    // public MedicalExam createMedicalExam(String exam_description, int medical_appointment_id) {}
    public static List<MedicalExam> retrieveAllMedicalExams() {
        return MedicalExamDAO.getInstance().retrieveAll();
    }
    // public List retrieveLastMedicalExam() {}
    public static MedicalExam retrieveMedicalExamByID(int id) {
        return MedicalExamDAO.getInstance().retrieveByID(id);
    }
    // public List retrieveMedicalExamByMedicalAppointmentId(String id) {}
    // public void updateMedicalExam(MedicalExam medical_exam) {}
    // public void deleteMedicalExam(MedicalExam medical_exam) {}
    
    
    // public Specie createSpecie(String name) {}
    public static List<Specie> retrieveAllSpecies() {
        return SpecieDAO.getInstance().retrieveAll();
    }
    // public List retrieveLastSpecie() {}
    public static Specie retrieveSpecieByID(int id) {
        return SpecieDAO.getInstance().retrieveByID(id);
    }
    // public List retrieveSpecieBySimilarName(String name) {}
    // public void updateSpecie(Specie specie) {}
    // public void deleteSpecie(Specie specie) {}
    
    
    // public Treatment createTreatment(String start_date, String final_date, int animal_id) {}
    public static List<Treatment> retrieveAllTreatments() {
        return TreatmentDAO.getInstance().retrieveAll();
    }
    // public List retrieveLastTreatment() {}
    public static Treatment retrieveTreatmentByID(int id) {
        return TreatmentDAO.getInstance().retrieveByID(id);
    }
    // public List retrieveTreatmentByAnimalId(int id) {}
    // public List retrieveTreatmentByDate(String start_date, String final_date) {}
    // public void updateTreatment(Treatment treatment) {}
    // public void deleteTreatment(Treatment treatment) {}
    
    
    // public Veterinary createVeterinary(String name, String document, String phone, String email, String zip_code, int street_number, String street_complement, String crmv) {}
    public static List<Veterinary> retrieveAllVeterinarians() {
        return VeterinaryDAO.getInstance().retrieveAll();
    }
    // public List retrieveLastVeterinary() {}
    public static Veterinary retrieveVeterinaryByID(int id) {
        return VeterinaryDAO.getInstance().retrieveByID(id);
    }
    // public List retrieveVeterinaryBySimilarName(String name) {}
    // public void updateVeterinary(Veterinary veterinary) {}
    // public void deleteVeterinary(Veterinary veterinary) {} */    
}
