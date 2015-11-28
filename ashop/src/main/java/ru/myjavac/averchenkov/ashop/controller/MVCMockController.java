package ru.myjavac.averchenkov.ashop.controller;

import ru.myjavac.averchenkov.ashop.entity.MockEntityA;
import ru.myjavac.averchenkov.ashop.entity.MockEntityB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Averchenkov R.A.
 */
public class MVCMockController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // add to REQUEST attributes
        req.setAttribute("requestAttribute", new MockEntityA());
        // add to SESSION attributes
        req.getSession().setAttribute("sessionAttribute", new MockEntityA());
        // add to SERVLET_CONTEXT attributes
        req.getServletContext().setAttribute("servletContextAttributes", new MockEntityA());

        req.setAttribute("test", "request");
        req.getSession().setAttribute("test", "session");
        req.getServletContext().setAttribute("test","servletContext");

        req.getRequestDispatcher("mvcMockView.jsp").forward(req,resp);
    }
}
