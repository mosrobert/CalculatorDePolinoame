package tuc.tp.tema1;

import tuc.tp.tema1.DataModels.Monom;
import tuc.tp.tema1.DataModels.Operatii;
import tuc.tp.tema1.DataModels.Polinom;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        Monom m11=new Monom(1,1.0);
        Monom m12=new Monom(0,1.0);
        //Monom m13=new Monom(0,3.0);

        Monom m21=new Monom(1,1.0);
        Monom m22=new Monom(0,1.0);
       // Monom m23=new Monom(0,-9.0);
        // System.out.println(m11.toString()
        // );
        Polinom pRezultat=new Polinom();
        Polinom p1=new Polinom();
        p1.adauga(m11);
        p1.adauga(m12);
        //p1.adauga(m13);
        Polinom p2=new Polinom();
        p2.adauga(m21);
        p2.adauga(m22);
        //p2.adauga(m23);

        Operatii o=new Operatii(p1,p2);
        pRezultat=o.aduna();
        System.out.println(pRezultat.toString());
        Polinom rezScadere=new Polinom();
        rezScadere=o.scadere();
        System.out.println(rezScadere.toString());

        Polinom rezInmultire=new Polinom();
        rezInmultire=o.inmultire();
        System.out.println(rezInmultire.toString());
    }
}
