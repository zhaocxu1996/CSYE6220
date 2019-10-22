package edu.neu.csye6220.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Part9Controller extends AbstractController {
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String selection = httpServletRequest.getParameter("selection");
        String add = httpServletRequest.getParameter("add");
        String search = httpServletRequest.getParameter("search");
        if (selection != null) {
            if (selection.equals("add")) {
                return new ModelAndView("add");
            } else if (selection.equals("browse")) {
                return new ModelAndView("browse");
            }
        } else if (add != null) {
            String title = httpServletRequest.getParameter("title");
            String actor = httpServletRequest.getParameter("actor");
            String actress = httpServletRequest.getParameter("actress");
            String genre = httpServletRequest.getParameter("genre");
            String year = httpServletRequest.getParameter("year");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
                String sql = "insert into movies(title, actor, actress, genre, year) values(?,?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, title);
                ps.setString(2, actor);
                ps.setString(3, actress);
                ps.setString(4, genre);
                ps.setInt(5, Integer.valueOf(year));
                ps.executeUpdate();
                connection.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return new ModelAndView("add-success");
        } else if (search != null) {
            String keyword = httpServletRequest.getParameter("keyword");
            String option = httpServletRequest.getParameter("option");
            List<Map<String, Object>> resultList = new ArrayList();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
                Statement statement = connection.createStatement();
                String sql = String.format("SELECT * FROM movies WHERE %s = '%s'",option,keyword);
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("title", resultSet.getString("title"));
                    map.put("actor", resultSet.getString("actor"));
                    map.put("actress", resultSet.getString("actress"));
                    map.put("genre", resultSet.getString("genre"));
                    map.put("year", resultSet.getInt("year"));
                    resultList.add(map);
                }
                connection.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ModelAndView mav = new ModelAndView("search-result");
            mav.addObject("search", resultList);
            mav.addObject("keyword", keyword);
            return mav;
        }
        return null;
    }
}
