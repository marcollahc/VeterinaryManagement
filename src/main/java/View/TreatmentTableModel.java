/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Animal;
import Model.AnimalDAO;
import Model.Treatment;
import java.util.List;

/**
 *
 * @author marcos-medeiros
 */
public class TreatmentTableModel extends GenericTableModel {
    public TreatmentTableModel(List v_data) {
        super(v_data, new String[]{"ID", "Data de início", "Data final", "Paciente"});
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
        Treatment treatment = (Treatment) v_data.get(row_index);
        
        switch (column_index) {
            case 0:
                return treatment.getId();
            case 1:
                return treatment.getStartDate();
            case 2:
                return treatment.getFinalDate();
            case 3:
                Animal animal = AnimalDAO.getInstance().retrieveByID(treatment.getAnimalId());
                return animal.getName();
            default:
                throw new IndexOutOfBoundsException("column_index out of bounds");
        }
    }
    
    @Override
    public boolean isCellEditable(int row_index, int column_index) {
        return false;
    }
}
