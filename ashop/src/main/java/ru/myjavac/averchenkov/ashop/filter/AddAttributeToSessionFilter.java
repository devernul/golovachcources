package ru.myjavac.averchenkov.ashop.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author Averchenkov R.A.
 */
public class AddAttributeToSessionFilter extends BaseFilter {
    FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = request.getSession(true);

        Enumeration<String> iter = session.getAttributeNames();
        while (iter.hasMoreElements()){
            String initParameterName = iter.nextElement();
            String initParameterValue = filterConfig.getInitParameter(initParameterName);
            session.setAttribute(initParameterName, initParameterValue);
        }

        filterChain.doFilter(request, response);
    }
}
