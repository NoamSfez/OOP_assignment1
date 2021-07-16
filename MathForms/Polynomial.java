// 
// Decompiled by Procyon v0.5.36
// 

package MathForms;

import Scalars.Rational;
import Scalars.Scalar;
import java.util.ArrayList;

public class Polynomial
{
    private ArrayList<Monomial> monomials;
    
    private Polynomial(final ArrayList<Monomial> a) {
        this.monomials = a;
    }
    
    public static Polynomial build(final String input) throws Exception {
        final ArrayList<Monomial> ans = new ArrayList<Monomial>();
        if (!input.contains(" ") && (input.length() == 1 & input.contains("0"))) {
            ans.add(new Monomial(0, new Scalars.Integer(Integer.parseInt(input))));
            return getArr(ans);
        }
        final String[] arr = input.split(" ");
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i].compareTo("0") != 0) {
                if (arr[i].contains("/")) {
                    final String[] myPoly = arr[i].split("/");
                    ans.add(new Monomial(i, new Rational(Integer.parseInt(myPoly[0]), Integer.parseInt(myPoly[1]))));
                }
                else {
                    ans.add(new Monomial(i, new Scalars.Integer(Integer.parseInt(arr[i]))));
                }
            }
        }
        return getArr(ans);
    }
    
    private static Polynomial getArr(final ArrayList a) {
        return new Polynomial(a);
    }
    
    public Polynomial add(final Polynomial p) throws Exception {
        int i = 0;
        int j = 0;
        int myExponet = 0;
        int otherExponet = 0;
        final ArrayList<Monomial> otherPoly = p.getMonomials();
        final ArrayList<Monomial> ans = new ArrayList<Monomial>();
        while (i < this.monomials.size() || j < otherPoly.size()) {
            if (i < this.monomials.size()) {
                myExponet = this.monomials.get(i).getExponent();
            }
            if (j < otherPoly.size()) {
                otherExponet = otherPoly.get(j).getExponent();
            }
            if (myExponet > otherExponet) {
                if (j < otherPoly.size()) {
                    ans.add(otherPoly.get(j));
                    ++j;
                }
                else {
                    ans.add(this.monomials.get(i));
                    ++i;
                }
            }
            else if (myExponet < otherExponet) {
                if (i < this.monomials.size()) {
                    ans.add(this.monomials.get(i));
                    ++i;
                }
                else {
                    ans.add(otherPoly.get(j));
                    ++j;
                }
            }
            else {
                ans.add(this.monomials.get(i).add(otherPoly.get(j)));
                ++j;
                ++i;
            }
        }
        return new Polynomial(ans);
    }
    
    public Polynomial mul(final Polynomial p) throws Exception {
        Boolean flag = false;
        final ArrayList<Monomial> otherPoly = p.getMonomials();
        final ArrayList<Monomial> ans = new ArrayList<Monomial>();
        for (int i = 0; i < this.monomials.size(); ++i) {
            for (int j = 0; j < otherPoly.size(); ++j) {
                final Monomial momMult = this.monomials.get(i).mult(otherPoly.get(j));
                for (int k = 0; k < ans.size(); ++k) {
                    if (ans.get(k).getExponent() == momMult.getExponent()) {
                        ans.set(k, ans.get(k).add(momMult));
                        flag = true;
                    }
                }
                if (!flag) {
                    ans.add(momMult);
                }
                else {
                    flag = false;
                }
            }
        }
        return new Polynomial(ans);
    }
    
    public Scalar evaluate(final Scalar s) throws Exception {
        Scalar ans = new Scalars.Integer(0);
        if (s.sign() != 0) {
            final ArrayList<Scalar> arr = new ArrayList<Scalar>();
            for (int i = 0; i < this.monomials.size(); ++i) {
                arr.add(this.monomials.get(i).evaluate(s));
            }
            ans = arr.get(0);
            for (int i = 1; i < arr.size(); ++i) {
                ans = ans.add(arr.get(i));
            }
            return ans;
        }
        if (this.monomials.get(0).getExponent() == 0) {
            return ans.add(this.monomials.get(0).evaluate(s));
        }
        return ans;
    }
    
    public Polynomial derivative() throws Exception {
        final ArrayList<Monomial> ans = new ArrayList<Monomial>();
        if (this.monomials.size() == 1 && this.monomials.get(0).getExponent() == 0) {
            ans.add(this.monomials.get(0).derivative());
        }
        else {
            for (int i = 0; i < this.monomials.size(); ++i) {
                if (this.monomials.get(i).getExponent() != 0) {
                    ans.add(this.monomials.get(i).derivative());
                }
            }
        }
        return new Polynomial(ans);
    }
    
    @Override
    public String toString() {
        String ans = "";
        if (this.monomials.size() >= 1) {
            ans = invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;, ans, this.monomials.get(0));
        }
        for (int i = 1; i < this.monomials.size(); ++i) {
            if (this.monomials.get(i).sign() > 0) {
                ans = invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;, ans, this.monomials.get(i));
            }
            else {
                ans = invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;, ans, this.monomials.get(i));
            }
        }
        return ans;
    }
    
    private ArrayList<Monomial> getMonomials() {
        return this.monomials;
    }
}
