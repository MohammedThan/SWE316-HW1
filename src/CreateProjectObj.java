import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class CreateProjectObj {
    ArrayList<ArrayList> excelPro;
    ArrayList<Project> projects=new  ArrayList<Project>();
    
    CreateProjectObj(Excel excel) throws IOException{
        excelPro=excel.getProjects();
    }


    public ArrayList<Project>   getAllProjects(){
        for(int i=0;i< excelPro.size();i++){

                projects.add(new Project(
                        (String)excelPro.get(i).get(0),
                        (String)excelPro.get(i).get(1),
                        (Double)excelPro.get(i).get(2),
                        (Date) excelPro.get(i).get(3),
                        (Date) excelPro.get(i).get(4)));
        }

        return projects;
    }
    
}
