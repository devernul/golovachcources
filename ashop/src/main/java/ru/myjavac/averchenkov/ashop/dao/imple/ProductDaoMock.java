package ru.myjavac.averchenkov.ashop.dao.imple;

import ru.myjavac.averchenkov.ashop.dao.ProductDao;
import ru.myjavac.averchenkov.ashop.dao.exception.DaoSystemException;
import ru.myjavac.averchenkov.ashop.dao.exception.NoSuchEntityException;
import ru.myjavac.averchenkov.ashop.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Averchenkov R.A.
 */
public class ProductDaoMock implements ProductDao {
    private final Map<Integer, Product> memory = new ConcurrentHashMap<>();

    public ProductDaoMock() {
        this.memory.put(1, new Product(1, "Bread"));
        this.memory.put(2, new Product(2, "Paper"));
        this.memory.put(3, new Product(3, "Sugar"));
    }

    @Override
    public Product selectById(int id) throws DaoSystemException, NoSuchEntityException {
        if (!memory.containsKey(id)){
            throw new NoSuchEntityException("No Product for id == '" + id + "', only");
        }
        return memory.get(id);
    }

    @Override
    public List<Product> selectAll() throws DaoSystemException {
        return new ArrayList<>(memory.values());
    }
}
