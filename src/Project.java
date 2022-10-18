import java.util.Date;

public class Project {
    private String nodeID;
    public String getNodeID() {
        return nodeID;
    }

    public void setNodeID(String nodeID) {
        this.nodeID = nodeID;
    }

    private String costumerProjectID;
    public String getCostumerProjectID() {
        return costumerProjectID;
    }

    public void setCostumerProjectID(String costumerProjectID) {
        this.costumerProjectID = costumerProjectID;
    }

    private int currentStage;
    public int getCurrentStage() {
        return currentStage;
    }

    public void setCurrentStage(int currentStage) {
        this.currentStage = currentStage;
    }

    private Date startDate;
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    private Date endDate;
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    private Date createdOn;
    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    private Date changedOn;
    public Date getChangedOn() {
        return changedOn;
    }

    public void setChangedOn(Date changedOn) {
        this.changedOn = changedOn;
    }

    public Project(String nodeID, String costumerProjectID, int currentStage, Date startDate, Date endDate, Date createdOn, Date changedOn){
        this.nodeID = nodeID;
        this.costumerProjectID = costumerProjectID;
        this.currentStage = currentStage;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createdOn = createdOn;
        this.changedOn = changedOn;
    }

    

    
}
