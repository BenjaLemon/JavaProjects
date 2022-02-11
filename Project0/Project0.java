/*
 * PROJECT 0
 *
 * This file is a SKELETON file. It has a SMALL set of test to check some features of 
 * the FRACTIONS class.  The BOSS system will test ALL parts of your solution.
 * You must create your own tests.
 * 
 * Tasks:
 *
 * 1) Create your own tests for the FRACTIONS class 
 *
 * 2) Fill in the following fields:
 *
 * NAME: BEN MOORE
 * UNIVERSITY ID: U2008074
 * DEPARTMENT: MATHEMATICS
 */

/**
 * Classname: Project0
 * Description: This class utlises a new type for fractions
 *              and corresponding arithmetic.
 * 
 * @author : A.Hague for use in the course MA117
 * @version: history: v1.0
 */

public class Project0 {
    // Simple tester function.
    public static void main(String[] args) {
        // Test constructors.
        Fraction A = new Fraction(-8,16);
        Fraction H = new Fraction(1,3);
        Fraction B = new Fraction(2,-12); //Test that fractions are stored in reduced forms with negatives in numerator
        Fraction n = new Fraction(5); //This should output as 5/1
        Fraction x = new Fraction(); //this should ouput as 0/1
        System.out.println("B = "+B+" = "+B.toDouble()); //should output -1/6
        System.out.println("Constructor output for integer 5 is: "+n); //should output 5/1
        System.out.println("Default constructor output is: "+x); //should output 0/1
        

        // Test conversions.
        System.out.println("A = "+A+" = "+A.toDouble());
        System.out.println("H = "+H+" = "+H.toDouble());
        System.out.println("B = "+ A.toString()); //testing toString method although +A does this implictly anyway
        
        // Test operations.
        System.out.println("A+H = "+A.add(H)); //expect -1/6
        System.out.println("A/H = "+A.divide(H)); //expect -3/2
        System.out.println("AxB = "+A.multiply(B)); //expect 1/12


        // Test errors
        // While a denominator of 0 is not valid, the Fraction should continue to work.
        // Only toFloat() and toDouble() will implicitly raise divide by zero exceptions,
        // and this is the expected behaviour
		Fraction Bad = new Fraction(12,0);
		System.out.println(Bad);  //I personally believe this should be 1/0 but as per FAQ will display as 12/0
        Fraction Bad2 = new Fraction(0,12);
		System.out.println(Bad2.toString());  //Should output 0/1
    }
}
