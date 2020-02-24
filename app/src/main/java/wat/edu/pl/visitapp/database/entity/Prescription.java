package wat.edu.pl.visitapp.database.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Prescription implements Serializable
{
    private int prescriptionId;
    private String prescriptionNo;
    private Date issuedDate;
    private Date expirationDate;
    private String issuedCity;
    private Doctor issuedByDoctor;
    private User issuedToUser;
    private List<Medicine> medicine;
    private String extraInfo;

    public Prescription(int prescriptionId, String prescriptionNo, Date issuedDate, Date expirationDate, String issuedCity, Doctor issuedByDoctor, User issuedToUser, List<Medicine> medicine, String extraInfo) {
        this.prescriptionId = prescriptionId;
        this.prescriptionNo = prescriptionNo;
        this.issuedDate = issuedDate;
        this.expirationDate = expirationDate;
        this.issuedCity = issuedCity;
        this.issuedByDoctor = issuedByDoctor;
        this.issuedToUser = issuedToUser;
        this.medicine = medicine;
        this.extraInfo = extraInfo;
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getPrescriptionNo() {
        return prescriptionNo;
    }

    public void setPrescriptionNo(String prescriptionNo) {
        this.prescriptionNo = prescriptionNo;
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

    public User getIssuedToUser() {
        return issuedToUser;
    }

    public void setIssuedToUser(User issuedToUser) {
        this.issuedToUser = issuedToUser;
    }

    public List<Medicine> getMedicine() {
        return medicine;
    }

    public void setMedicine(List<Medicine> medicine) {
        this.medicine = medicine;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }
}
