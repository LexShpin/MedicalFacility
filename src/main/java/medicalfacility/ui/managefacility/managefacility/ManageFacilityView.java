package medicalfacility.ui.managefacility.managefacility;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import medicalfacility.domain.doctor.Doctor;

public class ManageFacilityView {

    public Parent getView() {
        BorderPane layout = new BorderPane();

        TableView doctorsTable = new TableView<>();
        Button addDoctor = new Button("Add doctor");

        TableColumn<String, String> idColumn = new TableColumn<>("ID");
        TableColumn<String, String> nameColumn = new TableColumn<>("Name");
        TableColumn<String, String> specialtyColumn = new TableColumn<>("Specialty");

        doctorsTable.getColumns().addAll(idColumn, nameColumn, specialtyColumn);

        layout.setCenter(doctorsTable);
        layout.setBottom(addDoctor);

        return layout;
    }
}
