/*
 * FRACTION
 *
 * This file is a SKELETON file. That means that a number of functions have
 * not been implemented. Your task is to complete the class by filling in the
 * missing methods.
 * 
 * Tasks:
 * 
 * 1) First an important note. This file contains names of public methods
 *    which you should NOT change. Each method is already "preprogrammed" so
 *    the interface (the functions, their parameters and what should be
 *    returned) is fixed and you should NOT change it. Every function has a
 *    description, which outlines:
 *
 *    - The purpose of the function, and intended use;
 *    - The parameters it accepts (if any) indicated by @param;
 *    - What it returns (if anything) indicated by @return.
 *
 * 2) CAREFULLY read through the class definition.
 *
 * 3) Define the methods that are not implemented. They are indicated by a
 *    comment reading "Fill in this method", but for reference, they are:
 * 
 *    - The Fraction(m,n) constructor.
 *    - Convertors: toDouble(), toString()
 *    - Operations with fractions: add(), divide() and multiply()
 * 
 * 4) Add to the class two methods, which are private and accept no
 * parameters:
 *      
 *    - gcd():    computes and returns the greatest common divisor of the
 *                numerator and denominator for this fraction.
 *    - reduce(): uses gcd() to reduce the fraction to irreducible form. e.g.
 *                a fraction 10/20 is simplified to 1/2.
 *
 * 5) The BOSS system will perform specific tests with your class. It will
 *    test: constructors, operators and simplification to irreducible form. So
 *    even if you do not complete all of the methods you will obtain some
 *    credit if others are completed satisfactorily.
 *
 * 6) Finally, fill in the following fields:
 *
 * NAME: BEN MOORE
 * UNIVERSITY ID: U2008074
 * DEPARTMENT: MATHEMATICS
 */

/**
 * Classname: Fraction
 * Description: This class implements a new type for fractions
 *              and corresponding arithmetic.
 * 
 * @author : Original: K.N. King, modified by D. Moxey and P. Plechac
 *           for use in the course MA117
 * @version: history: v1.1
 */
import java.lang.Math;
public class Fraction {
    // ============================================================
    // Instance variables
    // ============================================================

    /**
     * The numerator of the fraction.
     */
    private int numerator;
    /**
     * The denominator of the fraction.
     */
    private int denominator;  
    
    // ============================================================
    // Constructors
    // ============================================================

    /**
     * Constructor which takes coefficients explicity.
     * 
     * Behaviour: Constructs a fraction with the specified numerator and
     *            denominator. Remember that your fraction should *always* be
     *            stored in irreducible form.
     *
     * @param num   The numerator
     * @param denom The denominator
     */
    public Fraction(int num, int denom) {
        //use gcd here to make it irreducible form
        if (denom * num >0 ){ //denom and num have same sign so any negatives cancel out
            numerator = Math.abs(num);
            denominator = Math.abs(denom);
        } else if (denom < 0){ //put negative in numerator as described in outline
            numerator = -num;
            denominator = -denom;
        } else { //numerator <0, denominator >0 or num*denom = 0
            numerator = num;
            denominator = denom;
        }
        this.reduce();
    }


    /**
     * Constructor which takes coefficients explicity.
     *
     * Behaviour: Constructs a fraction which represents an integer: set the
     *            specified numerator and set denominator to 1.
     *
     * @param num The numerator
     */
    public Fraction(int num) {
        // This method is complete.
        this(num, 1);
    }

    /**
     * Default constructor.
     *
     * Behaviour: Constructs a fraction and set the default value to 0;
     *            i.e. numerator = 0 and denominator = 1
     */
    public Fraction() {
        // This method is complete.
        this(0, 1);
    }
    
    
    // ==============================================================
    // Convertors
    //
    // These functions will convert the Fraction to other data types.
    // ==============================================================

    /**
     * Convert the fraction to the floating point representation using double
     * precision.
     * 
     * Behaviour: Converts this fraction into a double.
     *
     * @return    A double value obtained by dividing the fraction's numerator
     *            by its denominator.
     */
    public double toDouble() {
        // double num = this.numerator;
        // double denom = this.denominator;
        // return num/denom;
        return (double) numerator/denominator;
    }


    /**
     * Convert the fraction to the floating point representation using the
     * single precision.
     *
     * Behaviour: Converts this fraction into a float value.
     *
     * @return    A float value obtained by dividing the fraction's numerator by
     *            its denominator
     */
    public float toFloat() {
        // This method is complete.
        return (float) numerator / denominator;
    }

    /**
     * Convert the fraction to a string.
     * 
     * Behaviour: Converts this fraction into a string
     *
     * @return    A string of the form "num/denom". If the denominator is 1,
     *            returns a string containing *only* the numerator.
     */
    public String toString() {
        //Fill in this method to format the correct string to return.
        return numerator + "/" + denominator;
    }
    
    
    // ============================================================
    // Accessors and mutator methods (getters and setters)
    // ============================================================

    /**
     * Get denominator.
     *
     * Behaviour: Returns the denominator of this fraction.
     *
     * @return    The denominator of this fraction.
     */
    public int getDenominator() {
        // This method is complete.
        return denominator;
    }

    /**
     * Get numerator.
     *
     * Behaviour: Returns the numerator of this fraction.
     *
     * @return    The numerator of this fraction.
     */
    public int getNumerator() {
        // This method is complete.
        return numerator;
    }

    //============================================================
    // Operations with fractions - Core methods
    //============================================================

    /**
     * Addition operation.
     *
     * Behaviour: Adds this fraction to a supplied fraction.
     *
     * @param f  The fraction to be added.
     * @return   The sum of this fraction and f.
     */
    public Fraction add(Fraction f) {
        // a/b + p/q = aq+pb / bq but this might not be in reduced form
        int sumNumerator = numerator * f.denominator + f.numerator * denominator;
        int sumDenominator = denominator * f.denominator;
        // Fill in this method to calculate the correct Fraction to return.
        return new Fraction(sumNumerator,sumDenominator);
    }

    /**
     * Subtraction operation.
     * 
     * Behaviour: Subtracts a fraction from this fraction.
     *
     * @param f   The fraction to be subtracted.
     * @return    The difference between this fraction and f.
     *
     */
    public Fraction subtract(Fraction f) {
        // This method is complete.
        int num   = numerator * f.denominator - f.numerator * denominator;
        int denom = denominator * f.denominator;
        
        return new Fraction(num, denom);
    }

    /**
     * Division.
     *
     * Behaviour: Divides this fraction by another fraction.
     * 
     * @param f   The fraction to be used as a divisor.
     * @return    The quotient of this fraction and f.
     */
    public Fraction divide(Fraction f) {
        // a/b / p/q = aq/bp flip the second fraction and treat as if its multiplication
        int num = numerator * f.denominator;
        int denom = denominator * f.numerator;
        return new Fraction(num, denom);
    }

    /**
     * Multiplication.
     * 
     * Behaviour: Multiplies this fraction and another fraction.
     *
     * @param f   The fraction to be multiplied.
     * @return    The product of this fraction and f.
     */
    public Fraction multiply(Fraction f) {
        int num = numerator * f.numerator;
        int denom = denominator * f.denominator;
        return new Fraction(num, denom);
    }

    //============================================================
    // User defined methods -gcd, reduce
    //============================================================
    
    /**
     * GCD Calculation
     *
     * Behaviour:  computes and returns the greatest common divisor of the
     *             numerator and denominator for this fraction.        
     *
     * @return   The gcd of the numerator and denominator
     */
    private int gcd(){
        //use euclidean algorithm to find gcd efficiently
        //If A = B⋅Q + R and B≠0 then GCD(A,B) = GCD(B,R)
        //only use absolute values of numerator and denominator as the 
        //numerator may be negative and we want a positive gcd
        int a = Math.abs(numerator);
        int b = Math.abs(denominator);
        if (a==0){
            return b;
        } else if (b==0){  
            //mathematical corectness says gcd(a,0)=a but FAQ
            //says that 12/0 should be displayed as 12/0 which requires
            //gcd(12,0)=1 so that the call to reduce in the fraction constructor 
            //works as described 
            return 1;
        }else{
            while (b>0) { 
                int r = a % b; // the remainder after long division 
                a = b; //A->B for next step of algorithm
                b = r; //B->R for next step of algorithm
            }
            return a; //when R=0 the gcd is the value stored in A;
        }
    }

    /**
     * Fraction reducer
     *
     * Behaviour:  uses gcd() to reduce the fraction to irreducible form. e.g.
     *             a fraction 10/20 is simplified to 1/2.       
     */
    private void reduce(){
        int gcd = this.gcd();
        numerator = numerator / gcd;
        denominator = denominator / gcd;
    }

    
    // ======================================================================
    // END OF USER MODIFIABLE CODE
    //
    // DO NOT CHANGE ANY FUNCTIONS IN THE SECTION BELOW; THEY ARE NEEDED FOR 
    // THE AUTOMATED MARKING SYSTEM. YOUR CODE CANNOT BE MARKED WITHOUT IT!
    // ======================================================================

    /**
     * Compare two fractions.
     *
     * @param  q  The fraction to compare with.
     * @return    true if q is Fraction equal to this fraction .
     */
    public boolean sameAs(Fraction q) {
        return (numerator   == q.getNumerator() &&
                denominator == q.getDenominator());
    }
}
