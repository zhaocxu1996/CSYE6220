package edu.neu.csye6220.controller;

import edu.neu.csye6220.entity.Books;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Part10Controller extends AbstractController {
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String submit = httpServletRequest.getParameter("submit");
        String add = httpServletRequest.getParameter("add");
        if (submit != null) {
            int quantity = Integer.valueOf(httpServletRequest.getParameter("quantity"));
            return new ModelAndView("book-details").addObject("quantity", quantity);
        } else if (add != null) {
            int count = 1;
            Configuration configuration = new Configuration();
            configuration.configure();
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            while (httpServletRequest.getParameter("isbn"+count) != null) {
                Books book = new Books();
                book.setIsbn(httpServletRequest.getParameter("isbn"+count));
                book.setTitle(httpServletRequest.getParameter("title"+count));
                book.setAuthors(httpServletRequest.getParameter("authors"+count));
                book.setPrice(Double.valueOf(httpServletRequest.getParameter("price"+count)));
                count++;
                session.save(book);
            }
            transaction.commit();
            session.close();
            return new ModelAndView("books-success").addObject("quantity", --count);
        }
        return null;
    }
}
