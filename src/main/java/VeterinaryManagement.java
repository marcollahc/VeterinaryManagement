import View.SystemScreen;
import javax.swing.JFrame;

public class VeterinaryManagement {
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // new SystemScreen().setVisible(true);
                JFrame frame = new JFrame("Testing");
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

        System.out.println("Add animal to a client");

        AnimalDAO.getInstance().create("Tom", "2017-08-27", 1, 2, 2);
        AnimalDAO.getInstance().create("Jerry", "2020-11-03", 1, 5, 2);

        System.out.println("List all animals from client 2");

        List<Animal> animals = AnimalDAO.getInstance().retrieveAnimalsByID(2);

        for (Animal animal : animals) {
            System.out.println("id=" + animal.getId() + ", name=" + animal.getName() + ", client_id=" + animal.getClientId());
        }

        System.out.println("Add animal species");

        SpecieDAO.getInstance().create("Répteis");

        System.out.println("List all animal species");

        List<Specie> species = SpecieDAO.getInstance().retrieveAll();

        for (Specie specie : species) {
            System.out.println("id=" + specie.getId() + ", name=" + specie.getName());
        }

        System.out.println("Add veterinary");

        VeterinaryDAO.getInstance().create("Teste Um", "12345678900", "+5519123456789", "test1@test.com.br", "01310909", 2134, "", "123456");

        System.out.println("List all veterinarians");

        List<Veterinary> veterinarians = VeterinaryDAO.getInstance().retrieveAll();

        for (Veterinary veterinary : veterinarians) {
            System.out.println("crmv=" + veterinary.getCrmv() + ", name=" + veterinary.getName());
        }

        System.out.println("Add treatment");

        TreatmentDAO.getInstance().create("12/09/2022", "15/09/2022", 1);

        System.out.println("List all treatments of animal 1");

        List<Treatment> treatments = TreatmentDAO.getInstance().retrieveByAnimalId(1);

        for (Treatment treatment : treatments) {
            System.out.println("animal_id=" + treatment.getAnimalId() + ", start_date=" + treatment.getStartDate());
        }

        System.out.println("Add an medical appointment");

        MedicalAppointmentDAO.getInstance().create("12/09/2022", "Realizar exame de sangue, possivelmente anemia.", 1, 1);

        System.out.println("List all medical appointments");

        List<MedicalAppointment> medical_appointments = MedicalAppointmentDAO.getInstance().retrieveAll();

        for (MedicalAppointment medical_appointment:medical_appointments) {
            System.out.println("id=" + medical_appointment.getId() + ", date_appointment=" + medical_appointment.getDateAppointment() + ",history=" + medical_appointment.getHistory());
        }

        System.out.println("Add an medical exam");

        MedicalExamDAO.getInstance().create("Exame de teste", 1);

        System.out.println("List all medical exams");

        List<MedicalExam> medical_exams = MedicalExamDAO.getInstance().retrieveAll();

        for (MedicalExam medical_exam:medical_exams) {
            System.out.println("id=" + medical_exam.getId() + ", exame_description=" + medical_exam.getExamDescription());
        } */
    }
}
