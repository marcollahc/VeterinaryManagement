/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.MedicalAppointment;
import Model.Veterinary;
import Model.VeterinaryDAO;
import java.util.List;

/**
 *
 * @author marcos-medeiros
 */

// int id, String date_appointment, String history, int treatment_id, int veterinary_id

public class MedicalAppointmentTableModel extends GenericTableModel {
    public MedicalAppointmentTableModel(List v_data) {
        super(v_data, new String[]{"ID", "Data da consulta", "Histórico", "Veterinário"});
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
        MedicalAppointment medical_appointment = (MedicalAppointment) v_data.get(row_index);
        
        switch (column_index) {
            case 0:
                return medical_appointment.getId();
            case 1:
                return medical_appointment.getDateAppointment();
            case 2:
                return medical_appointment.getHistory();
            case 3:
                Veterinary veterinary = VeterinaryDAO.getInstance().retrieveByID(medical_appointment.getVeterinaryId());
                return veterinary.getName();
            default:
                throw new IndexOutOfBoundsException("column_index out of bounds");
        }
    }
    
    @Override
    public boolean isCellEditable(int row_index, int column_index) {
        return false;
    }
}
