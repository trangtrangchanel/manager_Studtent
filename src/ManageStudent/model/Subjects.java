/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageStudent.model;

/**
 *
 * @author saotr
 */
public class Subjects {
    
    private String idSubject;
    private String nameSubject;
    private int counterSubject;

    public Subjects() {
    }

    public Subjects(String maMH, String tenMH, int soTiet) {
        this.idSubject = maMH;
        this.nameSubject = tenMH;
        this.counterSubject = soTiet;
    }

    public String getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(String idSubject) {
        this.idSubject = idSubject;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public int getCounterSubject() {
        return counterSubject;
    }

    public void setCounterSubject(int counterSubject) {
        this.counterSubject = counterSubject;
    }
    
}
