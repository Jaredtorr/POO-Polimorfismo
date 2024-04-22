package jareed.demo2.controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import jareed.demo2.App;
import jareed.demo2.models.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GuardarEstudianteController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button verButton;

    @FXML
    private Button regresarButton;

    @FXML
    private TextField nameText;

    @FXML
    private TextField lastNameText;

    @FXML
    private TextField matriculaText;

    @FXML
    void onMouseClickedRegresarButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("home-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        cerrarVentana();
    }

    @FXML
    void onMouseClickedVerButton(MouseEvent event) {
        String name = nameText.getText();
        String firstName = lastNameText.getText();
        String matricula = matriculaText.getText();

        if (name.isEmpty() || firstName.isEmpty() || matricula.isEmpty()) {
            mostrarAlertaError("Por favor, rellene todos los campos");
        } else {
            mostrarAlerta("Alumno registrado exitosamente");
            Student student = new Student(name, firstName, matricula);
            App.getControl().addAlumno(student);
            App.getControl().addBaseDatos();
            App.getControl().saveAlumno(student);
        }
    }

    @FXML
    void initialize() {
    }

    public void mostrarAlertaError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Exito");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void cerrarVentana() {
        Stage stage = (Stage) regresarButton.getScene().getWindow();
        stage.close();
    }
}
