package deskera;

class Main {
    public static void main(String[] args) {
//        System.out.println("Hello, World!"); 
    	EmployeesManager em = new EmployeesManager();
    	
    	// Employees
    	Employee e1 = new Employee("Pranoti Ubale", "09-06-1992");
    	Employee e2 = new Employee("Akash Bavale", "21-09-1991");
    	
    	// Add Employees
    	em.addEmployee(e1);
    	em.addEmployee(e2);
    	
    	// Find Employees
    	em.findEmployee(e1.getEmployeeId()); // finds Akash
    	
    	// List All Employees
    	System.out.println("");
    	System.out.println("List of All Employees:");
    	em.listEmployees();
    	
    	// Remove
    	em.removeEmployee(e2.getEmployeeId()); // removes Akash
    	

    	// List All Employees
    	System.out.println("");
    	System.out.println("List of All Employees after removing employee:");
    	em.listEmployees();
    }
}