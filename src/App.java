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
    CreateProjectObj projectsCreator = new CreateProjectObj(excel);
    
    ArrayList projectsArray = excel.getProjects();
    ArrayList projectsArrayFromCreator = projectsCreator.getAllProjects(excel);

    ArrayList StagesArray = excel.getStagesMerged();

         primaryStage.setTitle("Hello World!");
         Button btn = new  Button();

         TableView projectsTable = new TableView<Project>();

         TableColumn projectIdColumn = new TableColumn<Project,String>("costumerProjectID");
         projectIdColumn.setCellValueFactory(new PropertyValueFactory<Project, String>("costumerProjectID"));

         projectsTable.getColumns().add(projectIdColumn);

         projectsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
         projectsTable.getItems().add(projectsArrayFromCreator.get(0));

         btn.setText("Say 'Hello World'");

         btn.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 Project f = ((Project)projectsArrayFromCreator.get(0));
                 ArrayList<ProjectStage> ff = f.getProjectStages();

                for(ProjectStage s : ff){
                    System.out.print(f.getNodeID());
                    System.out.println("   "+s.objectValue+"\n");
                }
                
             }
         });
        
        StackPane root = new StackPane();
        root.getChildren().addAll(projectsTable, btn);
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }
}