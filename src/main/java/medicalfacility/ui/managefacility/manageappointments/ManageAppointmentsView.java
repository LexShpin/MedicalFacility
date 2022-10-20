package medicalfacility.ui.managefacility.manageappointments;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class ManageAppointmentsView {

    public Parent getView() {
        GridPane layout = new GridPane();

        layout.add(new Button("hello"), 0, 1);
        layout.add(new Label("Helodw"), 0, 2);

        return layout;
    }
}
