package org.dothem.backlog.github

import groovy.transform.TupleConstructor

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@TupleConstructor
class OwnerRepoRq {

  String owner
  String repo
}