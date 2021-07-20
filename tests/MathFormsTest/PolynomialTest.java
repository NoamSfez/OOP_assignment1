// 
// Decompiled by Procyon v0.5.36
// 

package MathFormsTest;

import Scalars.Rational;
import Scalars.Integer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import Scalars.Scalar;
import MathForms.Polynomial;

class PolynomialTest
{
    private Polynomial poly;
    private Polynomial poly2;
    private Polynomial poly_toTest;
    private Scalar scalar_toTest;
    
    @BeforeEach
    void setUp() throws Exception {
        this.poly = Polynomial.build("1/2 3 -1 0 1/4");
        this.poly2 = Polynomial.build("0 3/4 0 0 -4 1 7/2 ");
    }
    
    @Test
    void test_build() {
        Assertions.assertEquals((Object)"1/2+3x-x^2+1/4x^4", (Object)this.poly.toString());
    }
    
    @Test
    void test_build2() {
        Assertions.assertEquals((Object)"3/4x-4x^4+x^5+7/2x^6", (Object)this.poly2.toString());
    }
    
    @Test
    void test_add() throws Exception {
        this.poly_toTest = this.poly.add(Polynomial.build("2 0 2/7 0 0 -3"));
        Assertions.assertEquals((Object)"5/2+3x-5/7x^2+1/4x^4-3x^5", (Object)this.poly_toTest.toString());
    }
    
    @Test
    void test_add2() throws Exception {
        this.poly_toTest = this.poly.add(Polynomial.build("3/4 0 0 7"));
        Assertions.assertEquals((Object)"5/4+3x-x^2+7x^3+1/4x^4", (Object)this.poly_toTest.toString());
    }
    
    @Test
    void test_mul() throws Exception {
        this.poly_toTest = this.poly.mul(Polynomial.build("2 0 2/7 0 0 -3"));
        Assertions.assertEquals((Object)"1-13/7x^2-3/2x^5+6x+6/7x^3-125/14x^6+3/14x^4+3x^7-3/4x^9", (Object)this.poly_toTest.toString());
    }
    
    @Test
    void test_mul2() throws Exception {
        this.poly_toTest = this.poly2.mul(Polynomial.build("3/4 0 0 7"));
        Assertions.assertEquals((Object)"9/16x+9/4x^4-28x^7+3/4x^5+7x^8+21/8x^6+49/2x^9", (Object)this.poly_toTest.toString());
    }
    
    @Test
    void test_evaluate() throws Exception {
        this.scalar_toTest = this.poly.evaluate(new Integer(3));
        Assertions.assertEquals((Object)"83/4", (Object)this.scalar_toTest.toString());
    }
    
    @Test
    void test_evaluate2() throws Exception {
        this.scalar_toTest = this.poly2.evaluate(new Rational(12, 6));
        Assertions.assertEquals((Object)"6333/4478", (Object)this.scalar_toTest.toString());
    }
    
    @Test
    void test_derivative() throws Exception {
        Assertions.assertEquals((Object)"3-2x+x^3", (Object)this.poly.derivative().toString());
    }
    
    @Test
    void test_derivative2() throws Exception {
        Assertions.assertEquals((Object)"3/4-16x^3+5x^4+21x^5", (Object)this.poly2.derivative().toString());
    }
    
    @Test
    void test_ToString() {
        Assertions.assertEquals((Object)"1/2+3x-x^2+1/4x^4", (Object)this.poly.toString());
    }
    
    @Test
    void test_ToString2() {
        Assertions.assertEquals((Object)"3/4x-4x^4+x^5+7/2x^6", (Object)this.poly2.toString());
    }
}
