

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
public class WelcomeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		out.println("welcome");
		out.println("<h3>hello</h3>");
		out.println(" <font color=\"blue\">This text is in blue color.</font>");

	}



}
