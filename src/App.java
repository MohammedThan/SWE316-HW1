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
    launch();
    Excel excel=new Excel("src/Projects.xls","src/Stages.xls","src/Stages_Detailed.xls");
    ArrayList myData=excel.getProjects();
    ArrayList myData2=excel.getStagesMerged();
    System.out.println(myData.get(1));
    System.out.println(myData2.get(1));
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException {
         primaryStage.setTitle("Hello World!");
         Button btn = new  Button();
         btn.setText("Say 'Hello World'");
         btn.setOnAction(new EventHandler<ActionEvent>() {
 
             @Override
             public void handle(ActionEvent event) {
                 System.out.println("Hello World!");
             }
         });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}