import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.io.IOException;

public class part4 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        Enumeration parameterNames = request.getParameterNames();

		String docType = "<!DOCTYPE html>";
		out.println(docType);
		out.println("<html>");
		out.println("<head>");
		out.println("<title>part4</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>Parameter Name");
        out.println("<th>User Input");

        while(parameterNames.hasMoreElements()) {
			String parameterName = (String)parameterNames.nextElement();
			if (!parameterName.equals("submit")) {
				out.println("<tr><td>" + parameterName);
				out.println("<td>" + request.getParameter(parameterName));
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