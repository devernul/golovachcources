package ru.myjavac.averchenkov.ashop.controller;

import ru.myjavac.averchenkov.ashop.dao.ProductDao;
import ru.myjavac.averchenkov.ashop.dao.exception.DaoSystemException;
import ru.myjavac.averchenkov.ashop.dao.exception.NoSuchEntityException;
import ru.myjavac.averchenkov.ashop.dao.imple.ProductDaoMock;
import ru.myjavac.averchenkov.ashop.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Averchenkov R.A.
 */
public class ProductController extends HttpServlet {
    public static final String PARAM_ID = "id";
    public static final String ATTRIBUTE_MODEL_TO_VIEW = "product";
    public static final String PAGE_OK = "product.jsp";
    public static final String PAGE_ERROR = "error.jsp";

    private ProductDao productDao = new ProductDaoMock();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter(PARAM_ID);
        if(idStr != null){
            try {
                Integer id = Integer.valueOf(idStr);
                Product model = productDao.selectById(id);
                req.setAttribute(ATTRIBUTE_MODEL_TO_VIEW, model);
                //OK
                req.getRequestDispatcher(PAGE_OK).forward(req,resp);
                return;
            } catch (NumberFormatException  | NoSuchEntityException | DaoSystemException e){
                /*NOP*/
            }
        }
        // FAIL
        resp.sendRedirect(PAGE_ERROR);
    }
}
