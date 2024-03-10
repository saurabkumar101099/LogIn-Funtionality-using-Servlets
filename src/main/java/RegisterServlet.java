

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet {
	Connection con;
	
	public void init(ServletConfig config) {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java16", "root", "root");
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	}
	
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		String name=request.getParameter("name");
		String username=request.getParameter("username");
		String password = request.getParameter("password");
		try {
			PreparedStatement statement=con.prepareStatement("insert into user values ('"+name+"','"+username+"','"+password+"') ");
		statement.executeUpdate();
//		writer.println("Registerd SucessFully<br>");
//		writer.print("click <a href=\"/WebProject/LogIn.jsp\">Here</a>");
		writer.println("<div style=\"text-align: center; padding: 20px;\">");
		writer.println("<p style=\"font-size: 18px; color: #4caf50;\">Registered Successfully!</p>");
		writer.println("<p style=\"font-size: 16px;\">Click <a href=\"/WebProject/LogIn.jsp\" style=\"color: #007bff;\">here</a> to log in.</p>");
		writer.println("</div>");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
public void destroy() {
	try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
