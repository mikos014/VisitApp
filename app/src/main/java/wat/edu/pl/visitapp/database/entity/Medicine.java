package wat.edu.pl.visitapp.database.entity;

import java.io.Serializable;

public class Medicine implements Serializable
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

    public Medicine() {
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getMethodOfDosage() {
        return methodOfDosage;
    }

    public void setMethodOfDosage(String methodOfDosage) {
        this.methodOfDosage = methodOfDosage;
    }
}
