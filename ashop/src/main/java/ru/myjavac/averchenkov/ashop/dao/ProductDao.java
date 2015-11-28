package ru.myjavac.averchenkov.ashop.dao;

import ru.myjavac.averchenkov.ashop.dao.exception.DaoSystemException;
import ru.myjavac.averchenkov.ashop.dao.exception.NoSuchEntityException;
import ru.myjavac.averchenkov.ashop.entity.Product;

import java.util.List;

/**
 * @author Averchenkov R.A.
 */
public interface ProductDao {
    Product selectById(int id) throws DaoSystemException, NoSuchEntityException;
    List<Product> selectAll() throws DaoSystemException;
}
