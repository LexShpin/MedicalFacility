package medicalfacility.domain.doctor;

public class Gastroenterologist extends Doctor {

    private String ID;
    private String name;
    private String specialty;

    public Gastroenterologist(String ID, String name, String specialty) {
        super(ID, name, specialty);
    }

}
