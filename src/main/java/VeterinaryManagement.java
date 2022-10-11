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
import View.SystemScreen;
import java.util.List;
import javax.swing.JFrame;

public class VeterinaryManagement {
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // new SystemScreen().setVisible(true);
                JFrame frame = new JFrame("Sysvet");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new SystemScreen());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        
        /* System.out.println("Add client");

        ClientDAO.getInstance().create("Teste Um", "12345678900", "+5519123456789", "test1@test.com.br", "01310909", 2134, "");
        ClientDAO.getInstance().create("Teste Dois", "12345678901", "+5519123456790", "test2@test.com.br", "01310910", 2135, "Andar 1");
        ClientDAO.getInstance().create("Teste Três", "12345678902", "+5519123456791", "test1@test.com.br", "01310911", 2136, "");

        System.out.println("List all clients");

        List<Client> clients = ClientDAO.getInstance().retrieveAll();

        for (Client client : clients) {
            System.out.println("id=" + client.getId() + ", name=" + client.getName());
        }
        
        id=1, name=Teste Um
        id=2, name=Teste Dois
        id=3, name=Teste Três
        
        Client client_update = ClientDAO.getInstance().retrieveById(1);
        client_update.setName("Teste Alteração");
        ClientDAO.getInstance().update(client_update);
        
        Client client_delete = ClientDAO.getInstance().retrieveById(1);
        ClientDAO.getInstance().delete(client_delete);
        
        --------------------------

        System.out.println("Add animal to a client");

        AnimalDAO.getInstance().create("Tom", "2017-08-27", 0, 1, 1);
        AnimalDAO.getInstance().create("Jerry", "2020-11-03", 1, 2, 2);

        List<Animal> animals = AnimalDAO.getInstance().retrieveAll();

        for (Animal animal : animals) {
            System.out.println("id=" + animal.getId() + ", name=" + animal.getName() + ", client_id=" + animal.getClientId());
        }
        
        id=1, name=Tom, client_id=1
        id=2, name=Jerry, client_id=2
        
        --------------------------
                
        System.out.println("Add animal species");

        SpecieDAO.getInstance().create("Répteis");

        System.out.println("List all animal species");

        List<Specie> species = SpecieDAO.getInstance().retrieveAll();

        for (Specie specie : species) {
            System.out.println("id=" + specie.getId() + ", name=" + specie.getName());
        }
        
        id=1, name=Cachorro
        id=2, name=Gato
        id=7, name=Répteis
        
        --------------------------
        
        System.out.println("Add veterinary");

        VeterinaryDAO.getInstance().create("Teste Um", "12345678900", "+5519123456789", "test1@test.com.br", "01310909", 2134, "", "123456");

        System.out.println("List all veterinarians");

        List<Veterinary> veterinarians = VeterinaryDAO.getInstance().retrieveAll();

        for (Veterinary veterinary : veterinarians) {
            System.out.println("crmv=" + veterinary.getCrmv() + ", name=" + veterinary.getName());
        }

        crmv=123456, name=Teste Um
        
        --------------------------
        
        System.out.println("Add treatment");

        TreatmentDAO.getInstance().create("12/09/2022", "15/09/2022", 1);

        System.out.println("List all treatments of animal 1");

        List<Treatment> treatments = TreatmentDAO.getInstance().retrieveByAnimalId(1);

        for (Treatment treatment : treatments) {
            System.out.println("animal_id=" + treatment.getAnimalId() + ", start_date=" + treatment.getStartDate());
        }
        
        animal_id=1, start_date=12/09/2022
        
        --------------------------

        System.out.println("Add an medical appointment");

        MedicalAppointmentDAO.getInstance().create("12/09/2022", "Realizar exame de sangue, possivelmente anemia.", 1, 1);

        System.out.println("List all medical appointments");

        List<MedicalAppointment> medical_appointments = MedicalAppointmentDAO.getInstance().retrieveAll();

        for (MedicalAppointment medical_appointment:medical_appointments) {
            System.out.println("id=" + medical_appointment.getId() + ", date_appointment=" + medical_appointment.getDateAppointment() + ",history=" + medical_appointment.getHistory());
        }
        
        id=1, date_appointment=12/09/2022,history=Realizar exame de sangue, possivelmente anemia.
        
        --------------------------

        System.out.println("Add an medical exam");

        MedicalExamDAO.getInstance().create("Exame de teste", 1);

        System.out.println("List all medical exams");

        List<MedicalExam> medical_exams = MedicalExamDAO.getInstance().retrieveAll();

        for (MedicalExam medical_exam:medical_exams) {
            System.out.println("id=" + medical_exam.getId() + ", exame_description=" + medical_exam.getExamDescription());
        }

        id=1, exame_description=Exame de teste
        */
    }
}
