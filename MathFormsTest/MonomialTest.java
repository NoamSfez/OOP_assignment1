// 
// Decompiled by Procyon v0.5.36
// 

package MathFormsTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import Scalars.Rational;
import Scalars.Integer;
import Scalars.Scalar;
import MathForms.Monomial;

class MonomialTest
{
    private Monomial mono;
    private Monomial mono2;
    private Scalar scalar_toTest;
    private Monomial mono_toTest;
    
    @BeforeEach
    void setUp() throws Exception {
        this.mono = new Monomial(7, new Integer(7));
        this.mono2 = new Monomial(4, new Rational(7, 13));
    }
    
    @Test
    void test_add() throws Exception {
        this.mono_toTest = this.mono.add(new Monomial(7, new Integer(7)));
        Assertions.assertEquals((Object)"14x^7", (Object)this.mono_toTest.toString());
    }
    
    @Test
    void test_add2() throws Exception {
        this.mono_toTest = this.mono2.add(new Monomial(4, new Integer(13)));
        Assertions.assertEquals((Object)"176/13x^4", (Object)this.mono_toTest.toString());
    }
    
    @Test
    void test_mult() throws Exception {
        this.mono_toTest = this.mono.mult(new Monomial(4, new Integer(13)));
        Assertions.assertEquals((Object)"91x^11", (Object)this.mono_toTest.toString());
    }
    
    @Test
    void test_mult2() throws Exception {
        this.mono_toTest = this.mono2.mult(new Monomial(4, new Rational(12, 6)));
        Assertions.assertEquals((Object)"14/13x^8", (Object)this.mono_toTest.toString());
    }
    
    @Test
    void test_evaluate() throws Exception {
        this.scalar_toTest = this.mono.evaluate(new Integer(3));
        Assertions.assertEquals((Object)"15309", (Object)this.scalar_toTest.toString());
    }
    
    @Test
    void test_evaluate2() throws Exception {
        this.scalar_toTest = this.mono2.evaluate(new Rational(12, 6));
        Assertions.assertEquals((Object)"112/13", (Object)this.scalar_toTest.toString());
    }
    
    @Test
    void test_derivative() throws Exception {
        this.mono_toTest = this.mono.derivative();
        Assertions.assertEquals((Object)"49x^6", (Object)this.mono_toTest.toString());
    }
    
    @Test
    void test_derivative2() throws Exception {
        this.mono_toTest = this.mono2.derivative();
        Assertions.assertEquals((Object)"28/13x^3", (Object)this.mono_toTest.toString());
    }
    
    @Test
    void test_sign() {
        Assertions.assertEquals(1, this.mono.sign());
    }
    
    @Test
    void test_sign2() {
        Assertions.assertEquals(1, this.mono2.sign());
    }
    
    @Test
    void test_sign3() throws Exception {
        Assertions.assertEquals(-1, new Monomial(2, new Rational(-2, 3)).sign());
    }
    
    @Test
    void test_ToString() {
        Assertions.assertEquals((Object)"7x^7", (Object)this.mono.toString());
    }
    
    @Test
    void test_ToString2() {
        Assertions.assertEquals((Object)"7/13x^4", (Object)this.mono2.toString());
    }
}
