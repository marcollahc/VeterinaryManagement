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
    private JPanel MainPanel;

    public TestRetrieve() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                List<Client> clients = ClientDAO.getInstance().retrieveAll();

                for (Client client : clients) {
                    textArea1.append(client.getName() + "\n");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("TestRetrieve");
        frame.setContentPane(new TestRetrieve().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
