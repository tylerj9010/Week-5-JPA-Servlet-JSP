package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;

/**
 * Servlet implementation class editEmpServlet
 */
@WebServlet("/editEmpServlet")
public class EditEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeHelper helper = new EmployeeHelper();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String age = request.getParameter("age");
		String position = request.getParameter("position");
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Employee empToUpdate = helper.searchForEmpById(tempId);
		empToUpdate.setFirstName(firstName);
		empToUpdate.setLastName(lastName);
		empToUpdate.setAge(Integer.parseInt(age));
		empToUpdate.setPosition(position);
		
		helper.updateEmp(empToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllEmpsServlet").forward(request, response);
	}

}
