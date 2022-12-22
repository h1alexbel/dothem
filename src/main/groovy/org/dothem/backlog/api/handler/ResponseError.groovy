package org.dothem.backlog.api.handler

import groovy.transform.TupleConstructor

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@TupleConstructor
class ResponseError {

  String message
  Integer code
}