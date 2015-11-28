package ru.myjavac.averchenkov.ashop.dao.exception;

/**
 * @author Averchenkov R.A.
 */
public class DaoBusinessExeption extends DaoException {
    public DaoBusinessExeption(String message){
        super(message);
    }

    public DaoBusinessExeption(String message, Throwable cause){
        super(message, cause);
    }
}
