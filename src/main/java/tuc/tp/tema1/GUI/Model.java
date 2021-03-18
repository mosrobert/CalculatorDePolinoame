package tuc.tp.tema1.GUI;

import tuc.tp.tema1.DataModels.Monom;
import tuc.tp.tema1.DataModels.Polinom;

import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Model {
    private Polinom polinom1;
    private Polinom polinom2;

    public Model() {
        polinom1 = new Polinom();
        polinom2 = new Polinom();
    }

    //daca am polinom de exemplu: x^4+x^3+x^2 il transform in 1x^4+1x^3+1x^2
    private String updatePolinom(String s) {
        StringBuilder sb = new StringBuilder();
        char[] pol = s.toCharArray();
        int indx = 0;
        char last_char = ' ';
        for (char c : pol) {
            if (indx == 0 && c == 'x') {
                sb.append('1');
            } else if ((last_char == '+' || last_char == '-') && c == 'x') {
                sb.append('1');
            }
            indx++;
            last_char = c;
            sb.append(c);
        }
        return sb.toString();
    }

    public void determinaPolinom(String s, int i)  {
        String expr = updatePolinom(s);
        // int    int*x     x   int*x^int   int*x
        Pattern pattern = Pattern.compile("([+-]?(?:(?:\\d+x\\^\\d+)|(?:\\d+x)|(?:\\d+)|(?:x)))");
        Matcher matcher = pattern.matcher(expr);
        int x = 0;
        while (matcher.find()) {
            String[] monom = matcher.group(1).split("x");//extrage cate un monom din stringul s

            double coef = 1d;
            int exp = 0;

            if (monom[0] != null && monom[0].length() > 0) {
                coef = Double.parseDouble(monom[0]);
            }

            if (monom.length > 1) {
                if (monom[1] != null && monom[1].length() > 0) {
                    String t = monom[1].substring(1);
                    exp = Integer.parseInt(t);
                }
            }else if(matcher.group(1).contains("x"))exp=1;

            Monom m=new Monom(exp,coef);
            if(i==1) polinom1.adauga(m);
            else polinom2.adauga(m);
        }
        if(i==1) Collections.sort(polinom1.getPolinom());
        else Collections.sort(polinom2.getPolinom());
    }

    public Polinom getPolinom1() {
        return polinom1;
    }

    public Polinom getPolinom2() {
        return polinom2;
    }

    public void reset(){
        polinom1 =new Polinom();
        polinom2 =new Polinom();
    }
}
