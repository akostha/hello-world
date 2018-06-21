package br.com.scopus.arquitetura.devops;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandle extends ResponseEntityExceptionHandler {

	@ExceptionHandler({IllegalArgumentException.class})
	public void badRequest(HttpServletResponse res, RuntimeException rte) throws IOException {
		res.sendError(HttpStatus.BAD_REQUEST.value(), rte.getMessage());
	}
	
}
