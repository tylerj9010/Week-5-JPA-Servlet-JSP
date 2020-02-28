package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Department;
import model.Employee;


@WebServlet("/createNewDepartmentServlet")
public class createNewDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public createNewDepartmentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeeHelper eh = new EmployeeHelper();
		
		String DepartmentName = request.getParameter("departmentName");
		String[] selectedEmps = request.getParameterValues("allEmpsToAdd");
		List<Employee> selectedEmpsInList = new ArrayList<Employee>();
		if (selectedEmps != null && selectedEmps.length > 0) {
			for (int i = 0; i < selectedEmps.length; i++) {
				System.out.println(selectedEmps[i]);
				Employee c = eh.searchForEmpById(Integer.parseInt(selectedEmps[i]));
				selectedEmpsInList.add(c);

			}
		}

		Department d = new Department(DepartmentName );
		d.setListOfEmployees(selectedEmpsInList);
		DepartmentHelper dh = new DepartmentHelper();
		dh.insertNewDepartment(d);

		System.out.println("Success!");
		System.out.println(d.toString());

		getServletContext().getRequestDispatcher("/viewAllDepartmentsServlet").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}