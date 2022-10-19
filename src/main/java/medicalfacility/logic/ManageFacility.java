package medicalfacility.logic;

import medicalfacility.domain.appointment.Appointment;
import medicalfacility.domain.doctor.*;
import medicalfacility.domain.patient.Patient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ManageFacility {
    private List<Doctor> doctors;
    private Integer id;

    public ManageFacility() {
        this.doctors = new ArrayList<>();
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

    public List<Doctor> getDoctors() {
        return this.doctors;
    }


}
