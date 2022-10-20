module com.example.medicalfacility {
    requires javafx.controls;
    requires javafx.fxml;


    opens medicalfacility to javafx.fxml;
    opens medicalfacility.domain.doctor to javafx.fxml;
    opens medicalfacility.domain.patient to javafx.fxml;
    opens medicalfacility.domain.appointment to javafx.fxml;
    opens medicalfacility.logic to javafx.fxml;
    opens medicalfacility.ui.managefacility.managefacility to javafx.fxml;
    opens medicalfacility.ui.managefacility.manageappointments to javafx.fxml;

    exports medicalfacility;
    exports medicalfacility.domain.doctor;
    exports medicalfacility.domain.patient;
    exports medicalfacility.domain.appointment;
    exports medicalfacility.logic;
    exports medicalfacility.ui.managefacility.managefacility;
    exports medicalfacility.ui.managefacility.manageappointments;
}