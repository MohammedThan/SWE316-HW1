import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class CreateStagesObj {

    ArrayList<ArrayList> excelStg;
    ArrayList<Stage> stages=new  ArrayList<Stage>();

    public CreateStagesObj( Excel excel) throws IOException{
        excelStg=excel.getStagesMerged();
    }

    public ArrayList<Stage> getAllStages(String objValue){
        for(int i=0; i<excelStg.size(); i++){

            if( excelStg.get(i).get(0).equals(objValue)){
                stages.add(new Stage(
                    (String)excelStg.get(i).get(0),
                    (double)excelStg.get(i).get(1),
                    (Date) excelStg.get(i).get(2),
                    (double) excelStg.get(i).get(3),
                    (boolean) excelStg.get(i).get(4)));
            }
    }
    return stages;
}

}