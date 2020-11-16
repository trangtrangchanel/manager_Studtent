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
public class Mark {

    private int idStudent;
    private String idSubject;
    private int score;

    public Mark() {

    }

    public Mark(int id, String maMH, int diem) {
        this.idStudent = id;
        this.idSubject = maMH;
        this.score = diem;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public String getIdSubject() {
        return idSubject;
    }

    public int getScore() {
        return score;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public void setIdSubject(String idSubject) {
        this.idSubject = idSubject;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Mark{" + "id=" + idStudent + ", maMH=" + idSubject + ", diem=" + score + '}';
    }

}
