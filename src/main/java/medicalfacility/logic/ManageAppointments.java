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

    public ManageAppointments() {
        this.appointments = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    private void setAppointment(Patient patient, Doctor doctor, Date date) {
        String ID = UUID.randomUUID().toString();
        Appointment appointment = new Appointment(ID, patient, doctor, date);
        this.appointments.add(appointment);
    }

    private void editAppointment(String ID, Doctor doctor, Date date) {
        int index = Integer.parseInt(ID) - 1;
        this.appointments.get(index).setDoctor(doctor);
        this.appointments.get(index).setDate(date);
    }

    private void editAppointment(String ID, Doctor doctor) {
        int index = Integer.parseInt(ID) - 1;
        this.appointments.get(index).setDoctor(doctor);
    }

    private void editAppointment(String ID, Date date) {
        int index = Integer.parseInt(ID) - 1;
        this.appointments.get(index).setDate(date);
    }

    private void cancelAppointment(String ID) {
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
