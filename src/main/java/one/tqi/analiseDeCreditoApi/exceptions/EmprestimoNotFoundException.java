package one.tqi.analiseDeCreditoApi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmprestimoNotFoundException extends Exception {
    public EmprestimoNotFoundException(Long id) {
        super("Nenhum emprestimo encontrado com a id " + id);
    }
}
