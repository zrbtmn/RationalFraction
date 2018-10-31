package RationalFraction;

import java.util.ArrayList;
import java.util.List;

public class FractionPolynomial {
    private int degree;
    private FractionList resultFractionList;

    //TODO add constructor with FractionList
    FractionPolynomial(FractionList array) {
        resultFractionList = array;
        this.degree = resultFractionList.getSize();
    }

    public int getDegree(){
        return degree;
    }

    // TODO override toString()
    @Override
    public String toString(){
        String txt = "";
        String add = " + ";
        boolean first = false;
        for (int i = 0; i < degree; i++) {
            if (resultFractionList.getFractionByIndex(i).getTop() != 0) {
                if (first)
                    txt = String.format("%s%s", txt, add);
                first = true;
                if (i == 0){
                    txt = String.format("%s(%s)", txt, resultFractionList.getFractionByIndex(i));
                } else
                    txt = String.format("%s(x^%d*%s)", txt, i, resultFractionList.getFractionByIndex(i));
            }
        }
        return txt;
   }

   public Fraction getPolynomFraction(int i){
        return resultFractionList.getFractionByIndex(i);
   }

   public FractionPolynomial addPolynom(FractionPolynomial addiblePolynom) {
       int maxDegree = Math.max(degree, addiblePolynom.getDegree());
       int minDegree = Math.min(degree, addiblePolynom.getDegree());
       List<Fraction> listOfFractions = new ArrayList<>();
       Fraction resultFraction;
       for (int i = 0; i < minDegree; i++) {
           Fraction first = resultFractionList.getFractionByIndex(i);
           Fraction second = addiblePolynom.getPolynomFraction(i);
           resultFraction = first.addFraction(second);
           listOfFractions.add(resultFraction);
       }

       if (maxDegree == degree) {
           for (int i = minDegree; i < maxDegree; i++) {
               listOfFractions.add(resultFractionList.getFractionByIndex(i));
           }
       }
       else {
           for (int i = minDegree; i < maxDegree; i++) {
               listOfFractions.add(addiblePolynom.getPolynomFraction(i));
           }
       }
       FractionList newPolynomArray = new FractionList(listOfFractions);
       FractionPolynomial polynom = new FractionPolynomial(newPolynomArray);
       return polynom;
   }
}