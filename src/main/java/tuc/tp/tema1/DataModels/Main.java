package tuc.tp.tema1.DataModels;


import tuc.tp.tema1.GUI.Control;
import tuc.tp.tema1.GUI.Model;
import tuc.tp.tema1.GUI.View;

public class Main {

    public static void main(String[] args) {
        Model model=new Model();
        View view = new View();
        Control control=new Control(view,model);
        view.setVisible(true);
    }
}
