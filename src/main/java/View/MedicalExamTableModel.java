/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.MedicalExam;
import java.util.List;

/**
 *
 * @author marcos-medeiros
 */
public class MedicalExamTableModel extends GenericTableModel {
    public MedicalExamTableModel(List v_data) {
        super(v_data, new String[]{"ID", "Descrição"});
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
        MedicalExam medical_exam = (MedicalExam) v_data.get(row_index);
        
        switch (column_index) {
            case 0:
                return medical_exam.getId();
            case 1:
                return medical_exam.getExamDescription();
            default:
                throw new IndexOutOfBoundsException("column_index out of bounds");
        }
    }
    
    @Override
    public boolean isCellEditable(int row_index, int column_index) {
        return false;
    }
}
