package medicalfacility.domain.doctor;

public class Therapist extends Doctor{

    private String ID;
    private String name;
    private String specialty;

    public Therapist(String ID, String name, String specialty) {
        super(ID, name, specialty);
    }
}
