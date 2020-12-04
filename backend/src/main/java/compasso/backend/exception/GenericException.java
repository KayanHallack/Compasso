package compasso.backend.exception;

public class GenericException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public GenericException() {
        super("Ocorreu um erro inesperado. Se o erro persistir, contate o administrador do sistema.");
    }
}
