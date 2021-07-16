// 
// Decompiled by Procyon v0.5.36
// 

package ScalarsTest;

import Scalars.Integer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import Scalars.Scalar;
import Scalars.Rational;

class RationalTest
{
    private Rational num;
    private Rational num2;
    private Scalar s_toTest;
    
    @BeforeEach
    void setUp() throws Exception {
        this.num = new Rational(2, 3);
        this.num2 = new Rational(7, 2);
    }
    
    @Test
    void test_legal() throws Exception {
        Assertions.assertThrows((Class)IllegalArgumentException.class, () -> new Rational(3, 0));
    }
    
    @Test
    void test_add1() throws Exception {
        this.s_toTest = this.num.add(new Integer(3));
        Assertions.assertEquals((Object)"11/3", (Object)this.s_toTest.toString());
    }
    
    @Test
    void test_add2() throws Exception {
        this.s_toTest = this.num2.add(new Rational(3, 5));
        Assertions.assertEquals((Object)"41/10", (Object)this.s_toTest.toString());
    }
    
    @Test
    void test_mul() throws Exception {
        this.s_toTest = this.num.mul(new Integer(5));
        Assertions.assertEquals((Object)"10/3", (Object)this.s_toTest.toString());
    }
    
    @Test
    void test_mul2() throws Exception {
        this.s_toTest = this.num2.mul(new Rational(5, 19));
        Assertions.assertEquals((Object)"35/38", (Object)this.s_toTest.toString());
    }
    
    @Test
    void test_addRational() throws Exception {
        this.s_toTest = this.num.addRational(new Rational(2, 7));
        Assertions.assertEquals((Object)"20/21", (Object)this.s_toTest.toString());
    }
    
    @Test
    void test_addRational2() throws Exception {
        this.s_toTest = this.num2.addRational(new Rational(8, 13));
        Assertions.assertEquals((Object)"107/26", (Object)this.s_toTest.toString());
    }
    
    @Test
    void test_addInteger() throws Exception {
        this.s_toTest = this.num.addInteger(new Integer(12));
        Assertions.assertEquals((Object)"38/3", (Object)this.s_toTest.toString());
    }
    
    @Test
    void test_addInteger2() throws Exception {
        this.s_toTest = this.num2.addInteger(new Integer(6));
        Assertions.assertEquals((Object)"19/2", (Object)this.s_toTest.toString());
    }
    
    @Test
    void test_mulRational() throws Exception {
        this.s_toTest = this.num.mulRational(new Rational(5, 3));
        Assertions.assertEquals((Object)"10/9", (Object)this.s_toTest.toString());
    }
    
    @Test
    void test_mulRational2() throws Exception {
        this.s_toTest = this.num2.mulRational(new Rational(2, 3));
        Assertions.assertEquals((Object)"7/3", (Object)this.s_toTest.toString());
    }
    
    @Test
    void test_mulInteger() throws Exception {
        this.s_toTest = this.num.mulInteger(new Integer(2));
        Assertions.assertEquals((Object)"4/3", (Object)this.s_toTest.toString());
    }
    
    @Test
    void test_mulInteger2() throws Exception {
        this.s_toTest = this.num2.mulInteger(new Integer(1));
        Assertions.assertEquals((Object)"7/2", (Object)this.s_toTest.toString());
    }
    
    @Test
    void power() throws Exception {
        this.s_toTest = this.num.power(7);
        Assertions.assertEquals((Object)"128/2187", (Object)this.s_toTest.toString());
    }
    
    @Test
    void power2() throws Exception {
        this.s_toTest = this.num2.power(3);
        Assertions.assertEquals((Object)"343/8", (Object)this.s_toTest.toString());
    }
    
    @Test
    void sign() {
        Assertions.assertEquals(1, this.num.sign());
    }
    
    @Test
    void sign2() throws Exception {
        Assertions.assertEquals(-1, this.num2.neg().sign());
    }
    
    @Test
    void neg() throws Exception {
        Assertions.assertEquals((Object)"-2/3", (Object)this.num.neg().toString());
    }
    
    @Test
    void neg2() throws Exception {
        Assertions.assertEquals((Object)"-7/2", (Object)this.num2.neg().toString());
    }
    
    @Test
    void test_reduce() {
        Assertions.assertEquals((Object)"2/3", (Object)this.num.reduce().toString());
    }
    
    @Test
    void test_reduce2() {
        Assertions.assertEquals((Object)"2/3", (Object)this.num.reduce().toString());
    }
    
    @Test
    void test_reduce3() throws Exception {
        Assertions.assertEquals((Object)"39/62", (Object)new Rational(234, 372).reduce().toString());
    }
    
    @Test
    void test_ToString() {
        Assertions.assertEquals((Object)"2/3", (Object)this.num.toString());
    }
    
    @Test
    void test_ToString2() {
        Assertions.assertEquals((Object)"7/2", (Object)this.num2.toString());
    }
}
