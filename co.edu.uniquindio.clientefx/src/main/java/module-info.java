module co.edu.uniquindio.cliente.clienteapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.cliente.clienteapp to javafx.fxml;
    exports co.edu.uniquindio.cliente.clienteapp;
}