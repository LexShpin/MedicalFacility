package medicalfacility.logic;

import medicalfacility.domain.doctor.Cardiologist;
import medicalfacility.domain.doctor.Doctor;
import medicalfacility.domain.doctor.Doctors;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ManageFacilityTest {
    ManageFacility manageFacility = new ManageFacility();

    @Test
    public void oneDoctorIsHired() throws Exception {
        int currentSize = manageFacility.getDoctors().size();
        manageFacility.hireDoctor("Andy", Doctors.CARDIOLOGIST);
        assertEquals(currentSize + 1, manageFacility.getDoctors().size());
    }

    @Test
    public void severalDoctorsAreHired() throws Exception {
        int currentSize = manageFacility.getDoctors().size();
        manageFacility.hireDoctor("Andy", Doctors.CARDIOLOGIST);
        manageFacility.hireDoctor("Johny", Doctors.THERAPIST);
        manageFacility.hireDoctor("Pete", Doctors.GASTROENTEROLOGIST);
        assertEquals(currentSize + 3, manageFacility.getDoctors().size());
    }

    @Test
    public void doctorIsFired() throws Exception {
        manageFacility.hireDoctor("Andy", Doctors.CARDIOLOGIST);
        int currentSize = manageFacility.getDoctors().size();
        manageFacility.fireDoctor("1");
        assertEquals(currentSize - 1, manageFacility.getDoctors().size());
    }
}