import Model.Animal;
import Model.AnimalDAO;
import Model.Client;
import Model.ClientDAO;

import java.util.List;

public class VeterinaryManagement {
    public static void main(String args[]) {
        /* System.out.println("Add client list");

        ClientDAO.getInstance().create("Teste Um", "12345678900", "+5519123456789", "test1@test.com.br", "01310909", 2134, "");
        ClientDAO.getInstance().create("Teste Dois", "12345678901", "+5519123456790", "test2@test.com.br", "01310910", 2135, "Andar 1");
        ClientDAO.getInstance().create("Teste Três", "12345678902", "+5519123456791", "test1@test.com.br", "01310911", 2136, ""); */

        System.out.println("List all clients");

        List<Client> clients = ClientDAO.getInstance().retrieveAll();

        for (Client client:clients) {
            System.out.println("id=" + client.getId() + ", name=" + client.getName());
        }

        /* System.out.println("Add animal to a client");

        AnimalDAO.getInstance().create("Tom", "2017-08-27", 1, 2, 2);
        AnimalDAO.getInstance().create("Jerry", "2020-11-03", 1, 5, 2); */

        System.out.println("List all animals from client 2");

        List<Animal> animals = AnimalDAO.getInstance().retrieveAnimalsByID(2);

        for (Animal animal:animals) {
            System.out.println("id=" + animal.getId() + ", name=" + animal.getName() + ", client_id=" + animal.getClientId());
        }
    }
}
