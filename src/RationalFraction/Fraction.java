package RationalFraction;

public class Fraction implements Comparable<Fraction> {

    private double numerator, denuminater;

    Fraction(double x, double y) {
        if (y == 0) {
            throw new IllegalArgumentException("DEnum cant be zero");
        }
        else {
            this.numerator = x;
            this.denuminater = y;
            double nod = NOD(numerator, denuminater);
            this.numerator /= nod;
            this.denuminater /= nod;
        }
    }

    public double getTop(){
        return numerator;
    }

    public double getBottom(){
        return denuminater;
    }

    public double printFraction(){
        return numerator / denuminater;
    }

    public double NOD(double numerator, double denuminater){
        numerator = Math.abs(numerator);
        denuminater = Math.abs(denuminater);
        while (numerator != 0 && denuminater != 0){
            if (numerator > denuminater) {numerator %= denuminater;}
            else {denuminater %= numerator;}
        }
        return numerator + denuminater;
    }

    public Fraction addFraction(Fraction addiable){
        double otherFractionNumerator = addiable.getTop();
        double otherFractionDenuminater = addiable.getBottom();
        numerator = (numerator * otherFractionDenuminater + otherFractionNumerator * denuminater);
        denuminater = denuminater * otherFractionDenuminater;
        return new Fraction(numerator, denuminater);
    }

    @Override
    public String toString() {
        String txt;
        if (numerator == 0){
            txt = "[0]";
        }
        else if (denuminater == 1){
            txt = String.format("[%.0f]", numerator);
        }
        else txt = String.format("[%.0f / %.0f]", numerator, denuminater);
        return txt;
    }

    //TODO
    @Override
    public int compareTo(Fraction compariable) {
        double numeratorCompaiable = compariable.getTop();
        double denuminatorCompariable = compariable.getBottom();
        double num_1 = this.denuminater * numeratorCompaiable;
        double num_2 = this.numerator * denuminatorCompariable;
        if (num_1 > num_2)
            return 1;
        else if (num_1 < num_2)
            return -1;
        else return 0;
    }//TODO

    public Fraction subFraction(Fraction subtractablle){
        double otherFractionNumerator = subtractablle.getTop();
        double otherFractionDenuminater = subtractablle.getBottom();
        denuminater = denuminater * otherFractionDenuminater;
        numerator = (numerator * otherFractionDenuminater - otherFractionNumerator * denuminater);
        return new Fraction(numerator, denuminater);
    }

    public Fraction multiFraction(Fraction multipliable){
        double otherFractionNumerator = multipliable.getTop();
        double otherFractionDenuminater = multipliable.getBottom();
        numerator *= otherFractionNumerator;
        denuminater *= otherFractionDenuminater;
        return new Fraction(numerator, denuminater);
    }

    public Fraction multiNumber(double multipliable){
        numerator *= multipliable;
        return new Fraction(numerator, denuminater);
    }

    public Fraction divFraction(Fraction multipliable){
        double otherFractionNumerator = multipliable.getTop();
        double otherFractionDenuminater = multipliable.getBottom();
        numerator *= otherFractionDenuminater;
        denuminater *= otherFractionNumerator;
        return new Fraction(numerator, denuminater);
    }
}