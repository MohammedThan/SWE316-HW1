import java.util.Date;

public class Project {
    
    private String nodeID;

    public String getNodeID() {
        return nodeID;
    }

   

    private String costumerProjectID;
    public String getCostumerProjectID() {
        return costumerProjectID;
    }

   
    private double currentStage;
    public double getCurrentStage() {
        return currentStage;
    }

    



    private Date createdOn;
    public Date getCreatedOn() {
        return createdOn;
    }

    private Date changedOn;
    public Date getChangedOn() {
        return changedOn;
    }

    public Project(String nodeID, String costumerProjectID, double currentStage, Date createdOn, Date changedOn){
        this.nodeID = nodeID;
        this.costumerProjectID = costumerProjectID;
        this.currentStage = currentStage;
        this.createdOn = createdOn;
        this.changedOn = changedOn;
    }

    public Project() {
    }

   

    

    
}
