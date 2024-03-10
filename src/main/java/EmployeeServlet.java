

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer=	response.getWriter();
		String employeeName =request.getParameter("employeeName");
		String employeeNumber =request.getParameter("employeeNumber");
		String employeeSalary=request.getParameter("employeeSalary");
		Double d= Double.parseDouble(employeeSalary);
		writer.println(d);
		writer.println(employeeName+""+employeeNumber+""+employeeSalary);
		writer.println("----------");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
