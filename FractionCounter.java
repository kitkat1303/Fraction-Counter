
/**
 * The purpose of this class is to store a reference to a Fraction object 
 * and a count of how many times this fraction object has been seen in the input file.  
 * 
 * @author Katarina McGaughy
 * @version HW2, 02/06/21
 *
 */
public class FractionCounter {
	private Fraction fraction;
	private int fractionCount;

	/**
	 * getFractionCount 
	 * This function returns how many times the fraction occurs
	 * @return: returns the fraction count
	 */
	public int getFractionCount() {
		return this.fractionCount;
	}

	/**
	 * FractionCounter
	 * @param theFraction: takes in a fraction and sets the fraction
	 */
	public FractionCounter(Fraction theFraction) { 
		if (theFraction == null) {
			System.out.println("The fraction can't be null. Setting to default of 1/1.");
			this.fraction = new Fraction(1,1);
		}
		else {
		this.fraction = theFraction;
		}
	}

	/**
	 * compareAndIncrement
	 * This function takes in another function and compares to see if both 
	 * fractions are equal
	 * @param newFraction: another Fraction
	 * @return: returns if True if they are equal and False if they are not 
	 */
	public boolean compareAndIncrement(Fraction newFraction) {
		if (newFraction != null && this.fraction != null) {
			if (this.fraction.toString().equals(newFraction.toString())) {
				this.fractionCount++;
				return true;
			}
		}
		return false;
	}

	/**
	 * toString 
	 * @return: returns a string representation of the fraction along with 
	 * the count 
	 */
	public String toString() {
		return this.fraction.toString() + " has a count of " + this.fractionCount;
	}
}
