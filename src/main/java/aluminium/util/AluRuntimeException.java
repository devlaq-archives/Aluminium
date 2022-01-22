package aluminium.util;

import java.io.Serial;

public class AluRuntimeException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = -6283365741944758453L;

    public AluRuntimeException(String message){
        super(message);
    }

    public AluRuntimeException(Throwable t){
        super(t);
    }

    public AluRuntimeException(String message, Throwable t){
        super(message, t);
    }
}

