/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Veterinary;
import java.util.List;

/**
 *
 * @author marcos-medeiros
 */
public class VeterinaryTableModel extends GenericTableModel {
    public VeterinaryTableModel(List v_data) {
        super(v_data, new String[]{"ID", "Nome", "CPF", "Telefone", "Email", "CEP", "Número", "Complemento", "CRMV"});
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
            case 6:
                return Integer.class;
            case 7:
                return String.class;
            case 8:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("column_index out of bounds");
        }
    }
    
    @Override
    public Object getValueAt(int row_index, int column_index) {
        Veterinary veterinary = (Veterinary) v_data.get(row_index);
        
        switch (column_index) {
            case 0:
                return veterinary.getId();
            case 1:
                return veterinary.getName();
            case 2:
                return veterinary.getEmail();
            case 3:
                return veterinary.getPhone();
            case 4:
                return veterinary.getDocument();
            case 5:
                return veterinary.getZipCode();
            case 6:
                return veterinary.getStreetNumber();
            case 7:
                return veterinary.getStreetComplement();
            case 8:
                return veterinary.getCrmv();
            default:
                throw new IndexOutOfBoundsException("column_index out of bounds");
        }
    }
    
    @Override
    public boolean isCellEditable(int row_index, int column_index) {
        return false;
    }
}
