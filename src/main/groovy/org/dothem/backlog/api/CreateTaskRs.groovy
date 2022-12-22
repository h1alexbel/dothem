package org.dothem.backlog.api

import groovy.transform.TupleConstructor

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@TupleConstructor
class CreateTaskRs {

  String github
  String todoist
}