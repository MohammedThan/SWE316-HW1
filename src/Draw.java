import java.util.Date;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color; 
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Draw {
    Pane borderPane=new Pane();
    int  montheNum;
    Project project;
    MyDate mydate;

    public Draw(Project project){
        this.project=project;
        mydate=new MyDate(project);
        montheNum=(new MyDate(project).findMonthsDifference());
    }

    private static Line hLine(){    
        Line  line = new Line(0,400,1200,400);
        return line;
    }

    private static  Line vLine(double xStart , double yStart , double xEnd , double yEnd ){    
        Line  line = new Line(xStart,yStart,xEnd,yEnd);
        return line;  
    }

    public Pane getTemplet(){
        addAllLines();
        addLable();
        addUpperLine();
        addStages();
        return borderPane;
    }

    private void addAllLines(){
        borderPane.getChildren().add(hLine());

        for(double i=0;i<=1200;i=i+1200/montheNum/30){
                borderPane.getChildren().add(vLine(i,395,i,405)); // draw day lines 
        }
        for(int i=0;i<=montheNum;i++){
            // System.out.println(i+" "+montheNum+" "+i*1200/montheNum);
            borderPane.getChildren().add(vLine(i*1200/montheNum,390,i*1200/montheNum,410));

    }

}

 private void addLable(){
    Label label;
    Label duration=new Label("Duration: "+mydate.findStageDaysDifference()+" days");
    duration.relocate((mydate.durationToMinDate()+mydate.durationToMaxDate())/2*1200/mydate.findAllDaysDruration()-35, 280);
    borderPane.getChildren().add(duration);
    for(int i=0;i<=montheNum;i++){
        label=new Label();
        label.setText(mydate.addMonthLabel(i));
        label.relocate(i*1125/montheNum,420);

        borderPane.getChildren().add(label);       
}
// System.out.println(" im min"+ mydate.minDate(project.getProjectStages())+" im max"+ mydate.maxDate(project.getProjectStages())+" dif"+mydate.findStageDaysDifference());
// mydate.minDate(project.getProjectStages());

 }

 private void addUpperLine(){
    double startAt=(1200*mydate.durationToMinDate())/mydate.findAllDaysDruration();
    double endAt=1200*mydate.durationToMaxDate()/mydate.findAllDaysDruration();
    // System.out.println(mydate.findStageDaysDifference()+ " "+mydate.durationToMaxDate()+" "+mydate.findAllDaysDruration());
    // System.out.println(mydate.convertToLocalDateViaMilisecond(mydate.maxDate(project.getProjectStages()))+" here im ai "+mydate.getCreatedOn());
    Line line=new Line(startAt,300,endAt,300);
    Line rline=new Line(startAt,290,startAt,310);
    Line lline=new Line(endAt,290,endAt,310);

    borderPane.getChildren().addAll(line,rline,lline);
 }

 private void addStages(){

    for(int i=0;i<mydate.allStagePoint().size();i++){
        if(isDuplicateed(i)){
            Line line=new Line(mydate.allStagePoint().get(i),400,mydate.allStagePoint().get(i),380 );
            Rectangle rectangle = new Rectangle(mydate.allStagePoint().get(i), 380, 10,10);
            rectangle.setStroke(color(i)); 
            borderPane.getChildren().addAll(line,rectangle);
        } else{
            Line line=new Line(mydate.allStagePoint().get(i),400,mydate.allStagePoint().get(i),360 );
            Rectangle rectangle = new Rectangle(mydate.allStagePoint().get(i), 360, 10,10);
            rectangle.setStroke(color(i)); 
            borderPane.getChildren().addAll(line,rectangle);
        }
        

    }

    System.out.println(mydate.allStagePoint());
  
 }

 private boolean isDuplicateed(int i){

           
        
    if(mydate.allStagePoint().lastIndexOf(mydate.allStagePoint().get(i))==i)
        return true;
    return false;
 }

 private Color color(int i){
    if(project.getProjectStages().get(i).getIsNormal()){
        return Color.GREEN;
    }
    else{
        return Color.RED;
    } 
        
 }


  
}
