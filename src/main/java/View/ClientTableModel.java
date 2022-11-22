/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Client;
import java.util.List;

/**
 *
 * @author marcos-medeiros
 */
public class ClientTableModel extends GenericTableModel {
    public ClientTableModel(List v_data) {
        super(v_data, new String[]{"ID", "Nome", "CPF", "Telefone"});
    }
    
    @Override
    public Class<?> getColumnClass(int column_index) {
        switch (column_index) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("column_index out of bounds");
        }
    }
    
    @Override
    public Object getValueAt(int row_index, int column_index) {
        Client client = (Client) v_data.get(row_index);
        
        switch (column_index) {
            case 0:
                return client.getId();
            case 1:
                return client.getName();
            case 2:
                return client.getEmail();
            case 3:
                return client.getPhone();
            default:
                throw new IndexOutOfBoundsException("column_index out of bounds");
        }
    }
    
    /* @Override
    public void setValueAt(Object a_value, int row_index, int column_index) {
        Client client = (Client) v_data.get(row_index);
        
        switch (column_index) {
            case 0:
                client.getName();
                break;
            case 1:
                client.getEmail();
                break;
            case 2:
                client.getPhone();
                break;
            case 3:
                client.getDocument();
                break;
            case 4:
                client.getZipCode();
                break;
            case 5:
                client.getStreetNumber();
                break;
            case 6:
                client.getStreetComplement();
                break;
            default:
                throw new IndexOutOfBoundsException("column_index out of bounds");
        }
        
        ClientDAO.getInstance().update(client);
    } */
    
    @Override
    public boolean isCellEditable(int row_index, int column_index) {
        return false;
    }
}
