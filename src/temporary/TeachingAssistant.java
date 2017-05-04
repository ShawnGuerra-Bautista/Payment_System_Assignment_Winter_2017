package temporary;
import standardEmployee.Employee;
import standardEmployee.SalaryInfo;

/**
 * Shawn Guerra-Bautista (40032995)<br>
 * COMP249<br>
 * Assignment #4<br>
 * Due Date 10/04/2017<br>
 * <br>
 * This class' goal is to create Teaching Assistant objects
 * Superclass: Employee
 * Implementations (interfaces): SalaryInfo
 * @author Shawn Guerra-Bautista
 */

public class TeachingAssistant extends Employee implements SalaryInfo{

	private String classification;
	private int numberOfClasses;
	private int totalWorkingHours;

	/**
	 * Parameterized constructor
	 * @param employeeIdentification This Teaching Assistant's identification
	 * @param firstName This Teaching Assistant's first name
	 * @param familyName This Teaching Assistant's family name
	 * @param cityOfResidence This Teaching Assistant's residence
	 * @param hireYear This Teaching Assistant's hire year
	 * @param classification This Teaching Assistant's classification
	 * @param numberOfClasses This Teaching Assistant's number of classes
	 * @param totalWorkingHours This Teaching Assistant's total working hours
	 */
	public TeachingAssistant(int employeeIdentification, String firstName, String familyName, String cityOfResidence,
			int hireYear, String classification, int numberOfClasses, int totalWorkingHours) {
		super(employeeIdentification, firstName, familyName, cityOfResidence, hireYear);
		this.classification = classification;
		this.numberOfClasses = numberOfClasses;
		this.totalWorkingHours = totalWorkingHours;
	}

	/**
	 * Gets this TA's classification
	 * @return This TA's classification
	 */
	public String getClassification() {
		return classification;
	}

	/**
	 * Changes this TA's classification
	 * @param classification This TA's new classification
	 */
	public void setClassification(String classification) {
		this.classification = classification;
	}

	/**
	 * Gets this TA's number of classes
	 * @return This TA's number of classes
	 */
	public int getNumberOfClasses() {
		return numberOfClasses;
	}

	/**
	 * Changes this TA's number of classes
	 * @param numberOfClasses This TA's new  number of classes
	 */
	public void setNumberOfClasses(int numberOfClasses) {
		this.numberOfClasses = numberOfClasses;
	}

	/**
	 * Gets this TA's total working hours
	 * @return This TA's total working hours
	 */
	public int getTotalWorkingHours() {
		return totalWorkingHours;
	}

	/**
	 * Changes this TA's total working hours
	 * @param totalWorkingHours This TA's new total working hours
	 */
	public void setTotalWorkingHours(int totalWorkingHours) {
		this.totalWorkingHours = totalWorkingHours;
	}
	
	/**
	 * Gets this TA's salary
	 */
	public double getSalary() {
		if(this.classification.equals("Grad")){
			return 18.25 * 1.20 * (totalWorkingHours);
		}
		else
			return 18.25 * (totalWorkingHours);
	}
	
	/**
	 * Calls equals method of super class
	 */
	public boolean equals(Object otherObject){
		return super.equals(otherObject);
	}
	
	/**
	 * Gets information about this TA
	 */
	public String toString(){
		return super.toString() + "    " + String.format("%-8s%-8d%d", classification, numberOfClasses, totalWorkingHours);
	}
	
}
