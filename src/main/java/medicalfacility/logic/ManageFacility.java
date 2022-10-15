package medicalfacility.logic;

import medicalfacility.domain.appointment.Appointment;
import medicalfacility.domain.doctor.*;
import medicalfacility.domain.patient.Patient;

import java.util.ArrayList;
import java.util.UUID;

public class ManageFacility {
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;
    private ArrayList<Appointment> appointments;

    public ManageFacility() {
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }

    public void hireDoctor(String name, Doctors specialty) throws Exception {
        Doctor doctor;
        String ID = UUID.randomUUID().toString();

        try {
            if (specialty.equals(Doctors.GASTROENTEROLOGIST)) {
                doctor = new Gastroenterologist(ID, name, specialty.toString());
                this.doctors.add(doctor);
            } else if (specialty.equals(Doctors.THERAPIST)) {
                doctor = new Therapist(ID, name, specialty.toString());
                this.doctors.add(doctor);
            } else if (specialty.equals(Doctors.CARDIOLOGIST)) {
                doctor = new Cardiologist(ID, name, specialty.toString());
                this.doctors.add(doctor);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public void fireDoctor(String name, String ID) {

    }

    public ArrayList<Doctor> getDoctors() {
        return this.doctors;
    }
}
