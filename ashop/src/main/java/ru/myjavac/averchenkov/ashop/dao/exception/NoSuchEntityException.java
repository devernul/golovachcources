package ru.myjavac.averchenkov.ashop.dao.exception;

/**
 * @author Averchenkov R.A.
 */
public class NoSuchEntityException extends DaoBusinessExeption {
    public NoSuchEntityException(String message){
        super(message);
    }

    public NoSuchEntityException(String message, Throwable cause){
        super(message, cause);
    }
}
