package permanent;
import standardEmployee.Employee;
import standardEmployee.SalaryInfo;

/**
 * Shawn Guerra-Bautista (40032995)<br>
 * COMP249<br>
 * Assignment #4<br>
 * Due Date 10/04/2017<br>
 * <br>
 * This class' goal is to create Full time faculty objects
 * Superclass: Employee
 * Implementations (interfaces): SalaryInfo
 * @author Shawn Guerra-Bautista
 */

public class Full_Time_Faculty extends Employee implements SalaryInfo{

	private int salary;
	
	/**
	 * Parameterized constructor
	 * @param employeeIdentification This full time faculty's identification
	 * @param firstName This full time faculty's first name
	 * @param familyName This full time faculty's family name
	 * @param cityOfResidence This full time faculty's residence
	 * @param hireYear This full time faculty's year hired
	 * @param salary This full time faculty's salary
	 */
	public Full_Time_Faculty(int employeeIdentification, String firstName, String familyName, String cityOfResidence,
			int hireYear, int salary) {
		super(employeeIdentification, firstName, familyName, cityOfResidence, hireYear);
		this.salary = salary;
	}

	/**
	 * Gets this's full time faculty's salary
	 * @return This's full time faculty's salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * Changes this's full time faculty's salary
	 * @param salary This's full time faculty's new salary
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}	
	
	/**
	 * Equals method that only calls the superclass' equals method
	 */
	public boolean equals(Object otherObject){
			return super.equals(otherObject);
	}
	
	/**
	 * Gets the information about this object
	 */
	public String toString(){
		return super.toString() + "    " + String.format("%s",salary);
	}
	
}
