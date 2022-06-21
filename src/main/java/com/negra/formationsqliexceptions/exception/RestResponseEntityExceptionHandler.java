package com.negra.formationsqliexceptions.exception;

import com.negra.formationsqliexceptions.dto.DocumentDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ListeDocumentsVideException.class, AucunDocumentTrouveException.class})
    protected ResponseEntity<Object> handleListeDocumentsVideException(
            RuntimeException ex, WebRequest request) {

        List<DocumentDto> bodyOfResponse = null;

        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NO_CONTENT, request);
    }

    @ExceptionHandler(DocumentInexistantException.class)
    protected ResponseEntity<Object> handleDocumentInexistantException(
            RuntimeException ex, WebRequest request) {

        DocumentDto bodyOfResponse = null;

        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NO_CONTENT, request);
    }

}
