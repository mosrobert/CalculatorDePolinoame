package tuc.tp.tema1.DataModels;

import java.util.ArrayList;

public class Polinom {
    ArrayList<Monom> Pol;

    public Polinom() {
        Pol = new ArrayList<Monom>();
    }

    // adauga monoame in polinom
    public void adauga(Monom m) {

        Pol.add(m);
    }

    // returneza vectorul de monoame
    public ArrayList<Monom> getPolinom() {
        return Pol;
    }

    @Override
    public String toString() {
        String str = "";
        for (Monom m : Pol) {
            str = str + m.toString();
        }
        return str;
    }
}
