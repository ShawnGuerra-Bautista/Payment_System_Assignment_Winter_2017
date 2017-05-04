package temporary;
import standardEmployee.Employee;
import standardEmployee.SalaryInfo;

/**
 * Shawn Guerra-Bautista (40032995)<br>
 * COMP249<br>
 * Assignment #4<br>
 * Due Date 10/04/2017<br>
 * <br>
 * This class' goal is to create part time faculty objects
 * Superclass: Employee
 * Implementations (interfaces): SalaryInfo
 * @author Shawn Guerra-Bautista
 */

public class Part_Time_Faculty extends Employee implements SalaryInfo{

	private double hourlyRate;
	private int numberOfHours;
	private int numberOfStudents;
	
	/**
	 * Parameterized constructor
	 * @param employeeIdentification This part time faculty's identification
	 * @param firstName This part time faculty's first name
	 * @param familyName This part time faculty's family name
	 * @param cityOfResidence This part time faculty's residence
	 * @param hireYear This part time faculty's hire year
	 * @param hourlyRate This part time faculty's hourly rate
	 * @param numberOfHours This part time faculty's number of hours
	 * @param numberOfStudents This part time faculty's number of students
	 */
	public Part_Time_Faculty(int employeeIdentification, String firstName, String familyName, String cityOfResidence,
			int hireYear, double hourlyRate, int numberOfHours, int numberOfStudents) {
		super(employeeIdentification, firstName, familyName, cityOfResidence, hireYear);
		this.hourlyRate = hourlyRate;
		this.numberOfHours = numberOfHours;
		this.numberOfStudents = numberOfStudents;
	}

	/**
	 * Gets this part time faculty's hourly rate
	 * @return This part time faculty's hourly rate
	 */
	public double getHourlyRate() {
		return hourlyRate;
	}

	/**
	 * Changes this part time faculty's hourly rate 
	 * @param hourlyRate This part time faculty's new hourly rate 
	 */
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	/**
	 * Gets this part time faculty's number of hours
	 * @return  This part time faculty's number of hours
	 */
	public int getNumberOfHours() {
		return numberOfHours;
	}

	/**
	 * Changes this part time faculty's number of hours
	 * @param numberOfHours This part time faculty's new number of hours
	 */
	public void setNumberOfHours(int numberOfHours) {
		this.numberOfHours = numberOfHours;
	}

	/**
	 * Gets this part time faculty's number of students
	 * @return This part time faculty's number of students
	 */
	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	/**
	 * Changes this part time faculty's 
	 * @param numberOfStudents This part time faculty's new number of students
	 */
	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}
	
	/**
	 * Gets this part time faculty's calculated salary
	 */
	public double getSalary() {
		double salary = hourlyRate * numberOfHours;
		if(numberOfStudents >= 40 && numberOfStudents <= 60){
			salary += 500;
		}
		else if(numberOfStudents > 60){
			salary += 1000;
		}
		
		return salary;
	}
	
	/**
	 * Calls equals method from super class
	 */
	public boolean equals(Object otherObject){
		return super.equals(otherObject);
	}
	
	/**
	 * Gets information about this part time faculty
	 */
	public String toString(){
		return super.toString() + "    " + String.format("%-8s%-8d%d", hourlyRate, numberOfHours, numberOfStudents);
	}
}
