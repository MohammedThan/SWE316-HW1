import java.util.Date;


public class Stage{
    String objectValue;
    double docNum;
    Date date;
    double newValue;
    boolean isNormal;



    public Stage(    String objectValue, double docNum,Date date,double newValue,boolean isNormal){
        this.objectValue=objectValue;
        this.docNum= docNum;
        this.date=date;
        this.newValue= newValue;
        this.isNormal= isNormal;
    }

  public String getObjectValue(){
    return objectValue;
  }

  public double getDocNum(){
    return docNum;
  }

  public Date getDate(){
    return date;
  }

  public double GetNewValue(){
    return newValue;
  }

  public boolean getIsNormal(){
    return isNormal;
  }




}