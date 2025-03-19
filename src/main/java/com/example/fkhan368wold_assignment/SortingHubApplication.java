package com.example.fkhan368wold_assignment;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.IOException;

public class SortingHubApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sorting-hub-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //stage.getIcons().add(new Image(getClass().getResourceAsStream("com/example/fkhan368wold_assignment/WesternLogo.png")));
        stage.setTitle("Sorting Hub");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
