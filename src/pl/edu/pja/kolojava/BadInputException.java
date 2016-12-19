package pl.edu.pja.kolojava;

/**
 * Created by andrzejtorski on 19.12.16.
 */
public class BadInputException extends Exception {

    int input;

    public BadInputException() {
        super();
    }

    public BadInputException(String message, int input, Throwable cause) {
        super (message, cause);
        this.input = input;
    }

    public int getInput() {
        return input;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " bad input: " + input;
    }
}
