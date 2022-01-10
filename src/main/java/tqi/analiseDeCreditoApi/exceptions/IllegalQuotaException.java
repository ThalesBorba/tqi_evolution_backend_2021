package tqi.analiseDeCreditoApi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IllegalQuotaException extends Exception {
    public IllegalQuotaException() { super ("Valor máximo de 60 parcelas!"); }
}
