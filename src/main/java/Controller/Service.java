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

    public static void createAnimal(String name, String birthdate, int sex, int specie_id, int client_id) {
        AnimalDAO.getInstance().create(name, birthdate, sex, specie_id, client_id);
    }
    
    public static List<Animal> retrieveAllAnimals() {
        return AnimalDAO.getInstance().retrieveAll();
    }
    
    public List retrieveLastAnimal() {
        return AnimalDAO.getInstance().retrieveLast();
    }
    
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
    
    public List retrieveAnimalsBySimilarName(String name) {
        return AnimalDAO.getInstance().retrieveBySimilarName(name);
    }
    
    public void updateAnimal(Animal animal) {
        AnimalDAO.getInstance().update(animal);
    }
    
    public void deleteAnimal(Animal animal) {
        AnimalDAO.getInstance().delete(animal);
    }
    
    public static void createClient(String name, String document, String phone, String email, String zip_code, int street_number, String street_complement) {
        ClientDAO.getInstance().create(name, document, phone, email, zip_code, street_number, street_complement);
    }
    
    public static List<Client> retrieveAllClients() {
        return ClientDAO.getInstance().retrieveAll();
    }
    
    public List retrieveLastClient() {
        return AnimalDAO.getInstance().retrieveLast();
    }
    
    public static Client retrieveClientByID(int id) {
        return ClientDAO.getInstance().retrieveByID(id);
    }
    
    public List retrieveClientBySimilarName(String name) {
        return ClientDAO.getInstance().retrieveBySimilarName(name);
    }
    
    public void updateClient(Client client) {
        ClientDAO.getInstance().update(client);
    }
    
    public void deleteClient(Client client) {
        ClientDAO.getInstance().delete(client);
    }
    
    public static void createMedicalAppointment(String date_appointment, String history, int treatment_id, int veterinary_id) {
        MedicalAppointmentDAO.getInstance().create(date_appointment, history, treatment_id, veterinary_id);
    }
    
    public static List<MedicalAppointment> retrieveAllMedicalAppointments() {
        return MedicalAppointmentDAO.getInstance().retrieveAll();
    }
    
    public List retrieveLastMedicalAppointment() {
        return MedicalAppointmentDAO.getInstance().retrieveLast();
    }

    public static MedicalAppointment retrieveMedicalAppointmentByID(int id) {
        return MedicalAppointmentDAO.getInstance().retrieveByID(id);
    }

    public List retrieveMedicalAppointmentByTreatmentId(int id) {
        return MedicalAppointmentDAO.getInstance().retrieveByTreatmentId(id);
    }

    public List retrieveMedicalAppointmentByVeterinaryId(int id) {
        return MedicalAppointmentDAO.getInstance().retrieveByVeterinaryId(id);
    }

    public void updateMedicalAppointment(MedicalAppointment medical_appointment) {
        MedicalAppointmentDAO.getInstance().update(medical_appointment);
    }

    public void deleteMedicalAppointment(MedicalAppointment medical_appointment) {
        MedicalAppointmentDAO.getInstance().delete(medical_appointment);
    }
    
    public static void createMedicalExam(String exam_description, int medical_appointment_id) {
        MedicalExamDAO.getInstance().create(exam_description, medical_appointment_id);
    }
    
    public static List<MedicalExam> retrieveAllMedicalExams() {
        return MedicalExamDAO.getInstance().retrieveAll();
    }
    
    public List retrieveLastMedicalExam() {
        return MedicalExamDAO.getInstance().retrieveLast();
    }

    public static MedicalExam retrieveMedicalExamByID(int id) {
        return MedicalExamDAO.getInstance().retrieveByID(id);
    }
    
    public List retrieveMedicalExamByMedicalAppointmentId(String id) {
        return MedicalExamDAO.getInstance().retrieveByMedicalAppointmentId(id);
    }

    public void updateMedicalExam(MedicalExam medical_exam) {
        MedicalExamDAO.getInstance().update(medical_exam);
    }

    public void deleteMedicalExam(MedicalExam medical_exam) {
        MedicalExamDAO.getInstance().delete(medical_exam);
    }
    
    public static void createSpecie(String name) {
        SpecieDAO.getInstance().create(name);
    }
    
    public static List<Specie> retrieveAllSpecies() {
        return SpecieDAO.getInstance().retrieveAll();
    }
    
    public List retrieveLastSpecie() {
        return SpecieDAO.getInstance().retrieveLast();
    }

    public static Specie retrieveSpecieByID(int id) {
        return SpecieDAO.getInstance().retrieveByID(id);
    }
    
    public List retrieveSpecieBySimilarName(String name) {
        return SpecieDAO.getInstance().retrieveBySimilarName(name);
    }

    public void updateSpecie(Specie specie) {
        SpecieDAO.getInstance().update(specie);
    }

    public void deleteSpecie(Specie specie) {
        SpecieDAO.getInstance().delete(specie);
    }
    
    public static void createTreatment(String start_date, String final_date, int animal_id) {
        TreatmentDAO.getInstance().create(start_date, final_date, animal_id);
    }
    
    public static List<Treatment> retrieveAllTreatments() {
        return TreatmentDAO.getInstance().retrieveAll();
    }
    
    public List retrieveLastTreatment() {
        return TreatmentDAO.getInstance().retrieveLast();
    }

    public static Treatment retrieveTreatmentByID(int id) {
        return TreatmentDAO.getInstance().retrieveByID(id);
    }

    public List retrieveTreatmentByAnimalId(int id) {
        return TreatmentDAO.getInstance().retrieveByAnimalId(id);
    }

    public List retrieveTreatmentByDate(String start_date, String final_date) {
        return TreatmentDAO.getInstance().retrieveByDate(start_date, final_date);
    }

    public void updateTreatment(Treatment treatment) {
        TreatmentDAO.getInstance().update(treatment);
    }

    public void deleteTreatment(Treatment treatment) {
        TreatmentDAO.getInstance().delete(treatment);
    } 
    
    public static void createVeterinary(String name, String document, String phone, String email, String zip_code, int street_number, String street_complement, String crmv) {
        VeterinaryDAO.getInstance().create(name, document, phone, email, zip_code, street_number, street_complement, crmv);
    }
    
    public static List<Veterinary> retrieveAllVeterinarians() {
        return VeterinaryDAO.getInstance().retrieveAll();
    }

    public List retrieveLastVeterinary() {
        return VeterinaryDAO.getInstance().retrieveLast();
    }

    public static Veterinary retrieveVeterinaryByID(int id) {
        return VeterinaryDAO.getInstance().retrieveByID(id);
    }
    
    public List retrieveVeterinaryBySimilarName(String name) {
        return VeterinaryDAO.getInstance().retrieveBySimilarName(name);
    }
    
    public void updateVeterinary(Veterinary veterinary) {
        VeterinaryDAO.getInstance().update(veterinary);
    }

    public void deleteVeterinary(Veterinary veterinary) {
        VeterinaryDAO.getInstance().delete(veterinary);
    }
}
