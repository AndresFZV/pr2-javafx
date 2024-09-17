module co.edu.uniquindio.cliente.clienteapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens co.edu.uniquindio.cliente.clienteapp to javafx.fxml;

    opens co.edu.uniquindio.cliente.clienteapp.Controller to javafx.fxml;
    exports co.edu.uniquindio.cliente.clienteapp.Controller;
    exports co.edu.uniquindio.cliente.clienteapp.App;
    exports co.edu.uniquindio.cliente.clienteapp.Model;
    opens co.edu.uniquindio.cliente.clienteapp.App to javafx.fxml;
}