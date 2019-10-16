package edu.neu.csye.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author zhaocxu
 */
public class myappController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig page = getServletConfig();

        req.setAttribute("attribute2", "Attribute is RequestScope");

        HttpSession session = req.getSession();
        session.setAttribute("attribute3", "Attribute in SessionScope");

        ServletContext context = getServletContext();
        context.setAttribute("attribute4", "Attribute in Application");

        String username = context.getInitParameter("user");
        String password = context.getInitParameter("password");

        System.out.println("Username [Context Param]: "+ username);
        System.out.println("Password [Context Param]: "+ password);
    }
}
