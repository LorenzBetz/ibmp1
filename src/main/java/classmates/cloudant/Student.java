package classmates.cloudant;

public class Student {
    private int matrikel_nr;
    private String vorname;
    private String nachname;
    private int semester;
    private String eMail;

    public int getMatrikel_nr() {
        return matrikel_nr;
    }

    public void setMatrikel_nr(int matrikel_nr) {
        this.matrikel_nr = matrikel_nr;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Matrikel Nummer=" + matrikel_nr +
                ", Vorname='" + vorname + '\'' +
                ", Nachname='" + nachname + '\'' +
                ", Semester=" + semester +
                ", E-Mail='" + eMail + '\'' +
                '}';
    }
}
