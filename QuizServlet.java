

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QuizServlet
 */
public class QuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int cnt=0;
		String c="", a="", p="";
		c=request.getParameter("coffee");
		a=request.getParameter("area");
		p=request.getParameter("population");
		if(c.equals("kn"))
		{
			out.println("your first answer is correct!<br/>");
			cnt++;
		}
		else
			out.println("The correct answer for the first question is karnataka <br/>");
		
		
		
		if(c.equals("rj"))
		{
			out.println("your first answer is correct!<br/>");
			cnt++;
		}
		else
			out.println("The correct answer for the first question is rajasthan <br/>");
		
		
		if(c.equals("up"))
		{
			out.println("your first answer is correct!<br/>");
			cnt++;
		}
		else
			out.println("The correct answer for the first question is uttar pradesh <br/>");
		
		if(cnt==3)
			out.println("<h1>Congratulation!</hr>)");
		else
			out.println("<h1>you have scored "+cnt+" points. </h1>");
		
		}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
