package org.dothem.backlog.api

import com.fasterxml.jackson.annotation.JsonInclude

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
class CreateTaskRq {

  String owner
  String repo
  String projectId
  String sectionId
  String title
  String body
  Integer priority
  String due
  String lang
  String[] labels
}