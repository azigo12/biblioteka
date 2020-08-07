package ba.unsa.etf.rpr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        BibliotekaModel model = new BibliotekaModel();
        Controller ctrl = new Controller();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("biblioteka.fxml"));
        loader.setController(ctrl);
        Parent root = loader.load();

        primaryStage.setTitle("Biblioteka");
        Scene scene = new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
