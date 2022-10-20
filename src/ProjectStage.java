
public class ProjectStage {
    private String nodeID;
    private int currentStage;
    private int previousStage;
    private boolean isOnRework = currentStage>=previousStage ? false : true;

    public ProjectStage(String objectValue, int newValue, int oldValue){
        this.nodeID = objectValue;
        this.currentStage = newValue;
        this.previousStage = oldValue;
    }
}
