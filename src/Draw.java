import java.util.Date;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Line;

public class Draw {
    BorderPane borderPane=new BorderPane();
    int  montheNum;

    public Draw(Project project){
        montheNum=(new MyDate(project.getCreatedOn(),project.getChangedOn())).findMonthsDifference();
    }

    private static Line hLine(){    
        Line  line = new Line(0,400,1150,400);
        return line;
    }

    private static  Line vLine(double xStart , double yStart , double xEnd , double yEnd ){    
        Line  line = new Line(xStart,yStart,xEnd,yEnd);
        return line;  
    }

    public BorderPane getTemplet(){
        addAllLines();
        return borderPane;
    }

    private void addAllLines(){
        borderPane.getChildren().add(hLine());

        for(double i=0;i<=1150;i=i+1150/montheNum/30){
                borderPane.getChildren().add(vLine(i,395,i,405)); // draw day lines 
        }
        for(int i=0;i<=montheNum;i++){
            System.out.println(i+" "+montheNum+" "+i*1150/montheNum);
            borderPane.getChildren().add(vLine(i*1150/montheNum,390,i*1150/montheNum,410));
    }
}

    // private void label(){
    //     Label label = new   Lable();
    //     label.setx
    // }

  
}
