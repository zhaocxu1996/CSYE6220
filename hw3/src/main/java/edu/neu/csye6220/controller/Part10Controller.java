package edu.neu.csye6220.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Part10Controller extends AbstractController {
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String submit = httpServletRequest.getParameter("submit");
        String add = httpServletRequest.getParameter("add");
        if (submit != null) {
            int quantity = Integer.valueOf(httpServletRequest.getParameter("quantity"));
            return new ModelAndView("book-details").addObject("quantity", quantity);
        } else if (add != null) {
            int count = 1;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
                while (httpServletRequest.getParameter("isbn"+count) != null) {
                    String isbn = httpServletRequest.getParameter("isbn"+count);
                    String title = httpServletRequest.getParameter("title"+count);
                    String authors = httpServletRequest.getParameter("authors"+count);
                    String price = httpServletRequest.getParameter("price"+count);

                    String sql = "insert into books(isbn, title, authors, price) values(?,?,?,?)";
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setString(1, isbn);
                    ps.setString(2, title);
                    ps.setString(3, authors);
                    ps.setFloat(4, Float.valueOf(price));
                    ps.executeUpdate();

                    count++;
                }
                connection.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return new ModelAndView("books-success").addObject("quantity", --count);
        }
        return null;
    }
}
