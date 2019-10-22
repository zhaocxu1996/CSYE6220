package edu.neu.csye6220.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Part6Controller extends AbstractController {
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        List<List<String>> resultList = new ArrayList();

        String filename = httpServletRequest.getParameter("filename");
        try {
            Class.forName("org.relique.jdbc.csv.CsvDriver");
            String url = "jdbc:relique:csv:C:\\Users\\zhaoc\\Documents\\GitHub\\CSYE6220\\hw3\\web\\WEB-INF";
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            String query = "SELECT *  FROM " + filename;
            ResultSet results = stmt.executeQuery(query);
            ResultSetMetaData meta = results.getMetaData();

            ArrayList<String> titles = new ArrayList<String>();
            int columnCount = meta.getColumnCount();

            for (int m = 1; m <= columnCount; m++) {
                titles.add(meta.getColumnName(m));
            }
            resultList.add(titles);
            while (results.next()) {
                ArrayList<String> rowList = new ArrayList<String>();
                for (int i = 1; i <= columnCount; i++) {
                    rowList.add(results.getString(i));
                }
                resultList.add(rowList);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return new ModelAndView("part6").addObject("list", resultList);
    }
}
