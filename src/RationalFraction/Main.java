package RationalFraction;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            List<Fraction> listOfFracions_1 = new ArrayList<>();
            List<Fraction> listOfFracions_2 = new ArrayList<>();
            System.out.println("Set fractionlist_1:");
            for (int i = 0; i <= 2; i++) {
                Fraction fraction = new Fraction(i + 1, i + 2);
                listOfFracions_1.add(fraction);
                System.out.printf("%d)\t %s\t = %.1f; \n", i + 1, fraction, fraction.printFraction());
            }FractionList fractionList_1 = new FractionList(listOfFracions_1);


            System.out.print("\n");
            System.out.println("Set fractionlist_2:");
            for (int i = 0; i <= 4; i++) {
                Fraction fraction = new Fraction(i + 1, i + 2);
                listOfFracions_2.add(fraction);
                System.out.printf("%d)\t %s\t = %.1f; \n", i + 1, fraction, fraction.printFraction());
            }FractionList fractionList_2 = new FractionList(listOfFracions_2);

            double rand1 = Math.random() * 100;
            double rand2 = Math.random() * 100;

            Fraction statistic_1 = fractionList_1.maxFraction();
            Fraction statistic_2 = fractionList_1.minFraction();

            double statistic_3 = fractionList_1.countBigger(rand1, rand2);
            double statistic_4 = fractionList_1.countSmaller(rand2, rand1);

            System.out.printf("\nMax fraction in fractionlist_1:\t %s;\n", statistic_1);
            System.out.printf("Min fraction in fractionlist_1:\t %s;\n\n", statistic_2);

            System.out.printf("More than random fraction - (%.1f / %.1f) in fractionlist_1:\t %.0f;\n", rand1, rand2, statistic_3);
            System.out.printf("Less than random fraction - (%.1f / %.1f) in fractionlist_1:\t %.0f;\n\n", rand2, rand1, statistic_4);

            FractionPolynomial polynom = new FractionPolynomial(fractionList_1);
            System.out.printf("\nSet polynom_1:\n%s", polynom);

            FractionPolynomial addPolynom = new FractionPolynomial(fractionList_2);
            System.out.printf("\nSet polynom_2:\n%s", addPolynom);

            FractionPolynomial resultPolynom = polynom.addPolynom(addPolynom);
            System.out.printf("\nResult polynom:\n%s", resultPolynom);
        } catch (IllegalArgumentException ex) {
            ex.getMessage();
        }
    }
}