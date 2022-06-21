package com.negra.formationsqliexceptions.exception;

import com.negra.formationsqliexceptions.dto.ExceptionDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ListeDocumentsVideException.class)
    protected ResponseEntity<Object> handleListeDocumentsVideException(
            RuntimeException ex, WebRequest request) {

        ExceptionDto exceptionDto = new ExceptionDto(ex.getMessage(), 0);

        return handleExceptionInternal(ex, exceptionDto,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(DocumentInexistantException.class)
    protected ResponseEntity<Object> handleDocumentInexistantException(
            RuntimeException ex, WebRequest request) {

        ExceptionDto exceptionDto = new ExceptionDto(ex.getMessage(), 0);

        return handleExceptionInternal(ex, exceptionDto,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(AucunDocumentTrouveException.class)
    protected ResponseEntity<Object> handleAucunDocumentTrouveException(
            RuntimeException ex, WebRequest request) {

        ExceptionDto exceptionDto = new ExceptionDto(ex.getMessage(), 0);

        return handleExceptionInternal(ex, exceptionDto,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

}
