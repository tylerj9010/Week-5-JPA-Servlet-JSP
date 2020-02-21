import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import controller.EmployeeHelper;
import model.Employee;

public class StartProgram {
	
	static Scanner scan = new Scanner(System.in);
	static EmployeeHelper empHelper = new EmployeeHelper();
	

	private static void addEmp() {
		System.out.println("Enter employee's first Name: ");
		String fName = scan.nextLine();
		System.out.println("Enter employee's last Name: ");
		String lName = scan.nextLine();
		System.out.println("Enter employee's age: ");
		int age = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Enter employee's position: ");
		String position = scan.nextLine();
		Employee toAdd = new Employee(fName, lName, age, position);
		empHelper.addNewEmployee(toAdd);
	}
	
	private static void viewEmps() {
		List<Employee> allEmps = empHelper.showAllEmps();
		for(Employee singleEmp: allEmps) {
			System.out.println(singleEmp.returnEmpDetails());
		}
	}
	
	private static void deleteEmp() {
		System.out.println("Enter the first name of the employee: ");
		String fName = scan.nextLine();
		System.out.println("Enter the last name of the employee: ");
		String lName = scan.nextLine();
		List<Employee> foundEmps = empHelper.searchForEmp(fName, lName);
		
		if (!foundEmps.isEmpty()) {
			System.out.println("Found Results.");
			for (Employee emp : foundEmps) {
				System.out.println(emp.getId() + " : " + emp.returnEmpDetails());
			}
			System.out.print("Which ID to delete: ");
			int idToDelete = scan.nextInt();
		
		
		Employee toDelete = empHelper.searchForEmpById(idToDelete);
		empHelper.deleteEmp(toDelete);
		} else {
			System.out.println("No results found");
		}

	}
	
	private static void editEmp() {
		System.out.println("Enter the first name of the employee: ");
		String fName = scan.nextLine();
		System.out.println("Enter the last name of the employee: ");
		String lName = scan.nextLine();
		List<Employee> foundEmps = empHelper.searchForEmp(fName, lName);
		
	
		if (!foundEmps.isEmpty()) {
			System.out.println("Found Results.");
			for (Employee emp : foundEmps) {
				System.out.println(emp.getId() + " : " + emp.returnEmpDetails());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = scan.nextInt();

			Employee toEdit = empHelper.searchForEmpById(idToEdit);
			System.out.println("Found!");
			System.out.println(toEdit.returnEmpDetails());
			System.out.println("- 1) Update first name");
			System.out.println("- 2) Update last name");
			System.out.println("- 3) Update age");
			System.out.println("- 4) Update position");
			int update = scan.nextInt();
			scan.nextLine();
			String updatedInfo;
			
			switch (update) {
				case 1:
						System.out.print("Updated first name: ");
						updatedInfo = scan.nextLine();
						toEdit.setFirstName(updatedInfo);
						break;
				case 2:
						System.out.print("Updated last name: ");
						updatedInfo = scan.nextLine();
						toEdit.setLastName(updatedInfo);
						break;
				case 3:
						System.out.print("Updated age: ");
						int updatedAge = scan.nextInt();
						scan.nextLine();
						toEdit.setAge(updatedAge);
						break;
				case 4:
						System.out.print("Updated position: ");
						updatedInfo = scan.nextLine();
						toEdit.setPosition(updatedInfo);
						break;
				default:
						System.out.print("Not an option: ");
						break;
					
			}

			empHelper.updateEmp(toEdit);

		} else {
			System.out.println("No results found");
		}

	}

		public static void main(String[] args) {
			run();
		}
		
		public static void run() {
			boolean goAgain = true;
			System.out.println("--- Employee Manager ---");
			while (goAgain) {
				System.out.println("- Enter an option to continue:");
				System.out.println("- 1) Add employee");
				System.out.println("- 2) Edit employee");
				System.out.println("- 3) Delete employee");
				System.out.println("- 4) View all employees");
				System.out.println("- 5) Exit");
				System.out.print("- :");
				
				int select = scan.nextInt();
				scan.nextLine();
				
				switch (select) {
					case 1: 
							addEmp();
							break;
					case 2: 
							editEmp();
							break;
					case 3: 
							deleteEmp();
							break;
					case 4: 
							viewEmps();
							break;
					default:
							empHelper.cleanUp();
							System.out.println("   Goodbye!   ");
							goAgain = false;
							break;
				
				}
			}
		}
}
















