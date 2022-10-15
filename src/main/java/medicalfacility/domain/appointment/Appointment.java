package medicalfacility.domain.appointment;

import medicalfacility.domain.doctor.Doctor;
import medicalfacility.domain.patient.Patient;

import java.util.Date;

public class Appointment {
    private String ID;
    private Patient patient;
    private Doctor doctor;
    private Date date;

    public Appointment(String ID, Patient patient, Doctor doctor, Date date) {
        this.ID = ID;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "The appointment of " + this.getPatient() + " with the " + this.doctor.getSpecialty() + " " + this.doctor.getName() + " is scheduled for " + this.getDate().toString();
    }
}
