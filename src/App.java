import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
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
    
    ArrayList<Project> projectsArrayFromCreator = projectsCreator.getAllProjects(excel);

    ArrayList StagesArray = excel.getStagesMerged();

         primaryStage.setTitle("Hello World!");
         
         TableView projectsTable = new TableView<Project>();

         TableColumn projectIdColumn = new TableColumn<Project,String>("costumerProjectID");
         TableColumn projectStageColumn = new TableColumn<Project,String>("currentStage");

         projectIdColumn.setCellValueFactory(new PropertyValueFactory<Project, String>("costumerProjectID"));
         projectStageColumn.setCellValueFactory(new PropertyValueFactory<Project, String>("currentStage"));

         projectsTable.getColumns().add(projectIdColumn);
         projectsTable.getColumns().add(projectStageColumn);

         projectsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

         for(int i=0; i<projectsArrayFromCreator.size(); i++){
            projectsTable.getItems().add(projectsArrayFromCreator.get(i));
         }

         TableViewSelectionModel selectionModel = projectsTable.getSelectionModel();
         ObservableList<Integer> selectedIndecies = selectionModel.getSelectedIndices();
         int selectedIndex = selectedIndecies.isEmpty() ? 0 : selectedIndecies.get(0);
         Pane borderPane = new Draw(projectsArrayFromCreator.get(0)).getTemplet();
         HBox root = new HBox();
         Scene scene = new Scene(root, 800, 500);

         ArrayList borderPanesList = new ArrayList<>();
         borderPanesList.add(borderPane);

         selectedIndecies.addListener(
            new ListChangeListener<Integer>() {
                @Override
                public void onChanged(
                    Change<? extends Integer> change) {
                    int selectedIndex = selectedIndecies.get(0);
                    borderPanesList.set(0, new Draw(projectsArrayFromCreator.get(selectedIndex)).getTemplet());

                    //rerender
                    HBox root = new HBox();
                    Scene scene = new Scene(root, 800, 500);
                    root.getChildren().addAll(projectsTable, ((Pane)borderPanesList.get(0)));
                    primaryStage.setScene(scene);
                }
            });
        

        root.getChildren().addAll(projectsTable, ((Pane)borderPanesList.get(0)));
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}