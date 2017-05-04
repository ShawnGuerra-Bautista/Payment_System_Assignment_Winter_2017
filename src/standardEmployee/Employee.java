package standardEmployee;

/**
 * Shawn Guerra-Bautista (40032995)<br>
 * COMP249<br>
 * Assignment #4<br>
 * Due Date 10/04/2017<br>
 * <br>
 * This class' goal is to create Employee objects
 * Implementations (interfaces): Ordered
 * @author Shawn Guerra-Bautista
 */

public class Employee implements Ordered{
	
	protected int employeeIdentification;
	protected String firstName;
	protected String familyName;
	protected String cityOfResidence;
	protected int hireYear;
	
	/**
	 * Parameterized constructor
	 * @param employeeIdentification This employee's identification
	 */
	public Employee(int employeeIdentification){
		this.employeeIdentification = employeeIdentification;
		firstName = null;
		familyName = null;
		cityOfResidence = null;
		hireYear = 0;
	}
	
	/**
	 * Parameterized constructor
	 * @param employeeIdentification This employee's identification
	 * @param firstName This employee's first name
	 * @param familyName This employee's family name
	 * @param cityOfResidence This employee's residence
	 * @param hireYear This employee's hire year
	 */
	public Employee(int employeeIdentification, String firstName, String familyName, String cityOfResidence, int hireYear) {
		this.employeeIdentification = employeeIdentification;
		this.firstName = firstName;
		this.familyName = familyName;
		this.cityOfResidence = cityOfResidence;
		this.hireYear = hireYear;
	}

	/**
	 * Gets this employee's identification
	 * @return This employee's identification
	 */
	public int getEmployeeIdentification() {
		return employeeIdentification;
	}

	/**
	 * Changes this employee's identification
	 * @param employeeIdentification This employee's new identification
	 */
	public void setEmployeeIdentification(int employeeIdentification) {
		this.employeeIdentification = employeeIdentification;
	}

	/**
	 * Gets this employee's first name
	 * @return This employee's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Changes this employee's first name
	 * @param firstName This employee's new  first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets this employee's family name
	 * @return This employee's family name
	 */
	public String getFamilyName() {
		return familyName;
	}

	/**
	 * Changes this employee's family name
	 * @param familyName This employee's new family name
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	/**
	 * Gets this employee's family name
	 * @return This employee's family name
	 */
	public String getCityOfResidence() {
		return cityOfResidence;
	}

	/**
	 * Changes this employee's residence
	 * @param cityOfResidence This employee's residence
	 */
	public void setCityOfResidence(String cityOfResidence) {
		this.cityOfResidence = cityOfResidence;
	}

	/**
	 * Gets this employee's hire year
	 * @return This employee's hire year
	 */
	public int getHireYear() {
		return hireYear;
	}

	/**
	 * Changes this employee's hire year
	 * @param hireYear This employee's new hire year
	 */
	public void setHireYear(int hireYear) {
		this.hireYear = hireYear;
	}
	

	/**
	 * Checks whether this employee precedes another employee hire year wise
	 * @param otherObject Another object
	 */
	public boolean precedes(Object otherObject) {
		if(otherObject == null || !(otherObject instanceof Employee)){
			return false;
		}
		else{
			Employee otherEmployee = (Employee)otherObject;
			return(this.hireYear < otherEmployee.hireYear);
		}
	}

	/**
	 * Checks whether this employee follows another employee hire year wise
	 * @param otherObject Another object 
	 */
	public boolean follows(Object otherObject) {
		if(otherObject == null || !(otherObject instanceof Employee)){
			return false;
		}
		else{
			Employee otherEmployee = (Employee)otherObject;
			return(this.hireYear > otherEmployee.hireYear);
		}
	}
	
	/**
	 * Checks whether this employee has the same ID as another employee
	 */
	public boolean equals(Object otherObject){
		if(otherObject == null || !(otherObject instanceof Employee)){
			return false;
		}
		else{
			Employee otherEmployee = (Employee) otherObject;
			return(employeeIdentification == otherEmployee.employeeIdentification);
		}
	}
	
	/**
	 * Gets information about this employee
	 */
	public String toString(){
		return String.format("%-8d%-8s%-16s%-16s%d", employeeIdentification, firstName, familyName, cityOfResidence, hireYear);
	}
	
}
