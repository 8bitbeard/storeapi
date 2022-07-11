package br.com.pet.storeapi.api.exceptions.handler;

import br.com.pet.storeapi.api.dtos.response.RestExceptionResponseDTO;
import br.com.pet.storeapi.api.dtos.response.RestExcetionListResponseDTO;
import br.com.pet.storeapi.api.exceptions.*;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestControllerAdvice
public class ApiExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public RestExcetionListResponseDTO handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<RestExcetionListResponseDTO.Field> fields = new ArrayList<>();

        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String name = ((FieldError) error).getField();
            String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            fields.add(new RestExcetionListResponseDTO.Field(name, message));
        }

        RestExcetionListResponseDTO error = new RestExcetionListResponseDTO();
        error.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
        error.setMessage(message("MethodArgumentNotValidException.message"));
        error.setFields(fields);

        return error;
    }

    @ExceptionHandler(AuthenticationFailedException.class)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public RestExceptionResponseDTO handleAuthenticationFailedException(AuthenticationFailedException ex) {
        RestExceptionResponseDTO exceptionResponse = new RestExceptionResponseDTO();
        exceptionResponse.setStatus(HttpStatus.UNAUTHORIZED.getReasonPhrase());
        exceptionResponse.setMessage(message("AuthenticationFailedException.message"));

        return exceptionResponse;
    }

    @ExceptionHandler(DocumentAlreadyInUseException.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public RestExceptionResponseDTO handleDocumentAlreadyInUseException(DocumentAlreadyInUseException ex) {
        RestExceptionResponseDTO exceptionResponse = new RestExceptionResponseDTO();
        exceptionResponse.setStatus(HttpStatus.CONFLICT.getReasonPhrase());
        exceptionResponse.setMessage(message("DocumentAlreadyInUseException.message"));

        return exceptionResponse;
    }

    @ExceptionHandler(EmailAlreadyInUseException.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public RestExceptionResponseDTO handleEmailAlreadyInUseException(EmailAlreadyInUseException ex) {
        RestExceptionResponseDTO exceptionResponse = new RestExceptionResponseDTO();
        exceptionResponse.setStatus(HttpStatus.CONFLICT.getReasonPhrase());
        exceptionResponse.setMessage(message("EmailAlreadyInUseException.message"));

        return exceptionResponse;
    }

    @ExceptionHandler(InvalidCepException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public RestExceptionResponseDTO handleInvalidCepException(InvalidCepException ex) {
        RestExceptionResponseDTO exceptionResponse = new RestExceptionResponseDTO();
        exceptionResponse.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
        exceptionResponse.setMessage(message("InvalidCepException.message"));

        return exceptionResponse;
    }

    @ExceptionHandler(PetNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public RestExceptionResponseDTO handlePetNotFoundException(PetNotFoundException ex) {
        RestExceptionResponseDTO exceptionResponse = new RestExceptionResponseDTO();
        exceptionResponse.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
        exceptionResponse.setMessage(message("PetNotFoundException.message"));

        return exceptionResponse;
    }

    @ExceptionHandler(ProcedureAlreadyExistsException.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public RestExceptionResponseDTO handleProcedureAlreadyExistsException(ProcedureAlreadyExistsException ex) {
        RestExceptionResponseDTO exceptionResponse = new RestExceptionResponseDTO();
        exceptionResponse.setStatus(HttpStatus.CONFLICT.getReasonPhrase());
        exceptionResponse.setMessage(message("ProcedureAlreadyExistsException.message"));

        return exceptionResponse;
    }

    @ExceptionHandler(ProcedureNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public RestExceptionResponseDTO handleProcedureNotFoundException(ProcedureNotFoundException ex) {
        RestExceptionResponseDTO exceptionResponse = new RestExceptionResponseDTO();
        exceptionResponse.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
        exceptionResponse.setMessage(message("ProcedureNotFoundException.message"));

        return exceptionResponse;
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public RestExceptionResponseDTO handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
        RestExceptionResponseDTO exceptionResponse = new RestExceptionResponseDTO();
        exceptionResponse.setStatus(HttpStatus.CONFLICT.getReasonPhrase());
        exceptionResponse.setMessage(message("UserAlreadyExistsException.message"));

        return exceptionResponse;
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public RestExceptionResponseDTO handleUserNotFoundException(UserNotFoundException ex) {
        RestExceptionResponseDTO exceptionResponse = new RestExceptionResponseDTO();
        exceptionResponse.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
        exceptionResponse.setMessage(message("UserNotFoundException.message"));

        return exceptionResponse;
    }

    private String message(String code, Object... params) {
        return messageSource.getMessage(code, params, LocaleContextHolder.getLocale());
    }
}
