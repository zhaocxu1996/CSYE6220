import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class part7 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String docType = "<!DOCTYPE html>";
        HttpSession session = request.getSession();
        out.println(docType);
        out.println("<html>");
        out.println("<head>");
        out.println("<title>part7</title>");
        out.println("</head>");
        out.println("<body>");
        
        String pageNumber = request.getParameter("p-number");
        if (pageNumber.equals("1")) {
            String page = request.getParameter("page");
            if (page.equals("View Cart")) {
                ViewCart(out, session);
            } else if (page.equals("Go to Books Page")) {
                Books(out);
            } else if (page.equals("Go to Music Page")) {
                Music(out);
            } else if (page.equals("Go to Computers Page")) {
                Computers(out);
            } 
        } else if (pageNumber.equals("2")) {
            Map<String,String[]> parameterNames = request.getParameterMap();
            Set<String> keys = parameterNames.keySet();
            String item = null;
            for (String key : keys) {
                if (!key.equals("p-number")) {
                    item = key;
                    break;
                }
            }
            session.removeAttribute(item);
            ViewCart(out, session);
        }

        out.println("</body>");
		out.println("</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        String docType = "<!DOCTYPE html>";
        out.println(docType);
        out.println("<html>");
        out.println("<head>");
        out.println("<title>part7</title>");
        out.println("</head>");
        out.println("<body>");
        Map<String, String[]> parameterNames = request.getParameterMap();
        if(parameterNames.containsKey("page")) {
            String page = parameterNames.get("page")[0];
            if (page.equals("Books")) {
                Books(out);
            } else if (page.equals("Music")) {
                Music(out);
            } else if (page.equals("Computers")) {
                Computers(out);
            }
        } else {
            out.println("<h1>The following item has been added to your shopping cart successfully</h1>");
            Set<String> keys = parameterNames.keySet();
            for(String key : keys) {
                if (!key.equals("submit") && !key.equals("page")) {
                    String[] values = parameterNames.get(key);
                    for (int i = 0; i < values.length; i++) {
                        if (session.getAttribute(values[i])!=null) {
                            int quantity = (int) session.getAttribute(values[i]);
                            session.setAttribute(values[i], ++quantity);
                        } else {
                            session.setAttribute(values[i], 1);
                        }
                        out.println("<p>- "+values[i]+"</p><br/>");
                    }
                }
            }
            out.println("<form method='GET' action='part7'>");
            out.println("<input type='submit' name='page' value='View Cart'><br/>");
            out.println("<input type='submit' name='page' value='Go to Books Page'><br/>");
            out.println("<input type='submit' name='page' value='Go to Music Page'><br/>");
            out.println("<input type='submit' name='page' value='Go to Computers Page'><br/>");
            out.println("<input type='hidden' name='p-number' value='1' />");
            out.println("</form>");
        }

        
        out.println("</body>");
		out.println("</html>");
    }

    private void Books(PrintWriter out) {
        out.println("<h1>Shop for Books</h1>");
        out.println("<form method='POST' action='part7'>");
        out.println("<input type='submit' name='page' value='Books'><br/>");
        out.println("<input type='submit' name='page' value='Music'><br/>");
        out.println("<input type='submit' name='page' value='Computers'><br/>");
        out.println("<input type='checkbox' name='book' value='servlet'>Java Servlet Programming<br/>");
        out.println("<input type='checkbox' name='book' value='oracle'>Oracle Database Programming<br/>");
        out.println("<input type='checkbox' name='book' value='uml'>System Analysis and Design With UML<br/>");
        out.println("<input type='checkbox' name='book' value='software'>Object Oriented Software Engineering<br/>");
        out.println("<input type='checkbox' name='book' value='web'>Java Web ServicesS<br/>");
        out.println("<input type='submit' name='submit' value='Add to Cart'>");
        out.println("</form>");
    }

    private void Music(PrintWriter out) {
        out.println("<h1>Shop for Music</h1>");
        out.println("<form method='POST' action='part7'>");
        out.println("<input type='submit' name='page' value='Books'><br/>");
        out.println("<input type='submit' name='page' value='Music'><br/>");
        out.println("<input type='submit' name='page' value='Computers'><br/>");
        out.println("<input type='checkbox' name='music' value='madonna'>Madonna<br/>");
        out.println("<input type='checkbox' name='music' value='spears'>Spears<br/>");
        out.println("<input type='checkbox' name='music' value='justin'>Justin<br/>");
        out.println("<input type='checkbox' name='music' value='nelly'>Nelly<br/>");
        out.println("<input type='checkbox' name='music' value='kanye'>Kanye<br/>");
        out.println("<input type='submit' name='submit' value='Add to Cart'>");
        out.println("</form>");
    }

    private void Computers(PrintWriter out) {
        out.println("<h1>Shop for Computers</h1>");
        out.println("<form method='POST' action='part7'>");
        out.println("<input type='submit' name='page' value='Books'><br/>");
        out.println("<input type='submit' name='page' value='Music'><br/>");
        out.println("<input type='submit' name='page' value='Computers'><br/>");
        out.println("<input type='checkbox' name='computer' value='apple'>Apple<br/>");
        out.println("<input type='checkbox' name='computer' value='asus'>Asus<br/>");
        out.println("<input type='checkbox' name='computer' value='hp'>HP<br/>");
        out.println("<input type='checkbox' name='computer' value='toshiba'>Toshiba<br/>");
        out.println("<input type='checkbox' name='computer' value='sony'>Sony<br/>");
        out.println("<input type='submit' name='submit' value='Add to Cart'>");
        out.println("</form>");
    }

    private void ViewCart(PrintWriter out, HttpSession session) {
        out.println("<form method='GET' action='part7'>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<th>Item");
        out.println("<th>Quantities");
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attribute = attributeNames.nextElement();
            int quantity = (int) session.getAttribute(attribute);
            out.println("<tr><td>" + attribute + "<td>" + quantity + "<td><input type='submit' value='delete' name='" + attribute + "'>");
        }
        out.println("</table>");
        out.println("<input type='hidden' name='p-number' value='2' />");
        out.println("</form>");
    }
}