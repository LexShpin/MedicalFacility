package medicalfacility.ui.managefacility.manageappointments;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import medicalfacility.domain.appointment.Appointment;
import medicalfacility.domain.doctor.Doctor;
import medicalfacility.domain.patient.Patient;
import medicalfacility.logic.ManageAppointments;
import medicalfacility.logic.ManageFacility;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

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

        BackgroundImage mainBG = new BackgroundImage(new Image("https://cdn.wallpapersafari.com/20/35/EUiOoT.jpg", 600, 600, false, true),
                BackgroundRepeat.NO_REPEAT
                , BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        layout.setBackground(new Background(mainBG));

        Label heading = new Label("Schedule an appointment");
        Button backBtn = new Button("Back");
        // patient, complaint, doctor, date
        Label yourName = new Label("Your name");
        TextField patientName = new TextField();
        Label yourComplaint = new Label("What bothers you?");
        TextArea complaintField = new TextArea();
        Label pickDoctor = new Label("Choose a doctor:");
        ComboBox doctors = new ComboBox<>(FXCollections.observableArrayList(manageFacility.getDoctors()));
        Label pickDate = new Label("Pick a date");
        DatePicker datePicker = new DatePicker();
        Button setAppointment = new Button("Schedule");
        Label errorLabel = new Label("");

        setAppointment.setOnAction(event -> {
            if (patientName.getText().equals("")) {
                errorLabel.setText("Enter your name!");
                return;
            }

            if (complaintField.getText().equals("")) {
                errorLabel.setText("Tell us what bothers you before scheduling!");
                return;
            }

            Patient patient = new Patient(patientName.getText());
            String complaint = complaintField.getText();
            Doctor doctor = (Doctor) doctors.getSelectionModel().getSelectedItem();
            LocalDate localDate = datePicker.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Date date = Date.from(instant);

            manageAppointments.setAppointment(patient, complaint, doctor, date);
            errorLabel.setText("");
            backToManageAppointments();
        });

        backBtn.setOnAction(event -> backToManageAppointments());

        complaintField.setPrefSize(200, 50);

        doctors.getSelectionModel().selectFirst();
        datePicker.setValue(LocalDate.now());

        heading.setFont(new Font("Arial Black", 24));
        errorLabel.setTextFill(Color.RED);

        HBox top = new HBox(backBtn, heading);
        top.setSpacing(80);

        grid.add(yourName, 0, 0);
        grid.add(patientName, 0, 1);
        grid.add(yourComplaint, 0, 2);
        grid.add(complaintField, 0, 3);
        grid.add(pickDoctor, 0, 4);
        grid.add(doctors, 0, 5);
        grid.add(pickDate, 0, 6);
        grid.add(datePicker, 0, 7);
        grid.add(setAppointment, 0, 8);
        grid.add(errorLabel, 0, 9);

        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(5);

        layout.setPadding(new Insets(10, 10, 10, 10));

        layout.setTop(top);
        layout.setCenter(grid);

        return layout;
    }

    public void backToManageAppointments() {
        layout.setTop(null);
        layout.setCenter(manageAppointmentsView.getView());
        layout.setPadding(new Insets(0));
        layout.setBackground(null);
    }
}
