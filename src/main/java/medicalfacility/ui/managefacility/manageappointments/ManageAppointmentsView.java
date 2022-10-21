package medicalfacility.ui.managefacility.manageappointments;

import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import medicalfacility.domain.appointment.Appointment;
import medicalfacility.logic.ManageAppointments;

public class ManageAppointmentsView {

    private ObservableList<Appointment> appointments;
    private static ManageAppointments manageAppointments = new ManageAppointments();
    private TableColumn<Appointment, String> idColumn;
    private TableView appointmentsTable;
    private AddAppointmentView addAppointmentView;

    public Parent getView() {
        addAppointmentView = new AddAppointmentView(manageAppointments);

        BorderPane layout = new BorderPane();

        this.appointmentsTable = new TableView<>();
        Button addAppointment = new Button("Add appointment");

        addAppointment.setOnAction(event -> {
            layout.setCenter(addAppointmentView.getView());
            layout.setBottom(null);
        });

        idColumn = new TableColumn<>("ID");
//        TableColumn<Appointment, String>



        return layout;
    }
}
