

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String n=request.getParameter("t1");
		String pwd=request.getParameter("t2");
		PrintWriter Out=response.getWriter();
		response.setContentType("text/html");
		if(n.equals("Admin") && pwd.equals("1234")) {
			response.sendRedirect("Success.jsp");
		}
		else
		{
			Out.println("Sorry! username or password incorrect....Try Again");
			RequestDispatcher rd=request.getRequestDispatcher("input.jsp");
			rd.include(request, response);
		}
	}

}
