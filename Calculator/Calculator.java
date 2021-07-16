// 
// Decompiled by Procyon v0.5.36
// 

package Calculator;

import Scalars.Rational;
import Scalars.Integer;
import Scalars.Scalar;
import MathForms.Polynomial;

public class Calculator
{
    private static void printTitle(final String s) {
        System.out.println(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, s));
    }
    
    private static void printAdd(final Polynomial p1, final Polynomial p2, final Polynomial res) {
        System.out.println(invokedynamic(makeConcatWithConstants:(LMathForms/Polynomial;LMathForms/Polynomial;LMathForms/Polynomial;)Ljava/lang/String;, p1, p2, res));
    }
    
    private static void printMul(final Polynomial p1, final Polynomial p2, final Polynomial res) {
        System.out.println(invokedynamic(makeConcatWithConstants:(LMathForms/Polynomial;LMathForms/Polynomial;LMathForms/Polynomial;)Ljava/lang/String;, p1, p2, res));
    }
    
    private static void printEval(final Polynomial p, final Scalar s, final Scalar res) {
        System.out.println(invokedynamic(makeConcatWithConstants:(LMathForms/Polynomial;LScalars/Scalar;LScalars/Scalar;)Ljava/lang/String;, p, s, res));
    }
    
    private static void printDerivate(final Polynomial p, final Polynomial d) {
        System.out.println(invokedynamic(makeConcatWithConstants:(LMathForms/Polynomial;LMathForms/Polynomial;)Ljava/lang/String;, p, d));
    }
    
    public static void main(final String[] args) throws Exception {
        final Polynomial p1 = Polynomial.build("1/2 1");
        System.out.println(p1);
        final Polynomial p2 = Polynomial.build("1 0 -1 0 1/4");
        final Polynomial p3 = Polynomial.build("5 0 -2");
        final Polynomial p4 = Polynomial.build("5");
        final Polynomial p5 = Polynomial.build("2/-1");
        final Polynomial p6 = Polynomial.build("1/2 1 0 8");
        final Polynomial p7 = Polynomial.build("0 0 100");
        final Polynomial p8 = Polynomial.build("0 -1");
        final Polynomial p9 = Polynomial.build("0 -1/-2");
        printTitle("Testing Add");
        printAdd(p1, p1, p1.add(p1));
        printAdd(p1, p2, p1.add(p2));
        printAdd(p2, p3, p2.add(p3));
        printAdd(p3, p1, p3.add(p1));
        printAdd(p4, p4, p4.add(p4));
        printAdd(p5, p5, p5.add(p5));
        printAdd(p5, p6, p5.add(p6));
        printAdd(p6, p7, p6.add(p7));
        printAdd(p7, p5, p7.add(p5));
        printAdd(p8, p8, p8.add(p8));
        printAdd(p9, p9, p9.add(p9));
        printAdd(p8, p9, p8.add(p9));
        printTitle("Testing Mul");
        printMul(p1, p1, p1.mul(p1));
        printMul(p1, p2, p1.mul(p2));
        printMul(p2, p3, p2.mul(p3));
        printMul(p3, p1, p3.mul(p1));
        printMul(p4, p4, p4.mul(p4));
        printMul(p5, p5, p5.mul(p5));
        printMul(p5, p6, p5.mul(p6));
        printMul(p6, p7, p6.mul(p7));
        printMul(p7, p5, p7.mul(p5));
        printMul(p8, p8, p8.mul(p8));
        printMul(p9, p9, p9.mul(p9));
        printMul(p8, p9, p8.mul(p9));
        printTitle("Testing Evaluate");
        Scalar r = new Integer(0);
        printEval(p1, r, p1.evaluate(r));
        printEval(p2, r, p2.evaluate(r));
        printEval(p3, r, p3.evaluate(r));
        printEval(p4, r, p4.evaluate(r));
        r = new Integer(1);
        printEval(p1, r, p1.evaluate(r));
        printEval(p2, r, p2.evaluate(r));
        printEval(p3, r, p3.evaluate(r));
        printEval(p4, r, p4.evaluate(r));
        Scalar q = new Rational(0, 1);
        printEval(p5, q, p5.evaluate(q));
        printEval(p6, q, p6.evaluate(q));
        printEval(p7, q, p7.evaluate(q));
        printEval(p8, q, p8.evaluate(q));
        printEval(p9, q, p9.evaluate(q));
        q = new Rational(1, 1);
        printEval(p5, q, p5.evaluate(q));
        printEval(p6, q, p6.evaluate(q));
        printEval(p7, q, p7.evaluate(q));
        printEval(p8, q, p8.evaluate(q));
        printEval(p9, q, p9.evaluate(q));
        printTitle("Testing derivative");
        printDerivate(p1, p1.derivative());
        printDerivate(p2, p2.derivative());
        printDerivate(p3, p3.derivative());
        printDerivate(p4, p4.derivative());
        printDerivate(p5, p5.derivative());
        printDerivate(p6, p6.derivative());
        printDerivate(p7, p7.derivative());
        printDerivate(p8, p8.derivative());
        printDerivate(p9, p9.derivative());
    }
}
