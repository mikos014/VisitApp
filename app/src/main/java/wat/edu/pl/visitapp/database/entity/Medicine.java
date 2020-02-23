package wat.edu.pl.visitapp.database.entity;

public class Medicine
{
    private int medicineId;
    private String name;
    private String form;
    private String dosage;
    private String methodOfDosage;

    public Medicine(int medicineId, String name, String form, String dosage, String methodOfDosage) {
        this.medicineId = medicineId;
        this.name = name;
        this.form = form;
        this.dosage = dosage;
        this.methodOfDosage = methodOfDosage;
    }

}
