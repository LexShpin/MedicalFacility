package medicalfacility.ui.managefacility;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import medicalfacility.logic.ManageFacility;
import medicalfacility.ui.managefacility.manageappointments.ManageAppointmentsView;
import medicalfacility.ui.managefacility.managefacility.ManageFacilityView;

public class MainView {

    public Parent getView() {
        ManageFacility manageFacility = new ManageFacility();
        ManageFacilityView manageFacilityView = new ManageFacilityView();
        ManageAppointmentsView manageAppointmentsView = new ManageAppointmentsView();

        BorderPane layout = new BorderPane();

        GridPane gridPane = new GridPane();

        Button manageFacilityBtn = new Button("Manage Facility");
        Button manageAppointmentsBtn = new Button("Manage Appointments");

        manageFacilityBtn.setOnAction(event -> layout.setCenter(manageFacilityView.getView()));
        manageAppointmentsBtn.setOnAction(event -> layout.setCenter(manageAppointmentsView.getView()));

        gridPane.add(manageFacilityBtn, 0, 1);
        gridPane.add(manageAppointmentsBtn, 1, 1);

        gridPane.setPrefSize(600, 600);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(20, 20, 20, 20));

        BackgroundImage mainBG = new BackgroundImage(new Image("https://d3cl79h6n1fe0x.cloudfront" +
                ".net/wp-content/uploads/2018/07/20120229/large-3.jpg", 600, 600, false, true),
                BackgroundRepeat.NO_REPEAT
                , BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        gridPane.setBackground(new Background(mainBG));

        layout.setCenter(gridPane);

        return layout;
    }
}
