package wat.edu.pl.visitapp.database.entity;

import java.util.Date;

public class Refferal
{
    private int refferalId;
    private String refferalNo;
    private Date issuedDate;
    private String issuedCity;
    private Doctor issuedByDoctor;
    private String issuedToDoctor;
    private User issuedToUser;
    private String extraInfo;

    public Refferal(int refferalId, String refferalNo, Date issuedDate, String issuedCity, Doctor issuedByDoctor, String issuedToDoctor, User issuedToUser, String extraInfo) {
        this.refferalId = refferalId;
        this.refferalNo = refferalNo;
        this.issuedDate = issuedDate;
        this.issuedCity = issuedCity;
        this.issuedByDoctor = issuedByDoctor;
        this.issuedToDoctor = issuedToDoctor;
        this.issuedToUser = issuedToUser;
        this.extraInfo = extraInfo;
    }

    public int getRefferalId() {
        return refferalId;
    }

    public String getRefferalNo() {
        return refferalNo;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public String getIssuedCity() {
        return issuedCity;
    }

    public Doctor getIssuedByDoctor() {
        return issuedByDoctor;
    }

    public String getIssuedToDoctor() {
        return issuedToDoctor;
    }

    public User getIssuedToUser() {
        return issuedToUser;
    }

    public String getExtraInfo() {
        return extraInfo;
    }
}
