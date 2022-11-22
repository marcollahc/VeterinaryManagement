/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Animal;
import Model.Client;
import Model.ClientDAO;
import java.util.List;

/**
 *
 * @author marcos-medeiros
 */
public class AnimalTableModel extends GenericTableModel {
    public AnimalTableModel(List v_data) {
        super(v_data, new String[]{"ID", "Nome", "Tutor"});
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
            default:
                throw new IndexOutOfBoundsException("column_index out of bounds");
        }
    }
    
    @Override
    public Object getValueAt(int row_index, int column_index) {
        Animal animal = (Animal) v_data.get(row_index);
        
        switch (column_index) {
            case 0:
                return animal.getId();
            case 1:
                return animal.getName();
            case 2:
                Client client = ClientDAO.getInstance().retrieveByID(animal.getClientId());
                return client.getName();
            default:
                throw new IndexOutOfBoundsException("column_index out of bounds");
        }
    }
    
    @Override
    public boolean isCellEditable(int row_index, int column_index) {
        return false;
    }
}
