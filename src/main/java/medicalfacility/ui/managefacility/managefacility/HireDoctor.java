package medicalfacility.ui.managefacility.managefacility;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import medicalfacility.domain.doctor.Doctors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HireDoctor {
    ObservableList<String> specialtiesList = FXCollections.observableArrayList(
            "Therapist",
            "Cardiologist",
            "Gastroenterologist"
    );

    public Parent getView() {
        BorderPane layout = new BorderPane();

        GridPane grid = new GridPane();

        TextField nameField = new TextField();
        ComboBox specialties = new ComboBox(specialtiesList);

        grid.add(nameField, 0, 0);
        grid.add(specialties, 0, 1);

        layout.getChildren().add(grid);

        return layout;
    }
}
