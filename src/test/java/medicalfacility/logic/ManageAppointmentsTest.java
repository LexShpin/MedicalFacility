package medicalfacility.logic;

import medicalfacility.domain.appointment.Appointment;
import medicalfacility.domain.doctor.*;
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
        Patient patient = new Patient("1", "Andrew");
        Doctor doctor = new Gastroenterologist("1", "Alan", Doctors.CARDIOLOGIST.toString());
        Date date = Date.from(Instant.now());
        manageAppointments.setAppointment(patient, doctor, date);
        Appointment currentAppointment = manageAppointments.getAppointments().get(0);
        Doctor newDoctor = new Cardiologist("2", "John", Doctors.CARDIOLOGIST.toString());
        manageAppointments.editAppointment("1", newDoctor);
        assertTrue(currentAppointment.getDoctor().equals(newDoctor));
    }

    @Test
    public void appointmentCanceled() {
        Patient patient = new Patient("1", "Andrew");
        Doctor doctor = new Gastroenterologist("1", "Alan", Doctors.CARDIOLOGIST.toString());
        Date date = Date.from(Instant.now());
        manageAppointments.setAppointment(patient, doctor, date);
        int currentSize = manageAppointments.getAppointments().size();
        manageAppointments.cancelAppointment("1");
        assertEquals(currentSize - 1, manageAppointments.getAppointments().size());
    }
}