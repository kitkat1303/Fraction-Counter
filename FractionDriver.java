/**
 * This class reads fractions from a text file and counts how many 
 * of the same fractions exist in the file.
 * 
 * @author Katarina McGaughy
 * @version HW2, 02/06/21
 *
 */
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class FractionDriver {
	public static int NUMERATOR = 0;
	public static int DENOMINATOR = 1;

	public static void main(String[] args) {
		String filePath = "fractions.txt";
		//stores the String fractions from the file 
		ArrayList<String> strFractions = parseFractions(filePath);
		//stores and converts the String fractions to ints 
		ArrayList<Fraction> fractions = new ArrayList<>();
		for (String strFraction : strFractions) {
			// convert string fraction to int
			int[] intFraction = fractionToInts(strFraction);
			// initialize all fractions
			fractions.add(new Fraction(intFraction[NUMERATOR], intFraction[DENOMINATOR]));
		}

		ArrayList<FractionCounter> counters = new ArrayList<>();
		//iterates through the counters 
		for (Fraction fraction : fractions) {
			//compares and increments 
			boolean wasAddedToCounters = tryAdd(fraction, counters); 
			//if false is returned, the fraction is added to counters 
			if (!wasAddedToCounters) {
				FractionCounter fc = new FractionCounter(fraction);
				fc.compareAndIncrement(fraction);
				counters.add(fc);
			}
		}

		//prints the unique fractions and their count
		counters.forEach(System.out::println);
	}

	/**
	 * parseFractions 
	 * This function takes in a String path (file name) and counts
	 * the number of lines in the file. It then creates an ArrayList of String fractions
	 * from the file and returns it
	 * 
	 * @param path : file name holding the list of fractions
	 * @return : ArrayList of fractions 
	 * PRE: file 
	 * POST: return the fractions present in
	 *         the file as a String array
	 * 
	 */
	public static ArrayList<String> parseFractions(String path) {
		ArrayList<String> fractions = new ArrayList<>();
		File inputFile = new File(path);
		try (Scanner fractionReader = new Scanner(inputFile)) {
			while (fractionReader.hasNextLine()) {
				fractions.add(fractionReader.nextLine());
			}
		} catch (Exception e) {
			System.out.println("File not found!");
		}
		return fractions;
	}

	/**
	 * tryAdd
	 * This function iterates through the FractionCounter and returns True if
	 * the same function is found 
	 * @param fraction: Fraction
	 * @param counters: ArrayList of FractionCounter
	 * @return: returns True if two Fractions are the same and false 
	 * if they are not 
	 */
	private static boolean tryAdd(Fraction fraction, ArrayList<FractionCounter> counters) {
		for (FractionCounter fc : counters) {
			if (fc.compareAndIncrement(fraction)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * fractionToInts This function takes in a String fraction and returns the
	 * fraction as an int array
	 * 
	 * @param fraction : fraction as a String ex: "1/2"
	 * @return : returns an int array representation of fraction PRE: String
	 *         fraction POST: returns an int array representation of fraction
	 * 
	 */
	public static int[] fractionToInts(String fraction) {
		String[] splitFraction = fraction.split("/");
		int numerator = Integer.valueOf(splitFraction[NUMERATOR]);
		int denominator = Integer.valueOf(splitFraction[DENOMINATOR]);
		return new int[] { numerator, denominator };
	}

}
