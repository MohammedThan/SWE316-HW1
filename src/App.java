import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class App extends Application {
    public static void main(String[] args) throws IOException {
        // launch(args);
        // System.out.println("fffffffffffff");
    Excel excel=new Excel("Projects.xls","","");
    ArrayList myyData=excel.ReadFile("src/Projects.xls");
    // excel.mergeStages();
    // excel.ReadFile("src/mergeStages.xls");
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        // primaryStage.setTitle("Hello World!");
        // Button btn = new  Button();
        // btn.setText("Say 'Hello World'");
        // btn.setOnAction(new EventHandler<ActionEvent>() {
 
        //     @Override
        //     public void handle(ActionEvent event) {
        //         System.out.println("Hello World!");
        //     }
        // });
        
        // StackPane root = new StackPane();
        // root.getChildren().add(btn);
        // primaryStage.setScene(new Scene(root, 300, 250));
        // primaryStage.show();
        // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        // primaryStage.setTitle("Workbook GUI application");
        // primaryStage.setScene(new Scene(root, 800, 800));
        // primaryStage.show();
    }
}