package com.dbserver.desafio_votacao.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private static final String MSG_VALIDACAO_ERROR = "A requisição contém dados inválidos.";

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> processAPIException(final ApiException ex, final HttpServletRequest request) {
        return ResponseEntity.status(ex.getHttpStatus()).body(ex.getMensagem());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(final MethodArgumentNotValidException ex) {
        AtomicReference<String> message = new AtomicReference<>("");
        List<String> erros = getErrosValidacao(ex, message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.format("%s - %s", MSG_VALIDACAO_ERROR, erros.getFirst()));
    }

    private List<String> getErrosValidacao(final MethodArgumentNotValidException ex, final AtomicReference<String> message) {
        return ex.getBindingResult().getFieldErrors()
                .stream()
                .map(error -> {
                    message.set(String.format("[%s.%s], %s - %s ", error.getObjectName(), error.getField(), MSG_VALIDACAO_ERROR, error.getDefaultMessage()));
                    return error.getField() + ": " + error.getDefaultMessage();
                }).toList();
    }
}
