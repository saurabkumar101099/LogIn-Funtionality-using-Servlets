

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogInServlet
 */
@SuppressWarnings("serial")
public class LogInServlet extends HttpServlet {
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
	PrintWriter writer=response.getWriter();
	response.setContentType("text/html");
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	try {
		PreparedStatement preparedStatement=con.prepareStatement("select * from user where username='"+username+"' and password ='"+password+"'");
	ResultSet resultSet=preparedStatement.executeQuery();
//	if(resultSet.next()) {
//		String name=resultSet.getString("name");
//		writer.println("welcome"+name);
//		writer.println("<br>CLick <a href=\"/WebProject/Login.jsp\">Here</a>");
//	}
//	else {
//		writer.println("failure");
//		writer.println("<br>CLick <a href=\"/WebProject/Login.jsp\">Here</a>");
//	
//	}
	
	if (resultSet.next()) {
	    String name = resultSet.getString("name");
	    writer.println("<div style=\"text-align: center; padding: 20px;\">");
	    writer.println("<p style=\"font-size: 18px; color: #4caf50;\">Welcome, " + name + "!</p>");
	    writer.println("<p style=\"font-size: 16px;\">Click <a href=\"/WebProject/LogIn.jsp\" style=\"color: #007bff;\">here</a> to continue.</p>");
	    writer.println("</div>");
	} else {
	    writer.println("<div style=\"text-align: center; padding: 20px;\">");
	    writer.println("<p style=\"font-size: 18px; color: #ff4444;\">Login failed. Please check your credentials.</p>");
	    writer.println("<p style=\"font-size: 16px;\">Click <a href=\"/WebProject/LogIn.jsp\" style=\"color: #007bff;\">here</a> to try again.</p>");
	    writer.println("</div>");
	}

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
