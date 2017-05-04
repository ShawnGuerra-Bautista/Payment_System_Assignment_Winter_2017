package standardEmployee;

/**
 * Shawn Guerra-Bautista (40032995)<br>
 * COMP249<br>
 * Assignment #4<br>
 * Due Date 10/04/2017<br>
 * <br>
 * This class is to create a linked list containing objects whose class extends the SalaryInfo interface
 * @author Shawn Guerra-Bautista
 */

public class SalaryInformationList <T extends SalaryInfo>{
	
	/**
	 * Inner class is to create nodes
	 */
	private class Node{
		private T typeObject;
		private Node next;
		
		/**
		 * Parameterized constructor
		 * @param typeObject This Node's type object
		 * @param next This node's following Node
		 */
		public Node(T typeObject, Node next){
			this.typeObject = typeObject;
			this.next = next;
		}
	}
	
	private Node head;
	
	/**
	 * Default Constructor
	 */
	public SalaryInformationList(){
		head = null;
	}
	
	/**
	 * Inserts node at the start of list
	 * @param typeObject Node's type object
	 */
	public void insertAtStart(T typeObject){
		head = new Node(typeObject, head);
	}
	
	/**
	 * Inserts node at the end of list
	 * @param typeObject Node's type object
	 */
	public void insetAtEnd(T typeObject){
		if(head == null){
			head = new Node(typeObject, head);
		}
		else{
			Node travel = head;
			while(travel.next != null){
				travel = travel.next;
			}
			travel.next = new Node(typeObject, travel.next);
		}
	}
	
	/**
	 * Gets total salary of all objects in list
	 * @return total salary of all objects in list
	 */
	public double getTotalSalary(){
		double totalSalary = 0;
		Node travel = head;
		while(travel != null){
			totalSalary += travel.typeObject.getSalary();
			travel = travel.next;
		}
		return totalSalary;
	}
	
	/**
	 * Prints information of an object that corresponds to the passed salary
	 * @param salary Salary corresponding to the object being printed
	 */
	public void displayEmployee(double salary){
		Node travel = head;
		while(travel != null){
			if(travel.typeObject.getSalary() == salary){
				System.out.println(travel.typeObject.toString());
			}
			travel = travel.next;
		}
	}
	
	/**
	 * Gets lowest salary in list
	 * @return Value of lowest salary
	 */
	public double getLowestSalary(){
		if(head == null){
			return 0;
		}
		
		Node travel = head;
		double lowestSalary = travel.typeObject.getSalary();
		while(travel.next != null){
			if(travel.next.typeObject.getSalary() < lowestSalary){
				lowestSalary = travel.typeObject.getSalary();
			}
			travel = travel.next;
		}
		return lowestSalary;
	}
	
	/**
	 * Gets highest salary in list
	 * @return Value of highest salary
	 */
	public double getHighestSalary(){
		if(head == null){
			return 0;
		}
		
		Node travel = head;
		double highestSalary = travel.typeObject.getSalary();
		while(travel.next != null){
			if(travel.next.typeObject.getSalary() > highestSalary){
				highestSalary = travel.typeObject.getSalary();
			}
			travel = travel.next;
		}
		return highestSalary;
	}
}