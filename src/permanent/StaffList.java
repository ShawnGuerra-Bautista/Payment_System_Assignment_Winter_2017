package permanent;
import java.io.PrintWriter;

/**
 * Shawn Guerra-Bautista (40032995)<br>
 * COMP249<br>
 * Assignment #4<br>
 * Due Date 10/04/2017<br>
 * <br>
 * This class' goal is to create a linked list of staff members
 * @author Shawn Guerra-Bautista
 */

public class StaffList {
	/**
	 * Inner class creating nodes
	 */
	private class Node{
		private Staff staff;
		private Node next;
		
		/**
		 * Parameterized constructor
		 * @param staff This Node's staff
		 * @param next This Node's following Node
		 */
		public Node(Staff staff, Node next){
			this.staff = staff;
			this.next = next;			
		}
	}
	
	private Node head;
	
	/**
	 * Default Constructor
	 */
	public StaffList(){
		head = null;
	}
	
	/**
	 * Inserts node at the start of list
	 * @param staff Node's staff
	 */
	public void insertAtStart(Staff staff){
		head = new Node(staff, head);
	}
	
	/**
	 * Inserts node at the end of list
	 * @param staff Node's staff
	 */
	public void insetAtEnd(Staff staff){
		if(head == null){
			head = new Node(staff, head);
		}
		else{
			Node travel = head;
			while(travel.next != null){
				travel = travel.next;
			}
			travel.next = new Node(staff, travel.next);
		}
	}
	
	/**
	 * Increases salary of salary objects in every node of the list
	 */
	public void increasingSalaries(){
		Node travel = head;
		
		while(travel != null){
			travel.staff.increasingSalary();
			travel = travel.next;
		}
	}
	
	/**
	 * Writes the information of each staff in the list to the file
	 * @param fileOutput The File output
	 */
	public void writeToFile(PrintWriter fileOutput){
		Node travel = head;
		
		while(travel != null){
			fileOutput.println(travel.staff);
			
			travel = travel.next;
		}
	}
	
}
