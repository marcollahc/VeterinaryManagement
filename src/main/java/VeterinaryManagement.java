import Model.Client;
import Model.ClientDAO;

public class VeterinaryManagement {
    public static void main(String args[]) {
        ClientDAO clientDAO = new ClientDAO();

        System.out.println("Add client list");

        clientDAO.create("Teste Um", "12345678900", "+5519123456789", "test1@test.com.br", "01310909", 2134, "");
        clientDAO.create("Teste Dois", "12345678901", "+5519123456790", "test2@test.com.br", "01310910", 2135, "Andar 1");
        clientDAO.create("Teste Três", "12345678902", "+5519123456791", "test1@test.com.br", "01310911", 2136, "");

        System.out.println("List all clients");

        for (Client client:clientDAO.retrieveAll()) {
            System.out.println("id=" + client.getId() + ", name=" + client.getName());
        }

        System.out.println("List a specific client");

        for (Client client:clientDAO.retrieveByID(2)) {
            System.out.println("id=" + client.getId() + ", name=" + client.getName());
        }

        System.out.println("Update a specific client");

        clientDAO.update(2, "Teste Quatro", "12345678902", "+5519123456791", "test1@test.com.br", "01310911", 2136, "");

        for (Client client:clientDAO.retrieveAll()) {
            System.out.println("id=" + client.getId() + ", name=" + client.getName());
        }

        System.out.println("Delete a specific client");

        clientDAO.delete(2);

        for (Client client:clientDAO.retrieveAll()) {
            System.out.println("id=" + client.getId() + ", name=" + client.getName());
        }
    }
}
