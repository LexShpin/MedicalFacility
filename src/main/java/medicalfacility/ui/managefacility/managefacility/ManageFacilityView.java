package medicalfacility.ui.managefacility.managefacility;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import medicalfacility.domain.doctor.Doctor;
import medicalfacility.logic.ManageFacility;

public class ManageFacilityView {

    private ObservableList<Doctor> doctors;
    private ManageFacility manageFacility;
    private HireDoctor hireDoctor;
    private TableColumn<Doctor, String> idColumn;
    private TableView doctorsTable;

    public ManageFacilityView(ManageFacility manageFacility) {
        this.manageFacility = new ManageFacility();
        this.hireDoctor = new HireDoctor();
    }

    public Parent getView() {
        BorderPane layout = new BorderPane();

        this.doctorsTable = new TableView<>();
        Button addDoctor = new Button("Hire a doctor");

        addDoctor.setOnAction(event -> {
            layout.setCenter(hireDoctor.getView());
            layout.setBottom(null);
        });

        idColumn = new TableColumn<>("ID");
        TableColumn<Doctor, String> nameColumn = new TableColumn<>("Name");
        TableColumn<Doctor, String> specialtyColumn = new TableColumn<>("Specialty");

        doctorsTable.getColumns().addAll(idColumn, nameColumn, specialtyColumn);

        this.doctors = FXCollections.observableArrayList(manageFacility.getDoctors());

        idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        specialtyColumn.setCellValueFactory(new PropertyValueFactory<>("specialty"));

        doctorsTable.setItems(this.doctors);

        addButtonsToTable();

        layout.setCenter(doctorsTable);
        layout.setBottom(addDoctor);

        return layout;
    }

    private void addButtonsToTable() {
        TableColumn<Doctor, Void> actionColumn = new TableColumn<>("Action");

        Callback<TableColumn<Doctor, Void>, TableCell<Doctor, Void>> cellFactory = new Callback<TableColumn<Doctor,
                Void>, TableCell<Doctor, Void>>() {
            @Override
            public TableCell<Doctor, Void> call(final TableColumn<Doctor, Void> doctorVoidTableColumn) {
                final TableCell<Doctor, Void> cell = new TableCell<Doctor, Void>() {
                    private final Button fireBtn = new Button("Fire");
                    {
                        fireBtn.setOnAction(event -> {
                            Doctor selectedDoctor = (Doctor) doctorsTable.getSelectionModel().getSelectedItem();
                            manageFacility.fireDoctor(selectedDoctor.getID());
                            doctorsTable.getItems().remove(selectedDoctor);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(fireBtn);
                        }
                    }
                };
                return cell;
            }
        };

        actionColumn.setCellFactory(cellFactory);

        doctorsTable.getColumns().add(actionColumn);
    }
}
