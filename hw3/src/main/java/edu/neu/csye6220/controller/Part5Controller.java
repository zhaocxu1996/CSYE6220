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
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;


/**
 * @author zhaocxu
 */
@WebServlet(name = "Part5Controller", urlPatterns = {"/part5.xls"})
public class Part5Controller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");
        try {
            Class.forName("org.relique.jdbc.csv.CsvDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:relique:csv:C:\\Users\\zhaoc\\Documents\\GitHub\\CSYE6220\\hw3\\web\\WEB-INF";
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            String query = "SELECT *  FROM " + filename;
            ResultSet results = stmt.executeQuery(query);
            ResultSetMetaData meta = results.getMetaData();

            List<List<String>> resultList = new ArrayList();
            ArrayList<String> titles = new ArrayList<String>();
            int columnCount = meta.getColumnCount();

            for(int m = 1; m <= columnCount; m ++){
                titles.add(meta.getColumnName(m));
            }
            resultList.add(titles);
            while (results.next())
            {
                ArrayList<String> rowList = new ArrayList<String>();
                for (int i = 1; i <= columnCount; i++)
                {
                    rowList.add(results.getString(i));
                }
                resultList.add(rowList);
            }

            request.setAttribute("list", resultList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/part5.jsp");
            dispatcher.forward(request, response);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
