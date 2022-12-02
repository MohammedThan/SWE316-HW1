import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class OutputWindow {

    public TextArea getTextArea(){




        return  new TextArea();
    }

    private File getfiles(){

        return new File("fsd");
    }

    // public String getfilePath(String path,String absPath){
    //     System.out.println(absPath+"/"+path);
    //     File file = new File(absPath+"/"+path);
    //     File[] folders= file.listFiles();
        
    //     for(int i=0;i<folders.length;i++){
    //         // System.out.println("im  fisrst "+folders[i].getAbsolutePath());
    //         String tmpPath=folders[i].getAbsolutePath().replace("\\", "/");
    //         // System.out.println("im  second "+tmpPath);

    //         if((absPath+"/"+path)==tmpPath){
    //             // System.out.println("i workde");
    //             return folders[i].getAbsolutePath();
    //         }
    //         else if(folders[i].isDirectory()){
    //             getfilePath( path, folders[i].getAbsolutePath());
    //         }
            

    //     }

    //     return "errror";
    // }



}


