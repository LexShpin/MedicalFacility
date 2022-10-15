package medicalfacility.domain.doctor;

public class Cardiologist extends Doctor{

    private String ID;
    private String name;
    private String specialty;

    public Cardiologist(String ID, String name, String specialty) {
        super(ID, name, specialty);
    }
}
