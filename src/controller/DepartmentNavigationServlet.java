package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Department;
import model.Employee;

/**
 * Servlet implementation class DepartmentNavigationServlet
 */
@WebServlet("/departmentNavigationServlet")
public class DepartmentNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DepartmentHelper dh = new DepartmentHelper();
		String act = request.getParameter("doThisToEmp");
	
		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllDepartmentsServlet").forward(request, response);
	
		} else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Department listToDelete = dh.searchForListById(tempId);
				dh.deleteItem(listToDelete);
	
			} catch (NumberFormatException e) {
				System.out.println("Select a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllDepartmentsServlet").forward(request, response);
			}
	
		}  else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/empsForDepartmentListServlet").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
