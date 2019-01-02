package com.db.exception;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.db.spring.model.RestResponse;
import com.db.spring.model.RestStatus;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = ex.getParameterName() + " parameter is missing";

		RestResponse<String> response = new RestResponse<>(null,
				new RestStatus<>(String.valueOf(HttpStatus.BAD_REQUEST.value()), error));
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		StringBuilder builder = new StringBuilder();
		builder.append(ex.getContentType());
		builder.append(" media type is not supported. Supported media types are ");
		ex.getSupportedMediaTypes().forEach(t -> builder.append(t).append(", "));

		RestResponse<String> response = new RestResponse<>(null, new RestStatus<>(
				String.valueOf(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()), builder.substring(0, builder.length() - 2)));
		return new ResponseEntity<>(response, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors = new ArrayList<>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.add(error.getField() + ": " + error.getDefaultMessage());
		}
		for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
			errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
		}

		RestResponse<String> response = new RestResponse<>(null,
				new RestStatus<>(String.valueOf(HttpStatus.BAD_REQUEST.value()), errors.toString()));
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = "Malformed JSON request";
		RestResponse<String> response = new RestResponse<>(null,
				new RestStatus<>(String.valueOf(HttpStatus.BAD_REQUEST.value()), error));
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = "Error writing JSON output";
		RestResponse<String> response = new RestResponse<>(null,
				new RestStatus<>(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), error));
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(javax.persistence.EntityNotFoundException.class)
	protected ResponseEntity<Object> handleEntityNotFound(javax.persistence.EntityNotFoundException ex) {
		RestResponse<String> response = new RestResponse<>(null,
				new RestStatus<>(String.valueOf(HttpStatus.NOT_FOUND.value()), ex.getLocalizedMessage()));
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	protected ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException ex,
			WebRequest request) {
		if (ex.getCause() instanceof ConstraintViolationException) {
			RestResponse<String> response = new RestResponse<>(null,
					new RestStatus<>(String.valueOf(HttpStatus.CONFLICT.value()), "Database error"));
			return new ResponseEntity<>(response, HttpStatus.CONFLICT);
		}
		RestResponse<String> response = new RestResponse<>(null,
				new RestStatus<>(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), ex.getLocalizedMessage()));
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	protected ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
			WebRequest request) {
		RestResponse<String> response = new RestResponse<>(null,
				new RestStatus<>(String.valueOf(HttpStatus.BAD_REQUEST.value()),
						String.format("The parameter '%s' of value '%s' could not be converted to type '%s'",
								ex.getName(), ex.getValue(), ex.getRequiredType().getSimpleName())));
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}


	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {
		RestResponse<String> response = new RestResponse<>(null,
				new RestStatus<>(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()),
						"Internal Server Error while performing Operation"));
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}


	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		final RestResponse<String> response = new RestResponse<>(null,
				new RestStatus<>(String.valueOf(HttpStatus.BAD_REQUEST.value()), ex.getMessage()));
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptableException(HttpMediaTypeNotAcceptableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		final RestResponse<String> response = new RestResponse<>(null,
				new RestStatus<>(String.valueOf(HttpStatus.NOT_ACCEPTABLE.value()), ex.getMessage()));
		return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
	}
	
	protected ResponseEntity<Object> handleMissingPathVariableException(MissingPathVariableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		final RestResponse<String> response = new RestResponse<>(null,
				new RestStatus<>(String.valueOf(HttpStatus.NOT_ACCEPTABLE.value()), ex.getMessage()));
		return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
	}
}
