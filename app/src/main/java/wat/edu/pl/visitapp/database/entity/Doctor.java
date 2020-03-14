package wat.edu.pl.visitapp.database.entity;

import java.io.Serializable;

public class Doctor implements Serializable
{
    private int doctorId;
    private String name;
    private double rating;
    private String spec;

    public Doctor(int doctorId, String name, double rating, String spec) {
        this.doctorId = doctorId;
        this.name = name;
        this.rating = rating;
        this.spec = spec;
    }

    public Doctor() {
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }
}
