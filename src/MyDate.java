import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class MyDate {

    LocalDate createOn;
    LocalDate ChangedOn;
    MyDate(Date createOn, Date ChangedOn){
        this.createOn=convertToLocalDateViaMilisecond(createOn);
        this.ChangedOn=convertToLocalDateViaMilisecond(ChangedOn);
    }

    private LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
        return Instant.ofEpochMilli(dateToConvert.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public int  findMonthsDifference()
    {

        // find the period between
        // the start and end date
        Period diff
                = Period
                .between(createOn,
                        ChangedOn);

        return  diff.getMonths()+2; //+2 is for and mothns to the line
    }

}
