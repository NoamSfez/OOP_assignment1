// 
// Decompiled by Procyon v0.5.36
// 

package Scalars;

public class Rational implements Scalar
{
    private int numerator;
    private int denominator;
    
    public Rational(final int numerator, final int denominator) throws Exception {
        if (denominator == 0) {
            throw new IllegalArgumentException("It is impossible to divide by zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    @Override
    public Scalar add(final Scalar s) throws Exception {
        return s.addRational(this);
    }
    
    @Override
    public Scalar mul(final Scalar s) throws Exception {
        return s.mulRational(this);
    }
    
    @Override
    public Scalar addRational(final Rational s) throws Exception {
        final Rational ans = new Rational(this.numerator * s.getDenominator() + s.getNumerator() * this.denominator, this.denominator * s.getDenominator());
        return ans;
    }
    
    @Override
    public Scalar addInteger(final Integer s) throws Exception {
        return new Rational(this.denominator * s.getNumber() + this.numerator, this.denominator);
    }
    
    @Override
    public Scalar mulRational(final Rational s) throws Exception {
        return new Rational(this.numerator * s.getNumerator(), this.denominator * s.getDenominator());
    }
    
    @Override
    public Scalar mulInteger(final Integer s) throws Exception {
        final int nume = this.numerator * s.getNumber();
        return new Rational(nume, this.denominator);
    }
    
    @Override
    public Scalar power(final int exponent) throws Exception {
        final int nume = (int)Math.pow(this.numerator, exponent);
        final int denom = (int)Math.pow(this.denominator, exponent);
        return new Rational(nume, denom);
    }
    
    @Override
    public int sign() {
        if (this.numerator == 0) {
            return 0;
        }
        if ((this.numerator < 0 & this.denominator > 0) | (this.numerator > 0 & this.denominator < 0)) {
            return -1;
        }
        return 1;
    }
    
    @Override
    public Scalar neg() throws Exception {
        return new Rational(-this.numerator, this.denominator);
    }
    
    public Rational reduce() {
        int minNum = Math.min(this.numerator, this.denominator);
        if (minNum < 0) {
            minNum = -minNum;
        }
        for (int i = 2; i <= minNum; ++i) {
            if (this.numerator % i == 0 && this.denominator % i == 0) {
                this.numerator /= i;
                this.denominator /= i;
                --i;
            }
        }
        return this;
    }
    
    @Override
    public String toString() {
        this.reduce();
        String negNum = "";
        if (this.numerator == 0) {
            return "0";
        }
        if (this.numerator < 0 & this.denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
        if (this.denominator < 0 & this.numerator > 0) {
            this.denominator = -this.denominator;
            negNum = "-";
        }
        String num;
        if (this.denominator == 1 || this.denominator == -1) {
            num = new String(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, negNum, String.valueOf(this.numerator)));
        }
        else {
            num = new String(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, negNum, String.valueOf(this.numerator), String.valueOf(this.denominator)));
        }
        return num;
    }
    
    public int getNumerator() {
        return this.numerator;
    }
    
    public int getDenominator() {
        return this.denominator;
    }
}
