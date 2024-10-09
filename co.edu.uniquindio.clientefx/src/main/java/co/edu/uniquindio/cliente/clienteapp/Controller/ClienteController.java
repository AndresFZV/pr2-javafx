package co.edu.uniquindio.cliente.clienteapp.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import co.edu.uniquindio.cliente.clienteapp.Model.Cliente;

public class ClienteController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Cliente, String> apellidoTc;

    @FXML
    private Button btnAgregar;

    @FXML
    private RadioButton btnBasico;

    @FXML
    private RadioButton btnPremium;

    @FXML
    private RadioButton btnVip;

    @FXML
    private TableColumn<Cliente, String> cedulaTc;

    @FXML
    private TableColumn<Cliente, String> celularTc;

    @FXML
    private TableColumn<Cliente, String> correoTc;

    @FXML
    private TableColumn<Cliente, Integer> edadTc;

    @FXML
    private TableColumn<Cliente, String> idTc;

    @FXML
    private TableColumn<Cliente, String> nombreTc;

    @FXML
    private TableView<Cliente> tablaCliente;

    @FXML
    private TableColumn<Cliente, String> tipoTc;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtCelular;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtNombre;

    private final ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        idTc.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(String.valueOf(listaClientes.indexOf(cellData.getValue()) + 1)));
        nombreTc.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        apellidoTc.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        cedulaTc.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        correoTc.setCellValueFactory(new PropertyValueFactory<>("correo"));
        edadTc.setCellValueFactory(new PropertyValueFactory<>("edad"));
        celularTc.setCellValueFactory(new PropertyValueFactory<>("celular"));
        tipoTc.setCellValueFactory(new PropertyValueFactory<>("tipoCliente"));

        tablaCliente.setItems(listaClientes);
        btnAgregar.setOnAction(event -> onAgregarCliente());
        setupRadioButtonListeners();
    }

    private void setupRadioButtonListeners() {
        btnBasico.selectedProperty().addListener((obs, wasSelected, isSelected) -> cambiarBotones(btnBasico, isSelected));
        btnPremium.selectedProperty().addListener((obs, wasSelected, isSelected) -> cambiarBotones(btnPremium, isSelected));
        btnVip.selectedProperty().addListener((obs, wasSelected, isSelected) -> cambiarBotones(btnVip, isSelected));
    }

    private void cambiarBotones(RadioButton button, Boolean isSelected) {
        if (isSelected) {
            desactivarBotones(button);
        } else {
            activarBotones();
        }
    }

    private void desactivarBotones(RadioButton selectedButton) {
        btnBasico.setDisable(selectedButton != btnBasico);
        btnPremium.setDisable(selectedButton != btnPremium);
        btnVip.setDisable(selectedButton != btnVip);
    }

    private void activarBotones() {
        btnBasico.setDisable(false);
        btnPremium.setDisable(false);
        btnVip.setDisable(false);
    }

    private void onAgregarCliente() {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String cedula = txtCedula.getText();
        String correo = txtCorreo.getText();
        String edadText = txtEdad.getText();
        String celular = txtCelular.getText();
        String tipoCliente = getTipoCliente();

        if (nombre.isBlank() || apellido.isBlank() || cedula.isBlank() || correo.isBlank() ||
                edadText.isBlank() || celular.isBlank() || tipoCliente.isEmpty()) {
            showWarningAlert("¡Error!", "Por favor, complete todos los campos antes de agregar un cliente");
            return;
        }

        int edad;
        try {
            edad = Integer.parseInt(edadText);
            if (edad <= 0) {
                showWarningAlert("¡Error!", "Ingrese una edad válida mayor a 0");
                return;
            }
        } catch (NumberFormatException e) {
            showWarningAlert("¡Error!", "Ingrese un valor numérico válido para la edad");
            return;
        }

        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setCedula(cedula);
        cliente.setCorreo(correo);
        cliente.setEdad(edad);
        cliente.setCelular(celular);
        cliente.setTipoCliente(tipoCliente);
        listaClientes.add(cliente);

        txtNombre.clear();
        txtApellido.clear();
        txtCedula.clear();
        txtCorreo.clear();
        txtEdad.clear();
        txtCelular.clear();
        
        activarBotones();
    }

    private String getTipoCliente() {
        if (btnBasico.isSelected()) {
            return "Cliente Básico";
        } else if (btnPremium.isSelected()) {
            return "Cliente Premium";
        } else if (btnVip.isSelected()) {
            return "Cliente VIP";
        }
        return "";
    }

    private void showWarningAlert(String title, String message) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
                  
}
