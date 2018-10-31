package RationalFraction;

import java.util.Collections;
import java.util.List;

public class FractionList {
    private List<Fraction> fractionList;

    //TODO
    FractionList(List<Fraction> fractionList) {
        this.fractionList = fractionList;
    }

    public int getSize(){
        return fractionList.size();
    }

    public Fraction getFractionByIndex(int index){
        return fractionList.get(index);
    }

    public Fraction maxFraction(){
        return Collections.max(fractionList);
    }

    public Fraction minFraction(){
        return Collections.min(fractionList);
    }

    public double countBigger(double numerator, double denuminator) {
        Fraction fraction = new Fraction(numerator, denuminator);
        double count = 0;
        for (int i = 0; i < fractionList.size(); i++) {
            if (fractionList.get(i).compareTo(fraction) == 1)
                count++;
            }
        return count;
    }

    public double countSmaller(double numerator, double denuminator){
        Fraction fraction = new Fraction(numerator, denuminator);
        double count = 0;
        for(int i = 0; i < fractionList.size(); i++) {
            if (fractionList.get(i).compareTo(fraction) == -1)
                count++;
            }
        return count;
    }
}
