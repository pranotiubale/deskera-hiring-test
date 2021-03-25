package deskera;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.TimeZone;

public class EmployeesManager {

	/**
	 * Implement EmployeesManager to manage all employees of a company
	 *
	 */
	private Collection<Employee> employees;

	public EmployeesManager() {
		this.employees = new ArrayList<Employee>(1);
	}

	/**
	 * Adds an Employee
	 *
	 * @param employee
	 * @return
	 */
	String addEmployee(Employee employee) {
		// TODO - implement this
		this.employees.add(employee);
		return "Employee is added";
	}

	/**
	 * Finds an Employee
	 *
	 * @param employeeId
	 * @return
	 */
	Employee findEmployee(String employeeId) {
		// TODO - implement this
		for (Employee employee : this.employees) {
			if (employee.getEmployeeId() == employeeId) {
				System.out.println("Employee found: " + employee.toString());
				return employee;
			}

		}
		System.out.print("Employee Not found for emp id " + employeeId);
		return null;
	}

	/**
	 * Find all Employee who are older than X years
	 * 
	 * @param years
	 * @return
	 */
	Collection<Employee> findEmployee(int years) {
		Collection<Employee> returnEmp = new ArrayList<Employee>(1);;
		for (Employee employee : this.employees) {
			if (employee.getAgeInYears()> years) {
				System.out.println(employee.toString());
				returnEmp.add(employee);
			}

		}
		return returnEmp;
	}

	/**
	 * Removes an employee
	 *
	 * @param employeeId
	 * @return
	 */
	boolean removeEmployee(String employeeId) {
		// TODO - implement this
		return this.employees.removeIf(emp -> emp.getEmployeeId() == (employeeId));
	}

	/**
	 * Lists all Employees
	 *
	 * @return
	 */
	Collection<Employee> listEmployees() {
		// TODO - implement this
		for (Employee employee : this.employees) {
			System.out.println(employee.toString());
		}
		return this.employees;
	}
}

class Employee {

	private int ageInYears;
	private int ageInMonths;
	private String birthDate;
	private String firstName;
	private String lastName;

	private String employeeId;

	public Employee(String fullName, String birthDate) {
		// TODO - implement this
		this.firstName = fullName.substring(0, fullName.lastIndexOf(" "));
		this.lastName = fullName.substring(fullName.lastIndexOf(" ") + 1, fullName.length());
		this.employeeId = String.valueOf(System.currentTimeMillis());

		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		try {
			this.birthDate = simpleDateFormat.parse(birthDate).toString();
			
			Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
			calendar.setTime(simpleDateFormat.parse(birthDate));
			this.ageInYears = Year.now().getValue() - calendar.get(Calendar.YEAR);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int getAgeInYears() {
		return ageInYears;
	}

	public int getAgeInMonths() {
		return ageInMonths;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public String getBirthDate() {
		return birthDate;
	}

	@Override
	public String toString() {
		return String.format(" Name: " + firstName + " " + lastName);
	}
}
