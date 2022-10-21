package medicalfacility.logic;

import medicalfacility.domain.appointment.Appointment;
import medicalfacility.domain.doctor.Doctor;
import medicalfacility.domain.patient.Patient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ManageAppointments {
    private List<Appointment> appointments;
    private List<Patient> patients;

    private Integer id;

    public ManageAppointments() {
        this.appointments = new ArrayList<>();
        this.patients = new ArrayList<>();
        this.id = 1;
    }

    public void setAppointment(Patient patient, Doctor doctor, Date date) {
        String ID = this.id.toString();
        Appointment appointment = new Appointment(ID, patient, doctor, date);
        this.appointments.add(appointment);
        this.id++;
    }

    public void editAppointment(String ID, Doctor doctor, Date date) {
        int index = Integer.parseInt(ID) - 1;
        this.appointments.get(index).setDoctor(doctor);
        this.appointments.get(index).setDate(date);
    }

    public void editAppointment(String ID, Doctor doctor) {
        int index = Integer.parseInt(ID) - 1;
        this.appointments.get(index).setDoctor(doctor);
    }

    public void editAppointment(String ID, Date date) {
        int index = Integer.parseInt(ID) - 1;
        this.appointments.get(index).setDate(date);
    }

    public void cancelAppointment(String ID) {
        int index = Integer.parseInt(ID) - 1;
        this.appointments.remove(index);
    }

    public List<Appointment> getAppointments() {
        return this.appointments;
    }

    public List<Patient> getPatients() {
        return this.patients;
    }
}
