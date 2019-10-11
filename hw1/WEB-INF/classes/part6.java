
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;
import java.io.IOException;

public class part6 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int number = Integer.valueOf(request.getParameter("children"));

		String docType = "<!DOCTYPE html>";
		out.println(docType);
		out.println("<html>");
		out.println("<head>");
		out.println("<title>part6</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form method='POST' action='part6'>");
		for(int i = 1; i <= number; i++) {
			out.println("<label>Please enter the name of child number " + i + "</label><br/>");
			out.println("<input type='text' name=child'"+ i +"'><br/>");
		}
		out.println("<input type='submit' name='submit' value='Submit Query'>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Map<String, String[]> parameterNames = request.getParameterMap();
		Set<String> keys = parameterNames.keySet();

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String docType = "<!DOCTYPE html>";
		out.println(docType);
		out.println("<html>");
		out.println("<head>");
		out.println("<title>part6</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form>");
		out.println("Your children's names are:<br/>");
		for(String key : keys) {
			if (!key.equals("submit")) {
				out.println(parameterNames.get(key)[0] + "<br/>");
			}
		}
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
}