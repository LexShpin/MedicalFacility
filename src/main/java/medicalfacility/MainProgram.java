package medicalfacility;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainProgram extends Application {

    public static void main(String[] args) {
        launch(MainProgram.class);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane layout = new GridPane();

        Button manageFacilityBtn = new Button("Manage Facility");
        Button manageAppointmentsBtn = new Button("Manage Appointments");

        layout.add(manageFacilityBtn, 0, 1);
        layout.add(manageAppointmentsBtn, 1, 1);

        layout.setPrefSize(600, 600);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        BackgroundImage mainBG = new BackgroundImage(new Image("https://d3cl79h6n1fe0x.cloudfront" +
                ".net/wp-content/uploads/2018/07/20120229/large-3.jpg", 600, 600, false, true),
                BackgroundRepeat.NO_REPEAT
                , BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        layout.setBackground(new Background(mainBG));

        Scene scene = new Scene(layout);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
