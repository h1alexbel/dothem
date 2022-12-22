package org.dothem.backlog.api.handler

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.server.ResponseStatusException

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@RestControllerAdvice
class BacklogApiExceptionHandler {

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(ResponseStatusException)
  ResponseError handle(ResponseStatusException e) {
    new ResponseError(message: e.message, code: 404)
  }
}