// 
// Decompiled by Procyon v0.5.36
// 

package MathForms;

import Scalars.Integer;
import Scalars.Scalar;

public class Monomial
{
    private int exponent;
    private Scalar coefficient;
    
    public Monomial(final int exponent, final Scalar coefficient) {
        this.exponent = exponent;
        this.coefficient = coefficient;
    }
    
    public Monomial add(final Monomial m) throws Exception {
        if (m.exponent != this.exponent) {
            return null;
        }
        return new Monomial(this.exponent, this.coefficient.add(m.coefficient));
    }
    
    public Monomial mult(final Monomial m) throws Exception {
        return new Monomial(this.exponent + m.exponent, this.coefficient.mul(m.coefficient));
    }
    
    public Scalar evaluate(final Scalar s) throws Exception {
        return this.coefficient.mul(s.power(this.exponent));
    }
    
    public Monomial derivative() throws Exception {
        if (this.exponent == 0) {
            return new Monomial(0, new Integer(0));
        }
        return new Monomial(this.exponent - 1, this.coefficient.mulInteger(new Integer(this.exponent)));
    }
    
    public int sign() {
        return this.coefficient.sign();
    }
    
    @Override
    public String toString() {
        if (this.exponent == 0) {
            return this.coefficient.toString();
        }
        Scalar a = null;
        try {
            a = this.coefficient.addInteger(new Integer(1));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        final int num1 = a.sign();
        if (num1 == 0) {
            if (this.exponent == 1) {
                return "-x";
            }
            return invokedynamic(makeConcatWithConstants:(I)Ljava/lang/String;, this.exponent);
        }
        else {
            Scalar b = null;
            try {
                b = this.coefficient.addInteger(new Integer(-1));
            }
            catch (Exception e2) {
                e2.printStackTrace();
            }
            final int num2 = b.sign();
            if (num2 == 0) {
                if (this.exponent == 1) {
                    return "x";
                }
                return invokedynamic(makeConcatWithConstants:(I)Ljava/lang/String;, this.exponent);
            }
            else {
                if (this.exponent == 1) {
                    return invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, this.coefficient.toString());
                }
                return invokedynamic(makeConcatWithConstants:(Ljava/lang/String;I)Ljava/lang/String;, this.coefficient.toString(), this.exponent);
            }
        }
    }
    
    public int getExponent() {
        return this.exponent;
    }
}
