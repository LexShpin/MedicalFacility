package medicalfacility.domain.doctor;

public abstract class Doctor {
    private String ID;
    private String name;
    private String specialty;

    public Doctor(String ID, String name, String specialty) {
        this.ID = ID;
        this.name = name;
        this.specialty = specialty;
    }

    public String confirmAppointment() {
        return "Our " + this.specialty + " " + this.name + " confirmed the appointment";
    }

    private String getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

    public String getSpecialty() {
        return this.specialty;
    }

    @Override
    public String toString() {
        return this.specialty + " " + this.name;
    }
}
