/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Specie;
import java.util.List;

/**
 *
 * @author marcos-medeiros
 */
public class SpecieTableModel extends GenericTableModel {
    public SpecieTableModel(List v_data) {
        super(v_data, new String[]{"ID", "Nome"});
    }
    
    @Override
    public Class<?> getColumnClass(int column_index) {
        switch (column_index) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("column_index out of bounds");
        }
    }
    
    @Override
    public Object getValueAt(int row_index, int column_index) {
        Specie specie = (Specie) v_data.get(row_index);
        
        switch (column_index) {
            case 0:
                return specie.getId();
            case 1:
                return specie.getName();
            default:
                throw new IndexOutOfBoundsException("column_index out of bounds");
        }
    }
    
    @Override
    public boolean isCellEditable(int row_index, int column_index) {
        return false;
    }
}
