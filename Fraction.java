/**
 * This class is a simple abstraction that represents the ratio of two numbers.
 * 
 * @author Katarina McGaughy
 * @version HW2, 02/06/21
 *
 */
import java.lang.*;
public class Fraction {

	public static int NUMERATOR = 0;
	public static int DENOMINATOR = 1;
	private int numerator;
	private int denominator;

	/**
	 * setNumerator
	 * This functions sets the Fraction numerator
	 * @param numerator
	 */
	private void setNumerator(int numerator) {
			this.numerator = numerator;
	}

	/**
	 * getNumerator 
	 * @return : returns the Fraction numerator 
	 */
	private int getNumerator() {
		return this.numerator;
	}

	/**
	 * setDenominator
	 * This function sets the Fraction denominator
	 * @param denominator : can't be 0, if 0, it will be set to 1
	 * if denominator is negative, it will be altered to positive 
	 */
	private void setDenominator(int denominator) {
		if (denominator == 0) {
			System.out.println("Denominator can't be 0. Setting to default of 1.");
			this.denominator = 1;
		} 
		else {
			this.denominator = denominator;
		}
	}

	/**
	 * getDenominator
	 * @return: returns Fraction denominator 
	 */
	private int getDenominator() {
		return this.denominator;

	}

	public Fraction() {

	}

	/**
	 * Fraction 
	 * Constructor that sets the simplified numerator and denominator for 
	 * the Fraction
	 * @param numerator: must be an int and represent numerator
	 * @param denominator: must be an int and represent denominator 
	 */
	public Fraction(int numerator, int denominator) {
		if (numerator<0 && denominator<0) {
			numerator = Math.abs(numerator);
			denominator = Math.abs(denominator);
		}
		setNumerator(numerator);
		setDenominator(denominator);
		// simplify the int fraction
		int[] simpleFraction = simplifyFraction();
		// set simplified fraction numerator and denominator
		setNumerator(simpleFraction[NUMERATOR]);
		setDenominator(simpleFraction[DENOMINATOR]);
	}

	/**
	 * gcf This function takes in two integers and returns the greatest common
	 * factor
	 * 
	 * @param int a and int b : two numbers
	 * @return : returns gcf of both numbers PRE: NONE POST: return gcf
	 * 
	 */
	public static int gcf(int a, int b) {
		// Everything divides 0
		a = Math.abs(a);
		b = Math.abs(b);
		
		
		if (a == 0)
			return b;
		if (b == 0)
			return a;

		// base case
		if (a == b)
			return a;

		// a is greater
		if (a > b)
			return gcf(a - b, b);
		return gcf(a, b - a);
	}

	/**
	 * simplifyFractions This function takes in an int array of a fraction and
	 * returns the simplified fraction
	 * 
	 * @param fraction : an array that holds two numbers representing a fraction
	 * @return : returns a simplified fraction PRE: NONE POST: returns a simplified
	 *         fraction
	 * 
	 */
	public int[] simplifyFraction() {
		int gcf = gcf(this.numerator, this.denominator);
		return new int[] { numerator / gcf, denominator / gcf };
	}

	/**
	 * equals
	 * This function compares two fractions and returns true
	 * if they are equal
	 * @param other: another Fraction 
	 * @return: returns true if the fractions are equal
	 */
	public boolean equals(Fraction other) {
		if (this.toString() == other.toString()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * toString 
	 * @return : returns a String representation of the fraction
	 */
	public String toString() {
		return this.numerator + "/" + this.denominator;
	}

}
