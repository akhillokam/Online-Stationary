import java.util.*;
import java.sql.*;
import javax.sql.*;
import java.lang.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
public class LoginValidate extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		try{
		response.setContentType("Text/html");
		PrintWriter out= response.getWriter();
	HttpSession session = request.getSession(true);
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			if((username.equals("admin"))&&(password.equals("password")))
			{
				response.sendRedirect("./html/logsuc.html");
			}
			else
			{
				response.sendRedirect("./html/login.html");
			}
		}
		catch(Exception e)
		{
			 e.printStackTrace();
		}
	}
}
