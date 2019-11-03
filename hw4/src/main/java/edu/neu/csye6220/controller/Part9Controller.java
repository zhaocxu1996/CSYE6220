package edu.neu.csye6220.controller;

import edu.neu.csye6220.entity.Movies;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
            int year = Integer.valueOf(httpServletRequest.getParameter("year"));
            Movies movies = new Movies();
            movies.setTitle(title);
            movies.setActor(actor);
            movies.setActress(actress);
            movies.setGenre(genre);
            movies.setYear(year);

            Configuration configuration = new Configuration();
            configuration.configure();
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(movies);
            transaction.commit();
            session.close();
            return new ModelAndView("add-success");
        } else if (search != null) {
            String keyword = httpServletRequest.getParameter("keyword");
            String option = httpServletRequest.getParameter("option");
//            List<Map<String, Object>> resultList = new ArrayList();
            Configuration configuration = new Configuration();
            configuration.configure();
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            String sql = String.format("SELECT * FROM movies WHERE %s = '%s'",option,keyword);
            SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(Movies.class);
            List<Movies> list = sqlQuery.list();
//            for (int i = 0; i < list.size(); i++) {
//                Map<String, Object> map = new HashMap<String, Object>();
//                map.put("title", list.get(i).getTitle());
//                map.put("actor", list.get(i).getActor());
//                map.put("actress", list.get(i).getActress());
//                map.put("genre", list.get(i).getGenre());
//                map.put("year", list.get(i).getYear());
//                resultList.add(map);
//            }

//            try {
//                Class.forName("com.mysql.jdbc.Driver");
//                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
//                Statement statement = connection.createStatement();
//                String sql = String.format("SELECT * FROM movies WHERE %s = '%s'",option,keyword);
//                ResultSet resultSet = statement.executeQuery(sql);
//                while (resultSet.next()) {
//                    Map<String, Object> map = new HashMap<String, Object>();
//                    map.put("title", resultSet.getString("title"));
//                    map.put("actor", resultSet.getString("actor"));
//                    map.put("actress", resultSet.getString("actress"));
//                    map.put("genre", resultSet.getString("genre"));
//                    map.put("year", resultSet.getInt("year"));
//                    resultList.add(map);
//                }
//                connection.close();
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
            ModelAndView mav = new ModelAndView("search-result");
            mav.addObject("search", list);
            mav.addObject("keyword", keyword);
            return mav;
        }
        return null;
    }
}
