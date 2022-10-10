/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Animal;
import Model.Client;
import Model.ClientDAO;
import Model.Specie;
import Model.SpecieDAO;
import java.util.List;

/**
 *
 * @author marcos-medeiros
 */
public class AnimalTableModel extends GenericTableModel {
    public AnimalTableModel(List v_data) {
        super(v_data, new String[]{"ID", "Nome", "Nascimento", "Sexo", "Espécie", "Tutor"});
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
            case 4:
                return String.class;
            case 5:
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
                return animal.getBirthdate();
            case 3:
                return (animal.getSex() == 1) ? "Macho" : "Fêmea";
            case 4:
                Specie specie = SpecieDAO.getInstance().retrieveByID(animal.getSpecieId());
                return specie.getName();
            case 5:
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
