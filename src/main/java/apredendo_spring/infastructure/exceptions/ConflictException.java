package apredendo_spring.infastructure.exceptions;

import apredendo_spring.infastructure.entity.Usuario;

public class ConflictException extends RuntimeException {

    public ConflictException(String mensagem) {
        super(mensagem);
    }

    public ConflictException(String mensagem, Throwable throwable) {
        super(mensagem);
    }
}
