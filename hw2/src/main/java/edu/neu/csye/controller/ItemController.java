package edu.neu.csye.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "ItemController", urlPatterns = {"/ItemController"})
public class ItemController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String pageNumber = request.getParameter("p-number");
        if (pageNumber.equals("1")) {
            String page = request.getParameter("page");
            if (page.equals("View cart")) {
                ViewCart(session, request, response);
            } else if (page.equals("book") || page.equals("music") || page.equals("computer")){
                request.setAttribute("name", page);
                RequestDispatcher dispatcher = request.getRequestDispatcher("part7.jsp");
                dispatcher.forward(request, response);
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
            ViewCart(session, request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Map<String, String[]> parameterNames = request.getParameterMap();
        if(parameterNames.containsKey("page")) {
            String page = parameterNames.get("page")[0];
            request.setAttribute("name", page);
            RequestDispatcher dispatcher = request.getRequestDispatcher("part7.jsp");
            dispatcher.forward(request, response);
        } else {
            Set<String> keys = parameterNames.keySet();
            for(String key : keys) {
                if (!key.equals("submit") && !key.equals("page")) {
                    String[] values = parameterNames.get(key);
                    List<String> itemList = new ArrayList<String>();
                    for (int i = 0; i < values.length; i++) {
                        if (session.getAttribute(values[i])!=null) {
                            int quantity = Integer.valueOf(session.getAttribute(values[i]).toString());
                            session.setAttribute(values[i], ++quantity);
                        } else {
                            session.setAttribute(values[i], 1);
                        }
                        itemList.add(values[i]);
                    }
                    request.setAttribute("items", itemList);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("part7.jsp");
                    dispatcher.forward(request, response);
                }
            }
        }
    }

    private void ViewCart(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String[]> names = new ArrayList<String[]>();
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attribute = attributeNames.nextElement();
            String quantity = session.getAttribute(attribute).toString();
            String[] name = {attribute, quantity};
            names.add(name);
        }
        request.setAttribute("names", names);
        RequestDispatcher dispatcher = request.getRequestDispatcher("part7.jsp");
        dispatcher.forward(request, response);
    }
}
