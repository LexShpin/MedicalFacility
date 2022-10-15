module com.example.medicalfacility {
    requires javafx.controls;
    requires javafx.fxml;


    opens medicalfacility to javafx.fxml;
    exports medicalfacility;
}