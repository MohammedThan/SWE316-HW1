import java.io.File;
import java.io.IOException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FolderTraverse {
    String filename;
    String thePath="empty";
    TreeViewer TVR;
    TreeView TV=new TreeView();

    public Scene getScene() throws IOException{

        HBox sp=new HBox();

        Button FirstBtn=new Button("Select folder");
        FirstBtn.setGraphic(TreeViewer.getFolderIcome());
        Button AnotherBtn=new Button("Select Another folder");
        AnotherBtn.setGraphic(TreeViewer.getFolderIcome());




        FirstBtn.setOnAction(e->{
            sp.getChildren().clear();
            DirectoryChooser dc=new DirectoryChooser();
            File path= dc.showDialog(new Stage());
            TVR=new TreeViewer(path.getAbsolutePath());
            try {
                sp.getChildren().addAll(TVR.getTreeView(),AnotherBtn);
                TV=TVR.getTreeView();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            setPath(path.getAbsolutePath());
            System.out.println(TVR.getName()+"    -    "+path.getAbsolutePath());
            // System.out.println(new OutputWindow().getfilePath(TVR.path,path.getAbsolutePath()));    


        });
        sp.getChildren().addAll(FirstBtn);


        AnotherBtn.setOnAction(e->{
            sp.getChildren().clear();
            DirectoryChooser dc=new DirectoryChooser();
            File path= dc.showDialog(new Stage());
            TVR=new TreeViewer(path.getAbsolutePath());
            try {
                sp.getChildren().addAll(TVR.getTreeView(),AnotherBtn);
                TV=TVR.getTreeView();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            setPath(path.getAbsolutePath());
              
            System.out.println(thePath+"    -    "+filename);
            // System.out.println(new OutputWindow().getfilePath(TVR.path,path.getAbsolutePath()));          

    
        });



        // MultipleSelectionModel<TreeItem<String>> TVModel = TV.getSelectionModel();

        // // Use a change listener to respond to a selection within
        // // a tree view
        // TVModel.selectedItemProperty().addListener(new ChangeListener<TreeItem<Label>>() {
        //    public void changed(ObservableValue<? extends TreeItem<String>> changed, TreeItem<String> oldVal,
        //          TreeItem<String> newVal) {
        //         System.out.println("i fell this");
        //       // Display the selection and its complete path from the root.
        //       if (newVal != null) {
  
        //          // create the entire path to the selected item.
        //          String path = newVal.getValue();
        //          TreeItem<String> tmp = newVal.getParent();
        //          while (tmp != null) {
        //             path = tmp.getValue() + " -> " + path;
        //             tmp = tmp.getParent();
        //          }
  
        //          // Display the selection and the entire path.
        //         System.out.print("Selection is " + newVal.getValue() + "\nComplete path is " + path);
        //       }
        //    }
        // });

        return new Scene(sp);
    }  
    
    
    private void setPath(String newStr){
        this.thePath=newStr;
    }

    public void  setFileName(String name){
        this.filename=name;
       
    }
}
