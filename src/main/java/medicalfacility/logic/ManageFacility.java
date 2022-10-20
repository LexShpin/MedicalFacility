package medicalfacility.logic;

import medicalfacility.domain.doctor.*;

import java.util.ArrayList;
import java.util.List;

public class ManageFacility {
    private List<Doctor> doctors;
    private Integer id;

    public ManageFacility() {
        this.doctors = new ArrayList<>();
        this.doctors.add(new Cardiologist("1", "Alex", Doctors.CARDIOLOGIST.toString()));
        this.doctors.add(new Therapist("2", "Andrew", Doctors.THERAPIST.toString()));
        this.id = 1;
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
        try {
            int index = Integer.valueOf(ID) - 1;
            this.doctors.remove(index);
        } catch (Exception e) {
            System.out.println("Something went wrong " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Doctor> getDoctors() {
        return this.doctors;
    }


}
