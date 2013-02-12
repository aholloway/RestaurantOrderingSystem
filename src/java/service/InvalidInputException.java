
package service;

/**
 * Exception that is thrown when input that is invalid is encountered.
 * @author aholloway
 */
public class InvalidInputException extends RuntimeException {

    //need to create a message property
    private String message; 

    /**
     * default constructor
     */
    public InvalidInputException() {
        message= "Input is not valid.";
    }

    /**
     *
     * @param message sets the exception's message
     */
    public InvalidInputException(String message) {
        this.message=message;
    }
    
    
    @Override
    public String getMessage() {
        return message;
    }
}
