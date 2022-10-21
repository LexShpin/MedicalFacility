package medicalfacility.logic;

import medicalfacility.domain.appointment.Appointment;
import medicalfacility.domain.doctor.Doctor;
import medicalfacility.domain.doctor.Doctors;
import medicalfacility.domain.doctor.Gastroenterologist;
import medicalfacility.domain.doctor.Therapist;
import medicalfacility.domain.patient.Patient;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ManageAppointmentsTest {

    ManageAppointments manageAppointments = new ManageAppointments();

    @Test
    public void appointmentSet() {
        int currentSize = manageAppointments.getAppointments().size();
        Patient patient = new Patient("1", "Andrew");
        Doctor doctor = new Gastroenterologist("1", "Alan", Doctors.CARDIOLOGIST.toString());
        Date date = Date.from(Instant.now());
        manageAppointments.setAppointment(patient, doctor, date);
        assertEquals(currentSize + 1, manageAppointments.getAppointments().size());
    }

    @Test
    public void appointmentEdited() {

    }
}