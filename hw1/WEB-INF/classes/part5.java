import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;
import java.io.IOException;

public class part5 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
		Map<String, String[]> parameterNames = request.getParameterMap();
		Set<String> keys = parameterNames.keySet();

		String docType = "<!DOCTYPE html>";
		out.println(docType);
		out.println("<html>");
		out.println("<head>");
		out.println("<title>part5</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>Parameter Name");
        out.println("<th>User Input");

		for(String key : keys) {
			if (!key.equals("submit")) {
				out.println("<tr><td>" + key);
				out.println("<td>" + request.getParameter(key));
			}
		}

		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request, response);
	}
}