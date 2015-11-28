package ru.myjavac.averchenkov.ashop.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Averchenkov R.A.
 */
public class RequestInfoFilter extends BaseFilter {
    @Override
    public void doFilter(HttpServletRequest request,
                         HttpServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        String method = request.getMethod();
        String remoteAddr = request.getRemoteAddr();
        String queryString = request.getQueryString();
        String protocol = request.getProtocol();

        System.out.println(">>> RequestInfoFilter: method = '" + method+
                           "\nremoteAddr = '" + remoteAddr +
                           "\nqueryString = "+ queryString +
                           "\nprotocol = " + protocol + "\n");
        filterChain.doFilter(request, response);
    }
}
