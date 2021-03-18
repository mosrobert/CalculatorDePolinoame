package tuc.tp.tema1.DataModels;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Operatii {
    Polinom P1, P2;

    public Operatii(Polinom p1, Polinom p2) {
        this.P1 = p1;
        this.P2 = p2;
    }
    //metoda de adunare
    public Polinom aduna() {
        Polinom polinomRezultat = new Polinom();
        //array de monoame care are fiecare monom al fiecarui polinom
        ArrayList<Monom> elementeP1 = P1.getPolinom();
        ArrayList<Monom> elementeP2 = P2.getPolinom();

        //parcurge monoamele fiecarui polinom
        for (Monom m1 : elementeP1) {

            for (Monom m2 : elementeP2) {
                if (m1.getGrad() == m2.getGrad()) {


                    Monom m = new Monom(m1.getGrad(), m1.getCoeficient() + m2.getCoeficient());
                    polinomRezultat.adauga(m);
                }

            }
        }
        //daca se gaseste in primul corespondent si in al doilea nu va adauga monomul
        for (Monom m1 : elementeP1) {
            int ok = 0;
            for (Monom m2 : elementeP2) {
                if (m1.getGrad() == m2.getGrad()) {
                    ok = 1;
                }

            }
            if (ok == 0) {
                polinomRezultat.adauga(m1);
            }
        }
        for (Monom m2 : elementeP2) {
            int ok = 0;
            for (Monom m1 : elementeP1) {
                if (m2.getGrad() == m1.getGrad()) {
                    ok = 1;
                }

            }
            if (ok == 0) {
                polinomRezultat.adauga(m2);
            }
        }
        Collections.sort(polinomRezultat.getPolinom()); //sorteaza in functie de grad monoamele
        return polinomRezultat;
    }

    public Polinom scadere() {
        Polinom polinomRezultat = new Polinom();
        ArrayList<Monom> elementeP1 = P1.getPolinom();
        ArrayList<Monom> elementeP2 = P2.getPolinom();


        for (Monom m1 : elementeP1) {
            for (Monom m2 : elementeP2) {
                if (m1.getGrad() == m2.getGrad()) {
                    Monom m = new Monom(m1.getGrad(), m1.getCoeficient() - m2.getCoeficient());
                    polinomRezultat.adauga(m);
                }
            }
        }

        for (Monom m1 : elementeP1) {
            int ok = 0;
            for (Monom m2 : elementeP2) {
                if (m1.getGrad() == m2.getGrad()) {
                    ok = 1;
                }
            }
            if (ok == 0) {
                polinomRezultat.adauga(m1);
            }
        }

        for (Monom m2 : elementeP2) {
            int ok = 0;
            for (Monom m1 : elementeP1) {
                if (m2.getGrad() == m1.getGrad()) {
                    ok = 1;
                }
            }
            if (ok == 0) {
                Monom monomAux=new Monom(m2.getGrad(),-m2.getCoeficient());
                polinomRezultat.adauga(monomAux);
            }
        }

        Collections.sort(polinomRezultat.getPolinom());

        System.out.println();
        for(Monom m1: polinomRezultat.getPolinom()){
            System.out.print(m1.getCoeficient()+"x^"+m1.getGrad()+" ");
        }
        System.out.println();
        return polinomRezultat;
    }


    public Polinom inmultire() {
        Polinom polinomRezultat = new Polinom();
        ArrayList<Monom> elementeP1 = P1.getPolinom();
        ArrayList<Monom> elementeP2 = P2.getPolinom();


        for (Monom m1 : elementeP1) {
            for (Monom m2 : elementeP2) {
                Monom m = new Monom(m1.getGrad() + m2.getGrad(), m1.getCoeficient() * m2.getCoeficient());


                polinomRezultat.adauga(m);
            }

        }

        Collections.sort(polinomRezultat.getPolinom());

        Polinom p=new Polinom();
        int i;
        for(i=0;i<polinomRezultat.getPolinom().size()-1;i++){
            if(polinomRezultat.getPolinom().get(i).getGrad()!=polinomRezultat.getPolinom().get(i+1).getGrad())
            {
                p.adauga(polinomRezultat.getPolinom().get(i));
            }
            else{
                double x=polinomRezultat.getPolinom().get(i+1).getCoeficient();
                double y=polinomRezultat.getPolinom().get(i).getCoeficient();
                polinomRezultat.getPolinom().get(i+1).setCoeficient(x+y);

            }
        }
        p.adauga(polinomRezultat.getPolinom().get(i));

        return p;
    }
}


