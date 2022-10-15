package medicalfacility.logic;

import medicalfacility.domain.doctor.Cardiologist;
import medicalfacility.domain.doctor.Doctor;
import medicalfacility.domain.doctor.Doctors;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ManageFacilityTest {
    ManageFacility manageFacility = new ManageFacility();

    @Test
    public void doctorIsHired() throws Exception {
        int currentSize = manageFacility.getDoctors().size();
        manageFacility.hireDoctor("Andy", Doctors.CARDIOLOGIST);
        assertEquals(currentSize + 1, manageFacility.getDoctors().size());
    }

    @Test
    public void doctorIsFired() throws Exception {
        int currentSize = manageFacility.getDoctors().size();
        manageFacility.fireDoctor("Andy", "some id");
        assertEquals(currentSize - 1, manageFacility.getDoctors().size());
    }
}