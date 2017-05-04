package driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import permanent.Full_Time_Faculty;
import permanent.Staff;
import permanent.StaffList;
import standardEmployee.Employee;
import standardEmployee.SalaryInformationList;
import temporary.Part_Time_Faculty;
import temporary.TeachingAssistant;

/**
 * Shawn Guerra-Bautista (40032995)<br>
 * COMP249<br>
 * Assignment #4<br>
 * Due Date 10/04/2017<br>
 * <br>
 * This is the demo that uses all the classes while using other methods
 * @author Shawn Guerra-Bautista
 */

public class RecordSystem {

	private static ArrayList<Employee> listOfEmployeeIDs;
	
	private static final String FTF_FILE = "Full-Time-Faculty.txt";
	private static final String PTF_FILE = "Part-Time-Faculty.txt";
	private static final String STAFF_FILE = "Staff.txt";
	private static final String TA_FILE = "TAs.txt";
	
	private static Scanner keyboardInput = new Scanner(System.in);

	/**
	 * Adds records of full time faculty
	 * @param fileInput File Input 
	 * @param fileOutput File Output
	 * @throws FileNotFoundException File Not Found Exception
	 */
	private static void addFTRecords(Scanner fileInput, PrintWriter fileOutput) throws FileNotFoundException{
		ArrayList<Full_Time_Faculty> arraylistOfFTF = new ArrayList<Full_Time_Faculty>();
		
		fileInput = new Scanner(new FileInputStream(FTF_FILE));		
		for(; fileInput.hasNext();){
			arraylistOfFTF.add(new Full_Time_Faculty(fileInput.nextInt(), fileInput.next(), fileInput.next(), fileInput.next(), fileInput.nextInt(), fileInput.nextInt()));
		}
		fileInput.close();
		
		int identification = 0;
		String firstName = null;
		String familyName = null;
		String cityOfResidence = null;
		int hireYear = 0;
		int salary = 0;
		
		System.out.println("Adding new Full-Time Faculties:");
		for(; true;){
			
			System.out.println("Please enter your ID of 7 digits (Enter -1 to exit):");
			for(boolean mismatch = true, isNumber = false; identification != -1 && mismatch == true;){
				try{ 
					mismatch = false;
					identification = keyboardInput.nextInt();
					
					if(identification != -1 && listOfEmployeeIDs.contains(new Employee(identification))){
						throw new ExistingIDException();
					}
					
					if(identification != -1 && (identification < 999999 || identification > 10000000)){
						isNumber = true;
						throw new InputMismatchException();
					}
					
				}catch(InputMismatchException e){
					if(!isNumber){
						isNumber = false;
						keyboardInput.next();
					}
					mismatch = true;
					System.out.println("Please enter your ID of 7 digits correctly:");
				}catch(ExistingIDException e){
					mismatch = true;
					System.out.println(e.getMessage());
				}
			}
			
			if(identification == -1){
				break;
			}
			
			System.out.println("Please enter your first name:");
			for(boolean mismatch = true; mismatch == true;){
				mismatch = false;
				try{ 
					firstName = keyboardInput.next();
				}catch(InputMismatchException e){
					keyboardInput.next();
					mismatch = true;
					System.out.println("Please enter your first name correctly:");
				}
			}
			
			System.out.println("Please enter your family name:");
			for(boolean mismatch = true; mismatch == true;){
				try{ 
					mismatch = false;
					familyName = keyboardInput.next();
				}catch(InputMismatchException e){
					keyboardInput.next();
					mismatch = true;
					System.out.println("Please enter your family correctly name:");
				}
			}
			
			System.out.println("Please enter your city of residence:");
			for(boolean mismatch = true; mismatch == true;){
				try{ 
					mismatch = false;
					cityOfResidence = keyboardInput.next();
				}catch(InputMismatchException e){
					keyboardInput.next();
					mismatch = true;
					System.out.println("Please enter your city of residence correctly:");
				}
			}
			
			System.out.println("Please enter the year you were hired:");
			for(boolean mismatch = true; mismatch == true;){
				try{ 
					mismatch = false;
					hireYear = keyboardInput.nextInt();
				}catch(InputMismatchException e){
					keyboardInput.next();
					mismatch = true;
					System.out.println("Please enter the year you were hired correctly:");
				}
			}
			
			System.out.println("Please enter your salary (Integer):");
			for(boolean mismatch = true; mismatch == true;){
				try{ 
					mismatch = false;
					salary = keyboardInput.nextInt();
				}catch(InputMismatchException e){
					keyboardInput.next();
					mismatch = true;
					System.out.println("Please enter your salary correctly:");
				}
			}
			
			arraylistOfFTF.add(new Full_Time_Faculty(identification, firstName, familyName, cityOfResidence, hireYear, salary));
			listOfEmployeeIDs.add(new Employee(identification));
		}
		
		
		fileOutput = new PrintWriter(new FileOutputStream(FTF_FILE));
		for(Full_Time_Faculty ftf : arraylistOfFTF){
			fileOutput.println(ftf);
		}
		fileOutput.close();
	}
	
	/**
	 * Adds part time faculty of full time faculty
	 * @param fileInput File Input 
	 * @param fileOutput File Output
	 * @throws FileNotFoundException File Not Found Exception
	 */
	private static void addPTRecords(Scanner fileInput, PrintWriter fileOutput) throws FileNotFoundException{
		ArrayList<Part_Time_Faculty> arraylistOfPTF = new ArrayList<Part_Time_Faculty>();
		
		fileInput = new Scanner(new FileInputStream(PTF_FILE));
		for(; fileInput.hasNext();){
			arraylistOfPTF.add(new Part_Time_Faculty(fileInput.nextInt(), fileInput.next(), fileInput.next(), fileInput.next(), fileInput.nextInt(),
					fileInput.nextDouble(), fileInput.nextInt(), fileInput.nextInt()));
		}
		fileInput.close();
		
		int identification = 0;
		String firstName = null;
		String familyName = null;
		String cityOfResidence = null;
		int hireYear = 0;
		double hourlyRate = 0;
		int numberOfHours = 0;
		int numberOfStudents = 0;
		
		
		System.out.println("Adding new Part-Time Faculties:");
		for(; true;){
			System.out.println("Please enter your ID of 7 digits (Enter -1 to exit):");
			for(boolean mismatch = true, isNumber = false; identification != -1 && mismatch == true;){
				try{ 
					mismatch = false;
					identification = keyboardInput.nextInt();
					if(identification != -1 && listOfEmployeeIDs.contains(new Employee(identification))){
						throw new ExistingIDException();
					}
					
					if(identification != -1 && (identification < 999999 || identification > 10000000)){
						isNumber = true;
						throw new InputMismatchException();
					}
					
				}catch(InputMismatchException e){
					if(!isNumber){
						isNumber = false;
						keyboardInput.next();
					}
					mismatch = true;
					System.out.println("Please enter your ID of 7 digits correctly:");
				}catch(ExistingIDException e){
					mismatch = true;
					System.out.println(e.getMessage());
				}
			}
			
			if(identification == -1){
				break;
			}
			
			System.out.println("Please enter your first name:");
			for(boolean mismatch = true; mismatch == true;){
				mismatch = false;
				try{ 
					firstName = keyboardInput.next();
				}catch(InputMismatchException e){
					keyboardInput.next();
					mismatch = true;
					System.out.println("Please enter your first name correctly:");
				}
			}
			
			System.out.println("Please enter your family name:");
			for(boolean mismatch = true; mismatch == true;){
				try{ 
					mismatch = false;
					familyName = keyboardInput.next();
				}catch(InputMismatchException e){
					keyboardInput.next();
					mismatch = true;
					System.out.println("Please enter your family correctly name:");
				}
			}
			
			System.out.println("Please enter your city of residence:");
			for(boolean mismatch = true; mismatch == true;){
				try{ 
					mismatch = false;
					cityOfResidence = keyboardInput.next();
				}catch(InputMismatchException e){
					keyboardInput.next();
					mismatch = true;
					System.out.println("Please enter your city of residence correctly:");
				}
			}
			
			System.out.println("Please enter the year you were hired:");
			for(boolean mismatch = true; mismatch == true;){
				try{ 
					mismatch = false;
					hireYear = keyboardInput.nextInt();
				}catch(InputMismatchException e){
					keyboardInput.next();
					mismatch = true;
					System.out.println("Please enter the year you were hired correctly:");
				}
			}
			
			System.out.println("Please enter your hourly rate:");
			for(boolean mismatch = true; mismatch == true;){
				try{ 
					mismatch = false;
					hourlyRate = keyboardInput.nextDouble();			
				}catch(InputMismatchException e){
					keyboardInput.next();
					mismatch = true;
					System.out.println("Please enter your hourly rate correctly:");
				}
			}
			
			System.out.println("Please enter your number of hours:");
			for(boolean mismatch = true; mismatch == true;){
				try{
					mismatch = false;
					numberOfHours = keyboardInput.nextInt();
				}catch(InputMismatchException e){
					keyboardInput.next();
					mismatch = true;
					System.out.println("Please enter your number of hours correctly:");
				}
			}
			
			System.out.println("Please enter your number of students:");
			for(boolean mismatch = true; mismatch == true;){
				try{
					mismatch = false;
					numberOfStudents= keyboardInput.nextInt();
				}catch(InputMismatchException e){
					keyboardInput.next();
					mismatch = true;
					System.out.println("Please enter your number of students correctly:");
				}
			}
			
			arraylistOfPTF.add(new Part_Time_Faculty(identification, firstName, familyName, cityOfResidence, hireYear, hourlyRate, numberOfHours, numberOfStudents));
			listOfEmployeeIDs.add(new Employee(identification));
		}
		
		fileOutput = new PrintWriter(new FileOutputStream(PTF_FILE));
		for(Part_Time_Faculty ptf : arraylistOfPTF){
			fileOutput.println(ptf);
		}
		fileOutput.close();
	}
	
	/**
	 * Adds records of teaching assistant
	 * @param fileInput File Input 
	 * @param fileOutput File Output
	 * @throws FileNotFoundException File Not Found Exception
	 */
	private static void addTARecords(Scanner fileInput, PrintWriter fileOutput) throws FileNotFoundException{
		ArrayList<TeachingAssistant> arraylistOfTA = new ArrayList<TeachingAssistant>();
		
		fileInput = new Scanner(new FileInputStream(TA_FILE));
		for(; fileInput.hasNext();){			
			arraylistOfTA.add(new TeachingAssistant(fileInput.nextInt(), fileInput.next(), fileInput.next(), fileInput.next(), fileInput.nextInt(),
					fileInput.next(), fileInput.nextInt(), fileInput.nextInt()));
		}
		fileInput.close();
		
		int identification = 0;
		String firstName = null;
		String familyName = null;
		String cityOfResidence = null;
		int hireYear = 0;
		String classification = null;
		int numberOfClasses = 0;
		int totalWorkingHours = 0;
		
		deletingAlum(arraylistOfTA);
		
		System.out.println("Adding new Teaching Assistants:");
		for(; true;){
			System.out.println("Please enter your ID of 7 digits (Enter -1 to exit):");
			for(boolean mismatch = true, isNumber = false; identification != -1 && mismatch == true;){
				try{ 
					mismatch = false;
					identification = keyboardInput.nextInt();
					if(identification != -1 && listOfEmployeeIDs.contains(new Employee(identification))){
						throw new ExistingIDException();
					}
					if(identification != -1 && (identification < 999999 || identification > 10000000)){
						isNumber = true;
						throw new InputMismatchException();
					}
				}catch(InputMismatchException e){
					if(!isNumber){
						isNumber = false;
						keyboardInput.next();
					}
					mismatch = true;
					System.out.println("Please enter your ID of 7 digits correctly:");
				}catch(ExistingIDException e){
					mismatch = true;
					System.out.println(e.getMessage());
				}
			}
			
			if(identification == -1){
				break;
			}
			
			System.out.println("Please enter your first name:");
			for(boolean mismatch = true; mismatch == true;){
				mismatch = false;
				try{ 
					firstName = keyboardInput.next();
				}catch(InputMismatchException e){
					keyboardInput.next();
					mismatch = true;
					System.out.println("Please enter your first name correctly:");
				}
			}
			
			System.out.println("Please enter your family name:");
			for(boolean mismatch = true; mismatch == true;){
				try{ 
					mismatch = false;
					familyName = keyboardInput.next();
				}catch(InputMismatchException e){
					keyboardInput.next();
					mismatch = true;
					System.out.println("Please enter your family correctly name:");
				}
			}
			
			System.out.println("Please enter your city of residence:");
			for(boolean mismatch = true; mismatch == true;){
				try{ 
					mismatch = false;
					cityOfResidence = keyboardInput.next();
				}catch(InputMismatchException e){
					keyboardInput.next();
					mismatch = true;
					System.out.println("Please enter your city of residence correctly:");
				}
			}
			
			System.out.println("Please enter the year you were hired:");
			for(boolean mismatch = true; mismatch == true;){
				try{ 
					mismatch = false;
					hireYear = keyboardInput.nextInt();
				}catch(InputMismatchException e){
					keyboardInput.next();
					mismatch = true;
					System.out.println("Please enter the year you were hired correctly:");
				}
			}
			
			System.out.println("Please enter your degree of studies:");
			for(boolean mismatch = true; mismatch == true;){
				try{ 
					mismatch = false;
					classification = keyboardInput.next();
				}catch(InputMismatchException e){
					keyboardInput.next();
					mismatch = true;
					System.out.println("Please enter your degree of studies correctly:");
				}
			}
			
			System.out.println("Please enter your number of classes:");
			for(boolean mismatch = true; mismatch == true;){
				try{
					mismatch = false;
					numberOfClasses = keyboardInput.nextInt();
				}catch(InputMismatchException e){
					keyboardInput.next();
					mismatch = true;
					System.out.println("Please enter your number of classes correctly:");
				}
			}
			
			System.out.println("Please enter your total working hours:");
			for(boolean mismatch = true; mismatch == true;){
				try{
					mismatch = false;
					totalWorkingHours= keyboardInput.nextInt();
				}catch(InputMismatchException e){
					keyboardInput.next();
					mismatch = true;
					System.out.println("Please enter your total working hours correctly:");
				}
			}
			
			arraylistOfTA.add(new TeachingAssistant(identification, firstName, familyName, cityOfResidence, hireYear, classification, numberOfClasses, totalWorkingHours));
			listOfEmployeeIDs.add(new Employee(identification));
		}
		
		fileOutput = new PrintWriter(new FileOutputStream(TA_FILE));
		for(TeachingAssistant ta : arraylistOfTA){
			fileOutput.println(ta);
		}
		fileOutput.close();
	}
	
	/**
	 * Fills the arraylist listOfEmployeeIDs with Employee objects
	 * @param fileInput File Input
	 */
	private static void fillingListOfIDs(Scanner fileInput){
		listOfEmployeeIDs = new ArrayList<Employee>();
		try{
			fileInput = new Scanner(new FileInputStream(FTF_FILE));
			for(; fileInput.hasNext();){
				listOfEmployeeIDs.add(new Employee(fileInput.nextInt()));
				fileInput.nextLine();
			}
		}catch(FileNotFoundException e){
			System.out.println("File not found!");
		}
		fileInput.close();
		
		try{
			fileInput = new Scanner(new FileInputStream(PTF_FILE));
			for(; fileInput.hasNext();){
				listOfEmployeeIDs.add(new Employee(fileInput.nextInt()));
				fileInput.nextLine();
			}
		}catch(FileNotFoundException e){
			System.out.println("File not found!");
		}
		fileInput.close();
		
		try{
			fileInput = new Scanner(new FileInputStream(TA_FILE));
			for(; fileInput.hasNext();){
				listOfEmployeeIDs.add(new Employee(fileInput.nextInt()));
				fileInput.nextLine();
			}
		}catch(FileNotFoundException e){
			System.out.println("File not found!");
		}
		fileInput.close();
		
		try{
			fileInput = new Scanner(new FileInputStream(STAFF_FILE));
			for(; fileInput.hasNext();){
				listOfEmployeeIDs.add(new Employee(fileInput.nextInt()));
				fileInput.nextLine();
			}
		}catch(FileNotFoundException e){
			System.out.println("File not found!");
		}
		fileInput.close();
		
	}
	
	/**
	 * Deletes the elements from the list containing an Alum student
	 * @param arraylistOfTA An array list of TAs
	 */
	private static void deletingAlum(ArrayList<TeachingAssistant> arraylistOfTA){
		Iterator<TeachingAssistant> iteratorTA = arraylistOfTA.iterator();
		for(; iteratorTA.hasNext();){
			TeachingAssistant ta = iteratorTA.next();
			
			if(ta.getClassification().equals("Alum")){
				System.out.println("The following entry will be deleted as Alums are can't be TAs.");
				System.out.println(ta);
				iteratorTA.remove();
			}
		}
	}
	
	/**
	 * Finds the term salary among the TAs and PTFs
	 * @param fileInput File Input
	 * @throws FileNotFoundException File Not Found Exception
	 */
	private static void findTermSalary(Scanner fileInput) throws FileNotFoundException{
		SalaryInformationList<TeachingAssistant> linkedlistOfTA = new SalaryInformationList<TeachingAssistant>();
		SalaryInformationList<Part_Time_Faculty> linkedlistOfPTF = new SalaryInformationList<Part_Time_Faculty>();
		
		fileInput = new Scanner(new FileInputStream(TA_FILE));
		for(; fileInput.hasNext();){
			linkedlistOfTA.insertAtStart(new TeachingAssistant(fileInput.nextInt(), fileInput.next(), fileInput.next(), fileInput.next(), fileInput.nextInt(),
					fileInput.next(), fileInput.nextInt(), fileInput.nextInt()));
		}
		fileInput.close();
		
		fileInput = new Scanner(new FileInputStream(PTF_FILE));
		for(; fileInput.hasNext();){
			linkedlistOfPTF.insertAtStart(new Part_Time_Faculty(fileInput.nextInt(), fileInput.next(), fileInput.next(), fileInput.next(), fileInput.nextInt(),
					fileInput.nextDouble(), fileInput.nextInt(), fileInput.nextInt()));
		}
		
		System.out.printf("%s%.2f\n", "\nThe total salaries of both the TAs and PTFs is ", (linkedlistOfPTF.getTotalSalary() + linkedlistOfTA.getTotalSalary()));
		fileInput.close();
	}
	
	/**
	 * Finds highest and lowest salaries among the full time faculty
	 * @param fileInput File Input
	 */
	private static void findHighest_and_Lowest_FT_Salary(Scanner fileInput){
		SalaryInformationList<Full_Time_Faculty> linkedlistOfFTF = new SalaryInformationList<Full_Time_Faculty>(); 
		
		int identification = 0;
		String firstName = null;
		String familyName = null;
		String cityOfResidence = null;
		int hireYear = 0;
		int salary = 0;
		
		for(; fileInput.hasNext();){
			identification = fileInput.nextInt();
			firstName = fileInput.next();
			familyName = fileInput.next();
			cityOfResidence = fileInput.next();
			hireYear = fileInput.nextInt();
			salary = fileInput.nextInt();
			
			linkedlistOfFTF.insertAtStart(new Full_Time_Faculty(identification, firstName, familyName, cityOfResidence, hireYear, salary));
		}
		
		double lowestSalary = linkedlistOfFTF.getLowestSalary();
		double highestSalary = linkedlistOfFTF.getHighestSalary();
		
		System.out.println("\nThe lowest salary of a Full-time faculty is " + lowestSalary + ". Here are the employees:");
		linkedlistOfFTF.displayEmployee(lowestSalary);
		System.out.println("\nThe highest salary of a Full-time faculty is " + highestSalary + ". Here are the employees:");
		linkedlistOfFTF.displayEmployee(highestSalary);
		
	}
	
	/**
	 * Increases salary of all staff members
	 * @param fileInput File Input 
	 * @param fileOutput File Output
	 * @throws FileNotFoundException File Not Found Exception
	 */
	private static void increase_Staff_Salary(Scanner fileInput, PrintWriter fileOutput) throws FileNotFoundException{
		StaffList linkedlistOfStaff = new StaffList();
		
		fileInput = new Scanner(new FileInputStream(STAFF_FILE));
		for(; fileInput.hasNext();){
			linkedlistOfStaff.insertAtStart(new Staff(fileInput.nextInt(), fileInput.next(), fileInput.next(), fileInput.next(), fileInput.nextInt(),
					fileInput.nextInt(), fileInput.next().charAt(0)));
		}
		fileInput.close();
		
		linkedlistOfStaff.increasingSalaries();
		
		fileOutput = new PrintWriter(new FileOutputStream(STAFF_FILE));
		linkedlistOfStaff.writeToFile(fileOutput);
		fileOutput.close();
	}

	public static void main(String[] args) {
		
		Scanner fileInput = null;
		PrintWriter fileOutput = null;
		
		fillingListOfIDs(fileInput);
		
		try{
			addFTRecords(fileInput, fileOutput);
		}catch(FileNotFoundException e){
			System.out.println("File not found!");
		}
		
		try{
			addPTRecords(fileInput, fileOutput);
		}catch(FileNotFoundException e){
			System.out.println("File not found!");
		}
		
		try{
			addTARecords(fileInput, fileOutput);
		}catch(FileNotFoundException e){
			System.out.println("File not found!");
		}
		
		try{
			findTermSalary(fileInput);
		}catch(FileNotFoundException e){
			System.out.println("File not found!");
		}
		
		try{
			fileInput = new Scanner(new FileInputStream(FTF_FILE));
			findHighest_and_Lowest_FT_Salary(fileInput);
		}catch(FileNotFoundException e){
			System.out.println("File not found!");
		}
		
		try{
			increase_Staff_Salary(fileInput, fileOutput);
		}catch(FileNotFoundException e){
			System.out.println("File not found!");
		}

		keyboardInput.close();
	}
}
