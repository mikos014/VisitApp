package wat.edu.pl.visitapp.database.entity;

import java.io.Serializable;
import java.util.Date;

public class Refferal implements Serializable
{
    private int refferalId;
    private String refferalNo;
    private Date issuedDate;
    private Date expirationDate;
    private String issuedCity;
    private Doctor issuedByDoctor;
    private String issuedToDoctor;
    private User issuedToUser;
    private String extraInfo;

    public Refferal(int refferalId, String refferalNo, Date issuedDate, Date expirationDate, String issuedCity, Doctor issuedByDoctor, String issuedToDoctor, User issuedToUser, String extraInfo) {
        this.refferalId = refferalId;
        this.refferalNo = refferalNo;
        this.issuedDate = issuedDate;
        this.expirationDate = expirationDate;
        this.issuedCity = issuedCity;
        this.issuedByDoctor = issuedByDoctor;
        this.issuedToDoctor = issuedToDoctor;
        this.issuedToUser = issuedToUser;
        this.extraInfo = extraInfo;
    }

    public Refferal() {
    }

    public int getRefferalId() {
        return refferalId;
    }

    public void setRefferalId(int refferalId) {
        this.refferalId = refferalId;
    }

    public String getRefferalNo() {
        return refferalNo;
    }

    public void setRefferalNo(String refferalNo) {
        this.refferalNo = refferalNo;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getIssuedCity() {
        return issuedCity;
    }

    public void setIssuedCity(String issuedCity) {
        this.issuedCity = issuedCity;
    }

    public Doctor getIssuedByDoctor() {
        return issuedByDoctor;
    }

    public void setIssuedByDoctor(Doctor issuedByDoctor) {
        this.issuedByDoctor = issuedByDoctor;
    }

    public String getIssuedToDoctor() {
        return issuedToDoctor;
    }

    public void setIssuedToDoctor(String issuedToDoctor) {
        this.issuedToDoctor = issuedToDoctor;
    }

    public User getIssuedToUser() {
        return issuedToUser;
    }

    public void setIssuedToUser(User issuedToUser) {
        this.issuedToUser = issuedToUser;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }
}
