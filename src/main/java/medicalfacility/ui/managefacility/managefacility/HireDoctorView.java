package medicalfacility.ui.managefacility.managefacility;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import medicalfacility.domain.doctor.Doctors;
import medicalfacility.logic.ManageFacility;

public class HireDoctorView {

    private static ManageFacility manageFacility;
    private ManageFacilityView manageFacilityView;
    private BorderPane layout;

    public HireDoctorView(ManageFacility manageFacility) {
        this.manageFacility = manageFacility;
    }
    ObservableList<String> specialtiesList = FXCollections.observableArrayList(
            "Therapist",
            "Cardiologist",
            "Gastroenterologist"
    );

    public Parent getView() {
        System.out.println(manageFacility.getDoctors());
        manageFacilityView = new ManageFacilityView();
        layout = new BorderPane();

        GridPane grid = new GridPane();

        BackgroundImage mainBG = new BackgroundImage(new Image("https://d3cl79h6n1fe0x.cloudfront" +
                ".net/wp-content/uploads/2018/07/20120229/large-3.jpg", 600, 600, false, true),
                BackgroundRepeat.NO_REPEAT
                , BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        layout.setBackground(new Background(mainBG));

        Label heading = new Label("Enter new employee info");
        Label nameLabel = new Label("Name");
        TextField nameField = new TextField();
        ComboBox specialties = new ComboBox(specialtiesList);
        Button hireBtn = new Button("Hire!");
        HBox buttonBox = new HBox(hireBtn);
        HBox headingBox = new HBox(heading);

        hireBtn.setOnAction(event -> {
            String name = nameField.getText();
            String specialtiesValue = specialties.getSelectionModel().getSelectedItem().toString();
            Doctors specialty;

            if (name.equals("")) {
                return;
            }

            switch (specialtiesValue) {
                case "Therapist":
                    specialty = Doctors.THERAPIST;
                    manageFacility.hireDoctor(name, specialty);
                    updateLayout();
                    break;
                case "Cardiologist":
                    specialty = Doctors.CARDIOLOGIST;
                    manageFacility.hireDoctor(name, specialty);
                    updateLayout();
                    break;
                case "Gastroenterologist":
                    specialty = Doctors.GASTROENTEROLOGIST;
                    manageFacility.hireDoctor(name, specialty);
                    updateLayout();
                    break;
                default:
                    specialty = Doctors.THERAPIST;
                    manageFacility.hireDoctor(name, specialty);
                    updateLayout();
                    break;
            }
        });

        heading.setFont(new Font("Arial Black", 24));

        specialties.getSelectionModel().selectFirst();

        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 0, 1);
        grid.add(specialties, 1, 1);
        grid.add(buttonBox, 1, 2);

        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(5);

        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        headingBox.setAlignment(Pos.CENTER);

        layout.setPadding(new Insets(20, 20, 20, 20));

        layout.setTop(headingBox);
        layout.setCenter(grid);

        return layout;
    }

    public void updateLayout() {
        layout.setTop(null);
        layout.setCenter(manageFacilityView.getView());
        layout.setPadding(new Insets(0));
        layout.setBackground(null);
    }
}
