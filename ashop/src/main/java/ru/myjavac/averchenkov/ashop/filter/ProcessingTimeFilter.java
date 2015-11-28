package ru.myjavac.averchenkov.ashop.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Averchenkov R.A.
 */
public class ProcessingTimeFilter implements Filter {

    public ProcessingTimeFilter() {
        System.out.println(">> ProcessingTimeFilter - NEW");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(">>  ProcessingTimeFilter - init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        long inTime = System.nanoTime();
        filterChain.doFilter(servletRequest, servletResponse);
        long outTime = System.nanoTime();
        System.out.println(">>  ProcessingTimeFilter: dT = " + (outTime - inTime));
        System.out.println();
    }

    @Override
    public void destroy() {

    }
}
