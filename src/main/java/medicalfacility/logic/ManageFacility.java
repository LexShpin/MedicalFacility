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
    private Integer id;

    public ManageFacility() {
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
        this.appointments = new ArrayList<>();
        this.id = 0;
    }

    public void hireDoctor(String name, Doctors specialty) throws Exception {
        Doctor doctor;
        String ID = this.id.toString();

        try {
            if (specialty.equals(Doctors.GASTROENTEROLOGIST)) {
                doctor = new Gastroenterologist(ID, name, specialty.toString());
                this.doctors.add(doctor);
                this.id++;
            } else if (specialty.equals(Doctors.THERAPIST)) {
                doctor = new Therapist(ID, name, specialty.toString());
                this.doctors.add(doctor);
                this.id++;
            } else if (specialty.equals(Doctors.CARDIOLOGIST)) {
                doctor = new Cardiologist(ID, name, specialty.toString());
                this.doctors.add(doctor);
                this.id++;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public void fireDoctor(String ID) {
        int index = Integer.parseInt(ID) - 1;
        this.doctors.remove(index);
    }

    public Doctor getDoctor(Doctor doctor) {
        return new Cardiologist(this.id.toString(), "Andy", Doctors.CARDIOLOGIST.toString());
    }

    public ArrayList<Doctor> getDoctors() {
        return this.doctors;
        // then call it in ui and map there
    }
}
