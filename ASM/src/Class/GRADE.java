/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author dangd
 */
public class GRADE {

    private String codeStudent, fullName;
    private float English, Informationtics, GDTC, avg;

    public GRADE() {
    }

    public GRADE(String codeStudent, String fullName, float English, float Informationtics, float GDTC, float avg) {
        this.codeStudent = codeStudent;
        this.fullName = fullName;
        this.English = English;
        this.Informationtics = Informationtics;
        this.GDTC = GDTC;
        this.avg = avg;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }

    public String getCodeStudent() {
        return codeStudent;
    }

    public void setCodeStudent(String codeStudent) {
        this.codeStudent = codeStudent;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public float getEnglish() {
        return English;
    }

    public void setEnglish(float English) {
        this.English = English;
    }

    public float getInformationtics() {
        return Informationtics;
    }

    public void setInformationtics(float Informationtics) {
        this.Informationtics = Informationtics;
    }

    public float getGDTC() {
        return GDTC;
    }

    public void setGDTC(float GDTC) {
        this.GDTC = GDTC;
    }

}
