package ru.myjavac.averchenkov.ashop.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Averchenkov R.A.
 */
public class CookieMockController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Cookie fromClient = null;
        for (Cookie cookie : cookies) {
            if("counter".equals(cookie.getName())) {
                fromClient = cookie;
                break;
            }
        }
        if (fromClient == null){
            resp.addCookie(new Cookie("counter", "1"));
            resp.getWriter().write("You visit this page: 1");
        } else {
            int visitCount = Integer.valueOf(fromClient.getValue()) + 1;
            resp.addCookie(new Cookie("counter", "" + visitCount));
            resp.getWriter().write("You visit this page: " + visitCount);
        }
    }
}
