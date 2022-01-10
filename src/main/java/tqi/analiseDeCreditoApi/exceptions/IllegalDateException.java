package tqi.analiseDeCreditoApi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IllegalDateException extends Exception {
    public IllegalDateException() { super ("A primeira parcela deve ser em até 3 meses!"); }
}
