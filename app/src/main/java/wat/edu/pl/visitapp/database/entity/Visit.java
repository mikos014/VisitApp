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
}
