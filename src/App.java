import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class App extends Application {
    public static void main(String[] args) throws IOException {
    launch();

    
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Excel excel=new Excel("src/Projects.xls","src/Stages.xls","src/Stages_Detailed.xls");

    // Getting the data from the excel files and storing it in an array list.
    
    ArrayList projectsArray = excel.getProjects();
    ArrayList StagesArray = excel.getStagesMerged();

         primaryStage.setTitle("Hello World!");
         Button btn = new  Button();

         TableView projectsTable = new TableView<Object>();

         TableColumn projectIdColumn = new TableColumn<Object,String>("Project ID");
         projectIdColumn.setCellValueFactory(new PropertyValueFactory<Object, String>("ProjectID"));

         projectsTable.getColumns().add(projectIdColumn);

         projectsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
         projectsTable.getItems().add(projectsArray.get(0));

         btn.setText("Say 'Hello World'");
         btn.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 System.out.println(projectsArray.get(0));
                 System.out.println(StagesArray.get(0));
             }
         });
        
        StackPane root = new StackPane();
        root.getChildren().addAll(projectsTable, btn);
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }
}