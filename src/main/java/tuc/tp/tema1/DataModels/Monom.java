package tuc.tp.tema1.DataModels;

import java.text.DecimalFormat;

public class Monom implements Comparable {

    private int grad;
    private double coeficient;

    //pentru fiecare monom se atribuie un grad si un coeficient
    public Monom(Integer grad, Double coeficient) {
        this.grad = grad;
        this.coeficient = coeficient;
    }
    //seteaza coeficientul
    public void setCoeficient(double coeficient) {
        this.coeficient = coeficient;
    }
    //returneaza coeficientul
    public double getCoeficient() {
        return coeficient;
    }
    //returneaza gradul
    public int getGrad() {
        return grad;
    }
    //afiseaza monoamele ca string
    public String toString() {
        String afisare = "";


        if (grad == 0) {
            if (coeficient != 0) {
                if (coeficient < 0) afisare = "" + (int) coeficient;
                else afisare = "+" + (int) coeficient;
            } else afisare = "";
        } else {
            if (coeficient == 0) afisare = "";
            else {
                if (coeficient < 0) afisare = "" + (int) coeficient + "X^" + grad;
                else afisare = "+" + (int) coeficient + "X^" + grad;
            }
        }

        return afisare;
    }

    //compara gradele si returneaza un numara pozitiv, negativ sau 0
    @Override
    public int compareTo(Object o) {
        return -(this.grad - ((Monom) o).grad);
    }
}

