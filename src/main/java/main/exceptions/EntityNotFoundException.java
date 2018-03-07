package main.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException() {
        super("Requested object not found");
    }
}
