package com.oce.springboot.training.d02.s04.exceptions;

import com.oce.springboot.training.d02.s04.dto.MessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The most common exception handlers
 *
 * @author bogdan.solga
 */
@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public MessageDTO notFoundException(final NotFoundException e) {
        return new MessageDTO(e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public MessageDTO illegalArgumentException(final IllegalArgumentException e) {
        return new MessageDTO(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public MessageDTO internalServerError(final Exception e) {
        return new MessageDTO(e.getMessage());
    }
}
