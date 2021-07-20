// 
// Decompiled by Procyon v0.5.36
// 

package Scalars;

public class Integer implements Scalar
{
    private int number;
    
    public Integer(final int num) {
        this.number = num;
    }
    
    @Override
    public Scalar add(final Scalar s) throws Exception {
        return s.addInteger(this);
    }
    
    @Override
    public Scalar mul(final Scalar s) throws Exception {
        return s.mulInteger(this);
    }
    
    @Override
    public Scalar addRational(final Rational s) throws Exception {
        return new Rational(this.number * s.getDenominator() + s.getNumerator(), s.getDenominator());
    }
    
    @Override
    public Scalar addInteger(final Integer s) {
        return new Integer(s.getNumber() + this.number);
    }
    
    @Override
    public Scalar mulRational(final Rational s) throws Exception {
        return new Rational(s.getNumerator() * this.number, s.getDenominator());
    }
    
    @Override
    public Scalar mulInteger(final Integer s) {
        return new Integer(s.getNumber() * this.number);
    }
    
    @Override
    public Scalar neg() {
        return new Integer(-this.number);
    }
    
    @Override
    public Scalar power(final int exponent) {
        return new Integer((int)Math.pow(this.number, exponent));
    }
    
    @Override
    public int sign() {
        if (this.number == 0) {
            return 0;
        }
        if (this.number < 0) {
            return -1;
        }
        return 1;
    }
    
    @Override
    public String toString() {
        return new String(String.valueOf(this.number));
    }
    
    public int getNumber() {
        return this.number;
    }
}
