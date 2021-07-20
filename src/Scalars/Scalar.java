// 
// Decompiled by Procyon v0.5.36
// 

package Scalars;

public interface Scalar
{
    Scalar add(final Scalar p0) throws Exception;
    
    Scalar mul(final Scalar p0) throws Exception;
    
    Scalar addRational(final Rational p0) throws Exception;
    
    Scalar addInteger(final Integer p0) throws Exception;
    
    Scalar mulRational(final Rational p0) throws Exception;
    
    Scalar mulInteger(final Integer p0) throws Exception;
    
    Scalar power(final int p0) throws Exception;
    
    int sign();
    
    Scalar neg() throws Exception;
}
