package standardEmployee;

/**
 * Shawn Guerra-Bautista (40032995)<br>
 * COMP249<br>
 * Assignment #4<br>
 * Due Date 10/04/2017<br>
 * <br>
 * An interface for Ordering
 * @author Shawn Guerra-Bautista
 */
public interface Ordered {

	/**
	 * Checks whether object precedes another
	 * @param obj Another object
	 * @return whether this precedes obj
	 */
	abstract boolean precedes(Object obj);
	
	/**
	 * Checks whether object follows another
	 * @param obj Another object
	 * @return whether this follow obj
	 */
	abstract boolean follows(Object obj);
}
