package medicalfacility;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import medicalfacility.logic.ManageFacility;
import medicalfacility.ui.managefacility.MainView;
import medicalfacility.ui.managefacility.manageappointments.ManageAppointmentsView;
import medicalfacility.ui.managefacility.managefacility.ManageFacilityView;

public class MainProgram extends Application {

    public static void main(String[] args) {
        launch(MainProgram.class);
    }

    @Override
    public void start(Stage primaryStage) {
        MainView mainView = new MainView();

        Scene scene = new Scene(mainView.getView());

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
