package driver;

/**
 * Shawn Guerra-Bautista (40032995)<br>
 * COMP249<br>
 * Assignment #4<br>
 * Due Date 10/04/2017<br>
 * <br>
 * This class' goal is to create an exception for when the user enters an existing ID
 * It also inherits from the Exception class
 * @author Shawn Guerra-Bautista
 */

public class ExistingIDException extends Exception{
	
	/*
	 * Default constructor with a default message
	 */
	public ExistingIDException(){
		super("The ID number that you have entered exits in one of the file!\n"
				+ "Please enter another number:");
	}
	
	/**
	 * Parameterized constructor
	 * @param message This exception's message
	 */
	public ExistingIDException(String message){
		super(message);
	}
	
	/**
	 * Gets this exception's message
	 */
	public String getMessage(){
		return super.getMessage();
	}
}
