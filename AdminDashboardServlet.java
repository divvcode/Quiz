

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminDashboardServlet
 */
public class AdminDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDashboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the list of quizzes from the database
        List<Quiz> quizzes = QuizDAO.getQuizzes();

        // Print the admin dashboard to the response
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Admin Dashboard</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Admin Dashboard</h1>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<th>Quiz Name</th>");
        out.println("<th>Number of Questions</th>");
        out.println("<th>Action</th>");
        out.println("</tr>");
        for (Quiz quiz : quizzes) {
            out.println("<tr>");
            out.println("<td>" + quiz.getName() + "</td>");
            out.println("<td>" + quiz.getNumberOfQuestions() + "</td>");
            out.println("<td><a href='editQuiz?id=" + quiz.getId() + "'>Edit</a> | <a href='deleteQuiz?id=" + quiz.getId() + "'>Delete</a></td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }

}