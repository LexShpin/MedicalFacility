package medicalfacility.ui.managefacility.manageappointments;

import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import medicalfacility.logic.ManageAppointments;

public class AddAppointmentView {

    private static ManageAppointments manageAppointments;

    public AddAppointmentView(ManageAppointments manageAppointments) {
        this.manageAppointments = manageAppointments;
    }

    public Parent getView() {
        BorderPane layout = new BorderPane();

        return layout;
    }
}
