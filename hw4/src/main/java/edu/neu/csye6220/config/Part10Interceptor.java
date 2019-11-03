package edu.neu.csye6220.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class Part10Interceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        if (request.getParameter("quantity") != null) {
            return true;
        } else {
            Enumeration<String> parameterNames = request.getParameterNames();
            String paramValues = "";
            while (parameterNames.hasMoreElements()) {
                String name = parameterNames.nextElement();
                String[] value = request.getParameterValues(name);
                for (int i = 0; i < value.length; i++) {
                    paramValues += value[i];
                }
            }
            if (validate(paramValues)) {
                return true;
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("part10.html");
                dispatcher.forward(request, response);
                return false;
            }
        }
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    private boolean validate(String s) {
        s = s.toLowerCase();
        if (s.contains("select") || s.contains("update") || s.contains("delete") || s.contains("insert") || s.contains("script")) {
            return false;
        } else {
            return true;
        }
    }
}
