package org.dothem.backlog.github

import com.fasterxml.jackson.annotation.JsonInclude
import groovy.transform.TupleConstructor

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@TupleConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
class CreateGitHubIssueRq {

  String owner
  String repo
  String title
  String body
  String[] labels
}