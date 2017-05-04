package permanent;
import standardEmployee.Employee;
import standardEmployee.SalaryInfo;

/**
 * Shawn Guerra-Bautista (40032995)<br>
 * COMP249<br>
 * Assignment #4<br>
 * Due Date 10/04/2017<br>
 * <br>
 * This class' goal is to create Staff objects
 * Superclass: Employee
 * Implementations (interfaces): SalaryInfo
 * @author Shawn Guerra-Bautista
 */

public class Staff extends Employee implements SalaryInfo{

	private int salary;
	private char performanceCode;
	

	/**
	 * Parameterized constructor
	 * @param employeeIdentification This staff's identification
	 * @param firstName This staff's first name
	 * @param familyName This staff's family name
	 * @param cityOfResidence This staff's residence
	 * @param hireYear This staff's hire year
	 * @param salary This staff's salary
	 * @param performanceCode This staff's performance code
	 */
	public Staff(int employeeIdentification, String firstName, String familyName, String cityOfResidence,
			int hireYear, int salary, char performanceCode) {
		super(employeeIdentification, firstName, familyName, cityOfResidence, hireYear);
		this.salary = salary;
		this.performanceCode = performanceCode;
	}

	/**
	 * Gets this staff's salary
	 * @return this staff's salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * Changes this staff's salary
	 * @param salary This staff's new salary
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}

	/**
	 * Gets this staff's performance code
	 * @return This staff's performance code
	 */
	public char getPerformanceCode() {
		return performanceCode;
	}

	/**
	 * Changes this staff's performance code
	 * @param performanceCode This staff's new performance code
	 */
	public void setPerformanceCode(char performanceCode) {
		this.performanceCode = performanceCode;
	}
	
	/**
	 * Increases this staff's salary based on their performance code
	 */
	public void increasingSalary(){
		switch(this.performanceCode){
			case 'A':{
				this.salary = (int)(salary * 1.08);
				break;
			}
			case 'B':{
				this.salary = (int)(salary * 1.06);
				break;
			}
			case 'C':{
				this.salary = (int)(salary * 1.03);
				break;
			}
			case 'D':{
				this.salary = (int)(salary * 1.01);
				break;
			}
			case 'E':{
				break;
			}
		}
		this.performanceCode = 'E';
	}
	
	/**
	 * Calls equals method from parent
	 */
	public boolean equals(Object otherObject){
		return super.equals(otherObject);
	}
	
	/**
	 * Gets information about this object
	 */
	public String toString(){
		return super.toString() + "    " + String.format("%-8s%c\n", salary, performanceCode);
	}
	
}
