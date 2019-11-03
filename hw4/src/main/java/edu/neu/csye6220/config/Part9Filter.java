package edu.neu.csye6220.config;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class Part9Filter implements Filter {
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Enumeration<String> parameterNames = servletRequest.getParameterNames();
        String paramValues = "";
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String[] value = servletRequest.getParameterValues(name);
            for (int i = 0; i < value.length; i++) {
                paramValues += value[i];
            }
        }
        if (validate(paramValues)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("part9.html");
            dispatcher.forward(servletRequest, servletResponse);
        }
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
