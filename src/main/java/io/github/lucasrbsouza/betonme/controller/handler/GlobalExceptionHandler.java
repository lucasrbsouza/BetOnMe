package io.github.lucasrbsouza.betonme.controller.handler;

import io.github.lucasrbsouza.betonme.controller.dto.ErroResposta;
import io.github.lucasrbsouza.betonme.controller.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErroResposta handleRespostaPadraoException(ResourceNotFoundException e){
        return ErroResposta.respostaPadrao(e.getMessage());
    }
}
