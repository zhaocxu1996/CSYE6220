package edu.neu.csye6220.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;


/**
 * @author zhaocxu
 */
@WebServlet(name = "FileController", urlPatterns = {"/FileController"})
public class FileController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");
        try {
            Class.forName("org.relique.jdbc.csv.CsvDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //todo change url
//        String url = "jdbc:relique:csv:" + "separator=;" + "&" + "fileExtension=.csv";
        String url = "jdbc:relique:csv:" + Thread.currentThread().getContextClassLoader().getResource("").getPath()+"../csvs";
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            String query = "SELECT *  FROM " + filename;
            //todo change query
//            ResultSet results = stmt.executeQuery("SELECT NAME FROM part5.csv");
            ResultSet results = stmt.executeQuery(query);
            String name = results.getString("name");
            String password = results.getString("password");
            String email = results.getString("email");
            request.setAttribute("name", name);
            request.setAttribute("password", password);
            request.setAttribute("email", email);
            RequestDispatcher dispatcher = request.getRequestDispatcher("part5.jsp");
            dispatcher.forward(request, response);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
