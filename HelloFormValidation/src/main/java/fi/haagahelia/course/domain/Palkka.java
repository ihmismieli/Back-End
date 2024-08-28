package fi.haagahelia.course.domain;

//tämä domain eli model

public class Palkka {
    private double palkanmaara;
    private String tyotehtava;

    public double getPalkanmaara() {
        return palkanmaara;
    }
    public void setPalkanmaara(double palkanmaara) {
        this.palkanmaara = palkanmaara;
    }
    public String getTyotehtava() {
        return tyotehtava;
    }
    public void setTyotehtava(String tyotehtava) {
        this.tyotehtava = tyotehtava;
    }

}
