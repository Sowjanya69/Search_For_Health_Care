
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Add_Service_Categories_Servlet
 */
@WebServlet("/Add_Service_Categories_Servlet")
public class Add_Service_Categories_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int serviceid=Integer.parseInt(request.getParameter("serviceid"));
		String servicename=request.getParameter("servicename");
		String servicetype=request.getParameter("servicetype");
		HttpSession session=request.getSession();
		boolean flag=false;
		//JDBC code for connecting mysql
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/search_for_health_care3","root","16f01@0413R");
			String query = "INSERT INTO service_categories VALUES(?,?,?)";
			PreparedStatement ptmt = con.prepareStatement(query);
			ptmt.setInt(1, (int)serviceid);
			ptmt.setString(2, servicename);
			ptmt.setString(3,servicetype);
			ptmt.executeUpdate();
			response.sendRedirect("./Admin_Action.html");
		}
		catch(Exception p)
		{
			out.print(p);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}