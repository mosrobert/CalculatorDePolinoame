package tuc.tp.tema1.GUI;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class View extends JFrame {
    private JButton adunaB = new JButton("+");
    private JButton scadeB = new JButton("-");
    private JButton inmultesteB = new JButton("*");
    private JButton deriveazaB = new JButton("deriv");
    private JLabel polinom1Label = new JLabel("Polinomul 1");
    private JLabel polinom2Label = new JLabel("Polinomul 2");
    private JLabel resultLabel = new JLabel("Rezultat: ");
    private JTextField polinom1Txt = new JTextField(35);
    private JTextField polinom2Txt = new JTextField(35);
    private JTextField resultTxt = new JTextField(35);

    public View() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(750, 300);
        this.setLocation(400, 180);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();

        polinom1Txt.setFont(new Font("Arial", Font.PLAIN, 18));
        polinom2Txt.setFont(new Font("Arial", Font.PLAIN, 18));
        resultTxt.setFont(new Font("Arial", Font.PLAIN, 18));

        panel1.add(polinom1Label);
        panel1.add(polinom1Txt);
        panel2.add(adunaB);
        panel2.add(scadeB);
        panel2.add(inmultesteB);
        panel2.add(deriveazaB);
        panel3.add(polinom2Label);
        panel3.add(polinom2Txt);
        panel4.add(resultLabel);
        panel4.add(resultTxt);
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);
        this.add(panel);
    }

    public String getPolinom1() {
        return polinom1Txt.getText();
    }

    public String getPolinom2() {
        return polinom2Txt.getText();
    }

    public void adunaListener(ActionListener listener) {
        adunaB.addActionListener(listener);
    }

    public void scadeListener(ActionListener listener) {
        scadeB.addActionListener(listener);
    }

    public void inmultesteListener(ActionListener listener) {
        inmultesteB.addActionListener(listener);
    }

    public void setResult(String s) {
        resultTxt.setText(s);
    }


}
