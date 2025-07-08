package exceptions;

public class QuantityIsValidException extends RuntimeException {
    public QuantityIsValidException(String message) {
        super(message);
    }

    public static void quantityIsValid(int quantity) {
        if (quantity < 0)
            throw new QuantityIsValidException("The Number SHOULD BE MORE THAN 0 !!!");

    }
}
