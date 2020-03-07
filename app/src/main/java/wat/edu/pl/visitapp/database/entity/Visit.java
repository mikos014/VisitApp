package wat.edu.pl.visitapp.database.entity;

import java.io.Serializable;
import java.util.Date;

public class Visit implements Serializable {
    private int visitId;
    private Date date;
    private String time;
    private User user;
    private Doctor doctor;
    private double placeLatitude;
    private double placeLongitude;
    private String clinicName;
    private String clinicStreet;
    private String clinicCity;
    private String clinicPhoneNo;
    private boolean hasOpinion;

    public Visit(int visitId, Date date, String time, User user, Doctor doctor, double placeLatitude, double placeLongitude, String clinicName, String clinicStreet, String clinicCity, String clinicPhoneNo, boolean hasOpinion) {
        this.visitId = visitId;
        this.date = date;
        this.time = time;
        this.user = user;
        this.doctor = doctor;
        this.placeLatitude = placeLatitude;
        this.placeLongitude = placeLongitude;
        this.clinicName = clinicName;
        this.clinicStreet = clinicStreet;
        this.clinicCity = clinicCity;
        this.clinicPhoneNo = clinicPhoneNo;
        this.hasOpinion = hasOpinion;
    }

    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public double getPlaceLatitude() {
        return placeLatitude;
    }

    public void setPlaceLatitude(double placeLatitude) {
        this.placeLatitude = placeLatitude;
    }

    public double getPlaceLongitude() {
        return placeLongitude;
    }

    public void setPlaceLongitude(double placeLongitude) {
        this.placeLongitude = placeLongitude;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public String getClinicStreet() {
        return clinicStreet;
    }

    public void setClinicStreet(String clinicStreet) {
        this.clinicStreet = clinicStreet;
    }

    public String getClinicCity() {
        return clinicCity;
    }

    public void setClinicCity(String clinicCity) {
        this.clinicCity = clinicCity;
    }

    public String getClinicPhoneNo() {
        return clinicPhoneNo;
    }

    public void setClinicPhoneNo(String clinicPhoneNo) {
        this.clinicPhoneNo = clinicPhoneNo;
    }

    public boolean isHasOpinion() {
        return hasOpinion;
    }

    public void setHasOpinion(boolean hasOpinion) {
        this.hasOpinion = hasOpinion;
    }
}
