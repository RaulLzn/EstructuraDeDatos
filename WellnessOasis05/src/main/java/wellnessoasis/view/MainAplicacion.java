package wellnessoasis.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainAplicacion extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        String fxmlPath = getClass().getResource("ViewRegistroPaciente.fxml").toString();
        System.out.println("Ruta del archivo FXML: " + fxmlPath);
        Parent root = FXMLLoader.load(getClass().getResource("/view/ViewRegistroPaciente.fxml"));


        primaryStage.setTitle("Registro de Pacientes");
        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
