package ru.myjavac.averchenkov.ashop.dao.exception;

/**
 * @author Averchenkov R.A.
 */
public class DaoSystemException extends DaoException {
    public DaoSystemException(String message){
        super(message);
    }

    public DaoSystemException(String message, Throwable cause){
        super(message, cause);
    }
}
