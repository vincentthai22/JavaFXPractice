package JavaFXPractice;

import JavaFXPractice.controllers.ItemListAndOverviewController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sun.plugin.javascript.navig.Anchor;

import java.io.IOException;

public class MainApp extends Application {


    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("views/sample.fxml"));
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Hello World");
        this.primaryStage.setScene(new Scene(root, 350, 325));
        this.primaryStage.show();
        initRootLayout();
        showItemListAndOverview();
    }

    public void initRootLayout(){
        try {
            //Load rootlayout from fxml file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("views/RootLayout.fxml"));

            rootLayout = (BorderPane) loader.load();

            //Show the scene containing the root layout
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {

        }
    }


    public void showItemListAndOverview(){
        try {
            //Load item list and item overview
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("views/ItemListAndOverview.fxml"));
            AnchorPane itemListAndOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(itemListAndOverview);

            ItemListAndOverviewController controller = loader.getController();
//            controller.setMainApp(this);


        } catch (IOException e){

        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
