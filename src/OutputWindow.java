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

    public TextArea getTextArea(String path){
        
        
        TextArea textArea = new TextArea();
        String output="";
        output=getText(path, output,true,"");
        System.out.println("output: "+output);
    
        textArea.setText(output);
        textArea.setEditable(false);




        return  textArea;
    }

    private String getText(String path,String output,Boolean firstTime ,String addspace){
        
        File file=new File(path);        
        File[] allFiles= file.listFiles();


        for(int i=0; i<allFiles.length; i++){

            if(firstTime ){
                File[] onlyFiles= file.listFiles(File::isFile);
                if(onlyFiles.length>0)
                output=output+"files without folders";
                for(int j=0; j<onlyFiles.length; j++){
                    if(!output.contains("\n\t "+addspace+"-"+onlyFiles[j].getName()+" ("+onlyFiles[j].length()/1024+" KB")){
                        output=output+"\n\t "+addspace+"-"+onlyFiles[j].getName()+" ("+onlyFiles[j].length()/1024+" KB"+")";
                    }

                }
                firstTime=false;


            }

            if(allFiles[i].isDirectory() ){
                output=output+"\n\n "+addspace+allFiles[i].getName()+" ("+getFolderSize(allFiles[i])/1024+" KB"+")";
                output=getText(allFiles[i].getAbsolutePath(),output,false,addspace+"\t");

            } else if(!output.contains("\n\t "+addspace+"-"+allFiles[i].getName()+" ("+allFiles[i].length()/1024+" KB"+")")) {


                output=output+"\n\t "+addspace+"-"+allFiles[i].getName()+" ("+allFiles[i].length()/1024+" KB"+")";

                

            }
        }

        return output;
    }



    private  long getFolderSize(File folder)
    {
        long length = 0;
       
        // listFiles() is used to list the
        // contents of the given folder
        File[] files = folder.listFiles();
 
        int count = files.length;
 
        // loop for traversing the directory
        for (int i = 0; i < count; i++) {
            if (files[i].isFile()) {
                length += files[i].length();
            }
            else {
                length += getFolderSize(files[i]);
            }
        }
        return length;
    }

    public String getfilePath(String path,String absPath,Boolean worked,String output){

      
        // System.out.println("absPath:  "+absPath);



        File file = new File(absPath);
        File[] folders= file.listFiles(File::isDirectory);
        
        for(int i=0;i<folders.length;i++){


            if(folders[i].getAbsolutePath().contains(path)&& !worked){
                worked=true;
                output=folders[i].getAbsolutePath();
                return folders[i].getAbsolutePath();
            } else if(folders[i].isDirectory() && !worked){
                output= getfilePath( path, folders[i].getAbsolutePath(),worked,output);
            }else if(worked){
                break;
            }

        }

        return output;
    }



}


