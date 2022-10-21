package medicalfacility.ui.managefacility.manageappointments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import medicalfacility.domain.appointment.Appointment;
import medicalfacility.domain.doctor.Doctor;
import medicalfacility.domain.patient.Patient;
import medicalfacility.logic.ManageAppointments;
import medicalfacility.logic.ManageFacility;

import java.util.Date;

public class ManageAppointmentsView {

    private ObservableList<Appointment> appointments;
    private static ManageAppointments manageAppointments = new ManageAppointments();
    private static ManageFacility manageFacility = new ManageFacility();
    private TableColumn<Appointment, String> idColumn;
    private TableView appointmentsTable;
    private AddAppointmentView addAppointmentView;

    public Parent getView() {
        addAppointmentView = new AddAppointmentView(manageAppointments, manageFacility);

        BorderPane layout = new BorderPane();

        this.appointmentsTable = new TableView<>();
        Button addAppointment = new Button("Add appointment");

        addAppointment.setOnAction(event -> {
            layout.setCenter(addAppointmentView.getView());
            layout.setBottom(null);
        });

        idColumn = new TableColumn<>("ID");
        TableColumn<Appointment, Patient> patientNameColumn = new TableColumn<>("Patient");
        TableColumn<Appointment, Doctor> doctorNameColumn = new TableColumn<>("Doctor");
        TableColumn<Appointment, Doctor> doctorSpecialtyColumn = new TableColumn<>("Specialty");
        TableColumn<Appointment, String> complaintColumn = new TableColumn<>("Complaint");
        TableColumn<Appointment, Date> dateColumn = new TableColumn<>("Date");

        appointmentsTable.getColumns().addAll(idColumn, patientNameColumn, doctorNameColumn, doctorSpecialtyColumn, complaintColumn, dateColumn);

        idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        patientNameColumn.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        doctorNameColumn.setCellValueFactory(new PropertyValueFactory<>("doctorName"));
        doctorSpecialtyColumn.setCellValueFactory(new PropertyValueFactory<>("doctorSpecialty"));
        complaintColumn.setCellValueFactory(new PropertyValueFactory<>("complaint"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        setupTable();

        addButtonsToTable();

        layout.setCenter(appointmentsTable);
        layout.setBottom(addAppointment);

        return layout;
    }

    private void addButtonsToTable() {
        TableColumn<Appointment, Void> actionColumn = new TableColumn<>("Action");

        Callback<TableColumn<Appointment, Void>, TableCell<Appointment, Void>> cellFactory = new Callback<TableColumn<Appointment,
                Void>, TableCell<Appointment, Void>>() {
            @Override
            public TableCell<Appointment, Void> call(final TableColumn<Appointment, Void> appointmentVoidTableColumn) {
                final TableCell<Appointment, Void> cell = new TableCell<Appointment, Void>() {
                    private final Button cancelBtn = new Button("Cancel");
                    {
                        cancelBtn.setOnAction(event -> {
                            Appointment selectedAppointment = (Appointment) appointmentsTable.getSelectionModel().getSelectedItem();
                            manageAppointments.cancelAppointment(selectedAppointment.getID());
                            appointmentsTable.getItems().remove(selectedAppointment);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(cancelBtn);
                        }
                    }
                };
                return cell;
            }
        };

        actionColumn.setCellFactory(cellFactory);

        appointmentsTable.getColumns().add(actionColumn);
    }

    public void setupTable() {
        this.appointments = FXCollections.observableArrayList(manageAppointments.getAppointments());
        appointmentsTable.setItems(appointments);
    }
}
