package compasso.backend.exception;

public class ClienteNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ClienteNotFoundException() {
        super("Não foi possível encontrar o cliente.");
    }
}
