import java.io.File;
import java.io.IOException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

// public class FolderTraverse {
//     String filename;
//     String thePath="empty";
//     TreeViewer TVR;
//     TreeView TV=new TreeView();

//     public Scene getScene() throws IOException{

//         HBox sp=new HBox();

//         Button FirstBtn=new Button("Select folder");
//         FirstBtn.setGraphic(TreeViewer.getFolderIcome());
//         Button AnotherBtn=new Button("Select Another folder");
//         AnotherBtn.setGraphic(TreeViewer.getFolderIcome());




//         FirstBtn.setOnAction(e->{
//             sp.getChildren().clear();
//             DirectoryChooser dc=new DirectoryChooser();
//             File path= dc.showDialog(new Stage());
//             TVR=new TreeViewer(path.getAbsolutePath());
//             try {
//                 sp.getChildren().addAll(TVR.getTreeView(),AnotherBtn);
//                 TV=TVR.getTreeView();
//             } catch (IOException e1) {
//                 // TODO Auto-generated catch block
//                 e1.printStackTrace();
//             }
//             setPath(path.getAbsolutePath());
//             System.out.println(TVR.getName()+"    -    "+path.getAbsolutePath());
//             // System.out.println(new OutputWindow().getfilePath(TVR.path,path.getAbsolutePath()));    


//         });
//         sp.getChildren().addAll(FirstBtn);


//         AnotherBtn.setOnAction(e->{
//             sp.getChildren().clear();
//             DirectoryChooser dc=new DirectoryChooser();
//             File path= dc.showDialog(new Stage());
//             TVR=new TreeViewer(path.getAbsolutePath());
//             try {
//                 sp.getChildren().addAll(TVR.getTreeView(),AnotherBtn);
//                 TV=TVR.getTreeView();
//             } catch (IOException e1) {
//                 // TODO Auto-generated catch block
//                 e1.printStackTrace();
//             }
//             setPath(path.getAbsolutePath());
              
//             System.out.println(thePath+"    -    "+filename);
//             // System.out.println(new OutputWindow().getfilePath(TVR.path,path.getAbsolutePath()));          

    
//         });



//         // MultipleSelectionModel<TreeItem<String>> TVModel = TV.getSelectionModel();

//         // // Use a change listener to respond to a selection within
//         // // a tree view
//         // TVModel.selectedItemProperty().addListener(new ChangeListener<TreeItem<Label>>() {
//         //    public void changed(ObservableValue<? extends TreeItem<String>> changed, TreeItem<String> oldVal,
//         //          TreeItem<String> newVal) {
//         //         System.out.println("i fell this");
//         //       // Display the selection and its complete path from the root.
//         //       if (newVal != null) {
  
//         //          // create the entire path to the selected item.
//         //          String path = newVal.getValue();
//         //          TreeItem<String> tmp = newVal.getParent();
//         //          while (tmp != null) {
//         //             path = tmp.getValue() + " -> " + path;
//         //             tmp = tmp.getParent();
//         //          }
  
//         //          // Display the selection and the entire path.
//         //         System.out.print("Selection is " + newVal.getValue() + "\nComplete path is " + path);
//         //       }
//         //    }
//         // });

//         return new Scene(sp);
//     }  
    
    
//     private void setPath(String newStr){
//         this.thePath=newStr;
//     }

//     public void  setFileName(String name){
//         this.filename=name;
       
//     }
// }


public class FolderTraverse {
    String filename;
    String thePath="empty";
    String truePath;
    // TreeViewer TVR;
    TreeView TV=new TreeView();
    HBox sp;
    VBox rb;
    VBox lb;

    

    public Scene getScene(Button exit) throws IOException{

        sp=new HBox();
        sp.setSpacing(20);
        sp.setPadding(new Insets(30));
        sp.setAlignment(Pos.CENTER);

        rb=new VBox();
        rb.setSpacing(20);

        lb=new VBox();
        lb.setSpacing(20);


        Button FirstBtn=new Button("Select folder");
        FirstBtn.setGraphic(getFolderIcome());
        FirstBtn.setAlignment(Pos.CENTER);
        // FirstBtn.setAlignment();
        Button AnotherBtn=new Button("Select Another folder");
        AnotherBtn.setGraphic(getFolderIcome());





        FirstBtn.setOnAction(e->{
            sp.getChildren().clear();
            rb.getChildren().clear();
            lb.getChildren().clear();

            sp.setAlignment(Pos.TOP_LEFT);


            DirectoryChooser dc=new DirectoryChooser();
            File path= dc.showDialog(new Stage());
            // TVR=new TreeViewer(path.getAbsolutePath());
            try {
                TreeView tmpt=getTreeView(path.getAbsolutePath(),exit);
                rb.getChildren().addAll(tmpt,AnotherBtn);
                rb.setVgrow(tmpt, Priority.ALWAYS);
                TextArea temArea=new OutputWindow().getTextArea(path.getAbsolutePath());
                lb.getChildren().addAll(temArea,exit);
                lb.setVgrow(temArea, Priority.ALWAYS);
                sp.getChildren().addAll(rb,lb);
                TV=getTreeView(path.getAbsolutePath(),exit);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            setPath(path.getAbsolutePath());
            filename=thePath;
            truePath=new OutputWindow().getfilePath(filename,thePath,false,"");

            // System.out.println(filename+"    -    "+path.getAbsolutePath());
            // System.out.println(new OutputWindow().getfilePath(TVR.path,path.getAbsolutePath()));    


        });
        sp.getChildren().addAll(FirstBtn);


        AnotherBtn.setOnAction(e->{
            sp.getChildren().clear();
            rb.getChildren().clear();
            lb.getChildren().clear();
            DirectoryChooser dc=new DirectoryChooser();
            File path= dc.showDialog(new Stage());
            // TVR=new TreeViewer(path.getAbsolutePath());
            try {
                // filename= TV.getSelectionModel().getSelectedItem().toString().substring(TV.getSelectionModel().getSelectedItem().toString().indexOf("'")+1,TV.getSelectionModel().getSelectedItem().toString().length()-3);

                // truePath=new OutputWindow().getfilePath(filename,thePath,false,"");
                // System.out.println(truePath);
                TreeView tmpt=getTreeView(path.getAbsolutePath(),exit);
                rb.getChildren().addAll(tmpt,AnotherBtn);
                rb.setVgrow(tmpt, Priority.ALWAYS);
                TextArea temArea=new OutputWindow().getTextArea(path.getAbsolutePath());
                lb.getChildren().addAll(temArea,exit);
                lb.setVgrow(temArea, Priority.ALWAYS);                
                sp.getChildren().addAll(rb,lb);
                TV=getTreeView(path.getAbsolutePath(),exit);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            setPath(path.getAbsolutePath());
              
            // System.out.println(thePath+"    -    "+filename);
            // System.out.println(new OutputWindow().getfilePath(TVR.path,path.getAbsolutePath()));          
        });



        return new Scene(sp);
    }  
    
    
    private void setPath(String newStr){
        this.thePath=newStr;
    }

    public void  setFileName(String name){
        this.filename=name;
       
    }

    public TreeView getTreeView(String path,Button exit) throws IOException{
        Label rootLabel=new Label("All Folders");
        rootLabel.setGraphic(getFolderIcome());
        TreeItem<Label> root=new TreeItem<>(rootLabel);
        root.setExpanded(true);

        
        TreeView tree=new TreeView(makeTreeItem( root, new File(path)));

        tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> { 
            // System.out.println(tree.getSelectionModel().getSelectedItem().toString().substring(51,tree.getSelectionModel().getSelectedItem().toString().length()-3));
            filename= tree.getSelectionModel().getSelectedItem().toString().substring(tree.getSelectionModel().getSelectedItem().toString().indexOf("'")+1,tree.getSelectionModel().getSelectedItem().toString().length()-3);
            // System.out.println(filename);
            // System.out.println("fucj yes :"+outW.getfilePath(filename,thePath,false,""));
            truePath=new OutputWindow().getfilePath(filename,thePath,false,"");
            

            sp.getChildren().remove(sp.getChildren().size()-1);
            lb.getChildren().clear();
            TextArea temArea=new OutputWindow().getTextArea(truePath);
            lb.getChildren().addAll(temArea,exit);
            lb.setVgrow(temArea, Priority.ALWAYS);
            sp.getChildren().add(lb);

            });

            tree.setPrefWidth(400);

        return tree;
    }

    private TreeItem<Label> makeTreeItem(TreeItem<Label> root,File file) throws IOException{

        
        File[] folders=file.listFiles(File::isDirectory);

        for(int i=0;i<folders.length;i++){
            Label label=new Label(folders[i].getName());
            label.setGraphic(getFolderIcome());
            TreeItem<Label> tI=new TreeItem<>(label);
            root.getChildren().add(tI);
            makeTreeItem( tI, folders[i]);
        }
        return root;

        }

    

    public static ImageView getFolderIcome(){
        Image image = new Image(("folder.png"));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(10);
        imageView.setFitWidth(10);
        return imageView;
    }
}
