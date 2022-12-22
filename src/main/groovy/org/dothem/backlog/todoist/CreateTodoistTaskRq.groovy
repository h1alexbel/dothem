package org.dothem.backlog.todoist

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.TupleConstructor

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@TupleConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
class CreateTodoistTaskRq {

  String content
  String description
  @JsonProperty("project_id")
  String projectId
  @JsonProperty("section_id")
  String sectionId
  String priority
  @JsonProperty("due_date")
  String due
  @JsonProperty("due_lang")
  String lang
  String[] labels
}