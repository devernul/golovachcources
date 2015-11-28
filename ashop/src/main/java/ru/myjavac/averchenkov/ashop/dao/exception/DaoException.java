package ru.myjavac.averchenkov.ashop.dao.exception;

/**
 * @author Averchenkov R.A.
 */
public class DaoException extends Exception {
    public DaoException(String message){
        super(message);
    }

    public DaoException(String message, Throwable cause){
        super(message, cause);
    }
}
