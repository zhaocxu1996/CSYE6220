import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;

public class part3 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm");
        String uploadYourPicture = request.getParameter("upload");
        String gender = request.getParameter("gender");
        String selectCountry = request.getParameter("country");
        String hobby = request.getParameter("hobby");
        String address = request.getParameter("address");

		String docType = "<!DOCTYPE html>";
		out.println(docType);
		out.println("<html>");
		out.println("<head>");
		out.println("<title>part3</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>Parameter Name");
        out.println("<th>User Input");

        out.println("<tr>");
		out.println("<th>Email:");
        out.println("<th>"+email);
        out.println("<tr>");
		out.println("<th>Password:");
        out.println("<th>"+password);		
        out.println("<tr>");
		out.println("<th>Confirm Password:");
        out.println("<th>"+confirmPassword);	
        out.println("<tr>");
		out.println("<th>Upload Your Picture:");
        out.println("<th>"+uploadYourPicture);	
        out.println("<tr>");
		out.println("<th>Gender:");
        out.println("<th>"+gender);	
        out.println("<tr>");
		out.println("<th>Select Country:");
        out.println("<th>"+selectCountry);	
        out.println("<tr>");
		out.println("<th>Hobby:");
        out.println("<th>"+hobby);	
        out.println("<tr>");
		out.println("<th>Address:");
        out.println("<th>"+address);	

		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request, response);
	}
}