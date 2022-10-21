package medicalfacility.logic;

import medicalfacility.domain.appointment.Appointment;
import medicalfacility.domain.doctor.Doctor;
import medicalfacility.domain.doctor.Doctors;
import medicalfacility.domain.doctor.Gastroenterologist;
import medicalfacility.domain.patient.Patient;

import java.time.Instant;
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

        Patient patient = new Patient("1", "Andrew");
        String complaint = "something is bothering";
        Doctor doctor = new Gastroenterologist("1", "Alan", Doctors.CARDIOLOGIST.toString());
        Date date = Date.from(Instant.now());
        this.setAppointment(patient, complaint, doctor, date);

        Patient patient1 = new Patient("2", "John");
        String complaint1 = "idk just hurts";
        Doctor doctor1 = new Gastroenterologist("2", "Peter", Doctors.CARDIOLOGIST.toString());
        Date date1 = Date.from(Instant.now());
        this.setAppointment(patient1, complaint1, doctor1, date1);
    }

    public void setAppointment(Patient patient, String complaint, Doctor doctor, Date date) {
        String ID = this.id.toString();
        Appointment appointment = new Appointment(ID, patient, complaint, doctor, date);
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
        if (this.id - 1 == 0) {
            this.id = 1;
        } else {
            this.id--;
        }
    }

    public List<Appointment> getAppointments() {
        return this.appointments;
    }

    public List<Patient> getPatients() {
        return this.patients;
    }
}
