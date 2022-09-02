package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MedicalAppointmentDAO {
    private List<MedicalAppointment> medical_appointments = new ArrayList<MedicalAppointment>();
    private int medical_appointment_id = 1;

    public List<MedicalAppointment> create(String date_appointment, String history, int treatment_id, int veterinary_id) {
        MedicalAppointment medical_appointment = new MedicalAppointment(medical_appointment_id, date_appointment, history, treatment_id, veterinary_id);
        this.medical_appointments.add(medical_appointment);
        medical_appointment_id++;
        return this.medical_appointments;
    }

    public List<MedicalAppointment> retrieveAll() {
        return this.medical_appointments;
    }

    public List<MedicalAppointment> retrieveByID(int id) {
        return (List<MedicalAppointment>) this.medical_appointments.stream().filter(item -> item.getId() == id).collect(Collectors.toList());
    }

    public int update(int id, String date_appointment, String history, int treatment_id, int veterinary_id) {
        int index = 0;

        for (MedicalAppointment medical_appointment:this.medical_appointments) {
            if (medical_appointment.getId() == id) {
                MedicalAppointment medical_appointment_update = this.medical_appointments.get(index);
                medical_appointment_update.setDateAppointment(date_appointment);
                medical_appointment_update.setHistory(history);
                medical_appointment_update.setTreatmentId(treatment_id);
                medical_appointment_update.setVeterinaryId(veterinary_id);

                break;
            }
            index++;
        }

        return 1;
    }

    public int delete(int id) {
        int index = 0;

        for (MedicalAppointment medical_appointment:this.medical_appointments) {
            if (medical_appointment.getId() == id) {
                this.medical_appointments.remove(index);
                break;
            }
            index++;
        }

        return 1;
    }
}
