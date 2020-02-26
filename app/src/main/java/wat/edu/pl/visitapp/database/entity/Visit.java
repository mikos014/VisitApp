package wat.edu.pl.visitapp.database.entity;

import java.util.Date;

public class Visit
{
    private int visitId;
    private Date date;
    private String time;
    private User user;
    private Doctor doctor;
    private boolean hasOpinion;

    public Visit(int visitId, Date date, String time, User user, Doctor doctor, boolean hasOpinion) {
        this.visitId = visitId;
        this.date = date;
        this.time = time;
        this.user = user;
        this.doctor = doctor;
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

    public boolean isHasOpinion() {
        return hasOpinion;
    }

    public void setHasOpinion(boolean hasOpinion) {
        this.hasOpinion = hasOpinion;
    }
}
