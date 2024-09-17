package co.edu.uniquindio.cliente.clienteapp.App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class ClienteApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ClienteApplication.class.getResource("/co/edu/uniquindio/cliente/clienteapp/Cliente.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("App Cliente");
        stage.setScene(scene);
        Image icono = new Image(getClass().getResourceAsStream(("/img/iconoUno.png")));
        stage.getIcons().add(icono);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}