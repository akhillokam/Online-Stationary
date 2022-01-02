import java.util.*;
import java.sql.*;
import javax.sql.*;
import java.lang.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
public class Reg extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		try{
		response.setContentType("Text/html");
		PrintWriter out= response.getWriter();
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","akhil1","akhil1");
		Statement stmt=con.createStatement();
		out.println("<html><head> <h1> status :</h1><title>Registratio status</title></head><body>");
		String username=request.getParameter("uname");
		out.println("1");
		String email=request.getParameter("email");
		out.println("2");
		String password=request.getParameter("pwd");
		out.println("3");
		String cpassword=request.getParameter("cpwd");
		out.println("3");
		int year=Integer.parseInt(request.getParameter("year"));
		out.println("4");
		String gender=request.getParameter("gen");
		out.println("5");
		int mob=Integer.parseInt(request.getParameter("mobile"));
		String sql="insert into REGLOG values('"+username+",'"+email+",'"+password+",'"+cpassword+",'"+year+",'"+gender+",'"+mob+")";
		out.println("7");
		int i=stmt.executeUpdate(sql);
		out.println("8");
		if(i!=0)
		{
			out.println("<H1> REGISTERED SUCCESSFULLY</H1>");
		}
		else
		{
			response.sendRedirect("./html/regsucc.html");
		}
		out.println("</body></html>");

		}catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
		}
		}
		catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
		}
	}
}
