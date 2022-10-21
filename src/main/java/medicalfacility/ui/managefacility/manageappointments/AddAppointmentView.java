package medicalfacility.ui.managefacility.manageappointments;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import medicalfacility.domain.doctor.Doctor;
import medicalfacility.domain.patient.Patient;
import medicalfacility.logic.ManageAppointments;
import medicalfacility.logic.ManageFacility;

public class AddAppointmentView {

    private static ManageAppointments manageAppointments;
    private static ManageFacility manageFacility;
    private ManageAppointmentsView manageAppointmentsView;
    private BorderPane layout;

    public AddAppointmentView(ManageAppointments manageAppointments, ManageFacility manageFacility) {
        this.manageAppointments = manageAppointments;
        this.manageFacility = manageFacility;
    }

    public Parent getView() {
        manageAppointmentsView = new ManageAppointmentsView();
        layout = new BorderPane();

        GridPane grid = new GridPane();

        BackgroundImage mainBG = new BackgroundImage(new Image("https://d3cl79h6n1fe0x.cloudfront" +
                ".net/wp-content/uploads/2018/07/20120229/large-3.jpg", 600, 600, false, true),
                BackgroundRepeat.NO_REPEAT
                , BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        layout.setBackground(new Background(mainBG));

        Label heading = new Label("Enter new employee info");
        // patient, complaint, doctor, date
        Label yourName = new Label("Your name");
        TextField patientName = new TextField();
        Label yourComplaint = new Label("What bothers you?");
        TextArea complaint = new TextArea();
        Label pickDoctor = new Label("Choose a doctor:");
        ComboBox doctors = new ComboBox<>(FXCollections.observableArrayList(manageFacility.getDoctors()));
        Label pickDate = new Label("Pick a date");
        DatePicker datePicker = new DatePicker();
        Button setAppointment = new Button("Schedule");

        setAppointment.setOnAction(event -> {
            Patient patient = new Patient(patientName.getText());
            Doctor doctor;
        });

        complaint.setPrefSize(200, 50);
        doctors.getSelectionModel().selectFirst();

        grid.add(yourName, 0, 0);
        grid.add(patientName, 0, 1);
        grid.add(yourComplaint, 0, 2);
        grid.add(complaint, 0, 3);
        grid.add(pickDoctor, 0, 4);
        grid.add(doctors, 0, 5);
        grid.add(pickDate, 0, 6);
        grid.add(datePicker, 0, 7);
        grid.add(setAppointment, 0, 8);

        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(5);

        layout.setTop(heading);
        layout.setCenter(grid);

        return layout;
    }
}
