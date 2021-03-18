package tuc.tp.tema1.GUI;

import tuc.tp.tema1.DataModels.Operatii;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control {
    private View view;
    private Model model;

    public Control(View view, Model model) {
        this.view = view;
        this.model = model;
        this.view.inmultesteListener(new Inmulteste());
        this.view.adunaListener(new Aduna());
        this.view.scadeListener(new Scade());
    }

    class Aduna implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String polinom1 = view.getPolinom1();
            String polinom2 = view.getPolinom2();
            model.determinaPolinom(polinom1, 1);
            model.determinaPolinom(polinom2, 2);
            Operatii o = new Operatii(model.getPolinom1(), model.getPolinom2());
            view.setResult(o.aduna().toString());
            model.reset();
        }
    }

    class Inmulteste implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String polinom1 = view.getPolinom1();
            String polinom2 = view.getPolinom2();
            model.determinaPolinom(polinom1, 1);
            model.determinaPolinom(polinom2, 2);
            Operatii o = new Operatii(model.getPolinom1(), model.getPolinom2());
            view.setResult(o.inmultire().toString());
            model.reset();
        }
    }

    class Scade implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String p1 = view.getPolinom1();
            String p2 = view.getPolinom2();
            model.determinaPolinom(p1, 1);
            model.determinaPolinom(p2, 2);
            Operatii o = new Operatii(model.getPolinom1(), model.getPolinom2());

            view.setResult(o.scadere().toString());
            model.reset();
        }
    }
}
