package one.tqi.analiseDeCreditoApi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNotFoundException extends Exception {
    public ClienteNotFoundException(Long id) {
        super("Nenhum cliente encontrado com a id " + id);
    }
}
