// 
// Decompiled by Procyon v0.5.36
// 

package ScalarsTest;

import Scalars.Rational;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import Scalars.Scalar;
import Scalars.Integer;

class IntegerTest
{
    private Integer num;
    private Integer num2;
    private Scalar s_toTest;
    
    @BeforeEach
    void setUp() {
        this.num = new Integer(2);
        this.num2 = new Integer(7);
    }
    
    @Test
    void test_add1() throws Exception {
        this.s_toTest = this.num.add(new Integer(3));
        Assertions.assertEquals((Object)"5", (Object)this.s_toTest.toString());
    }
    
    @Test
    void test_add2() throws Exception {
        this.s_toTest = this.num2.add(new Rational(3, 5));
        Assertions.assertEquals((Object)"38/5", (Object)this.s_toTest.toString());
    }
    
    @Test
    void test_addRational() throws Exception {
        this.s_toTest = this.num.addRational(new Rational(2, 7));
        Assertions.assertEquals((Object)"16/7", (Object)this.s_toTest.toString());
    }
    
    @Test
    void test_addRational2() throws Exception {
        this.s_toTest = this.num2.addRational(new Rational(8, 13));
        Assertions.assertEquals((Object)"99/13", (Object)this.s_toTest.toString());
    }
    
    @Test
    void test_addInteger() {
        this.s_toTest = this.num.addInteger(new Integer(12));
        Assertions.assertEquals((Object)"14", (Object)this.s_toTest.toString());
    }
    
    @Test
    void test_addInteger2() {
        this.s_toTest = this.num2.addInteger(new Integer(6));
        Assertions.assertEquals((Object)"13", (Object)this.s_toTest.toString());
    }
    
    @Test
    void test_mul() throws Exception {
        this.s_toTest = this.num.mul(new Integer(5));
        Assertions.assertEquals((Object)"10", (Object)this.s_toTest.toString());
    }
    
    @Test
    void test_mul2() throws Exception {
        this.s_toTest = this.num2.mul(new Rational(5, 19));
        Assertions.assertEquals((Object)"35/19", (Object)this.s_toTest.toString());
    }
    
    @Test
    void test_mulRational() throws Exception {
        this.s_toTest = this.num.mulRational(new Rational(5, 3));
        Assertions.assertEquals((Object)"10/3", (Object)this.s_toTest.toString());
    }
    
    @Test
    void test_mulRational2() throws Exception {
        this.s_toTest = this.num2.mulRational(new Rational(2, 3));
        Assertions.assertEquals((Object)"14/3", (Object)this.s_toTest.toString());
    }
    
    @Test
    void test_mulInteger() {
        this.s_toTest = this.num.mulInteger(new Integer(2));
        Assertions.assertEquals((Object)"4", (Object)this.s_toTest.toString());
    }
    
    @Test
    void test_mulInteger2() {
        this.s_toTest = this.num2.mulInteger(new Integer(1));
        Assertions.assertEquals((Object)"7", (Object)this.s_toTest.toString());
    }
    
    @Test
    void power() {
        this.s_toTest = this.num.power(7);
        Assertions.assertEquals((Object)"128", (Object)this.s_toTest.toString());
    }
    
    @Test
    void power2() {
        this.s_toTest = this.num2.power(3);
        Assertions.assertEquals((Object)"343", (Object)this.s_toTest.toString());
    }
    
    @Test
    void sign() {
        Assertions.assertEquals(1, this.num.sign());
    }
    
    @Test
    void sign2() {
        Assertions.assertEquals(-1, this.num2.neg().sign());
    }
    
    @Test
    void neg() {
        Assertions.assertEquals((Object)"-2", (Object)this.num.neg().toString());
    }
    
    @Test
    void neg2() {
        Assertions.assertEquals((Object)"-7", (Object)this.num2.neg().toString());
    }
}
