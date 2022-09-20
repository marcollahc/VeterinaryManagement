package View;

import Model.Client;
import Model.ClientDAO;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class TestRetrieve {
    private JTextField textField1;
    private JButton button1;
    private JTextArea textArea1;

    public TestRetrieve() {
        System.out.printf("Teste");
        textArea1.setText("Teste");

        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                List<Client> client_all = ClientDAO.getInstance().retrieveAll();

                for (Client client:client_all) {
                    textArea1.setText(client.getId() + ") " + client.getName() + "\n");
                }
            }
        });
    }
}
