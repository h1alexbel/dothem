package org.dothem.backlog.github

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.TupleConstructor

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@TupleConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
class CreateGitHubReleaseRq {

  @JsonProperty("tag_name")
  String tag
  @JsonProperty("target_commitish")
  String branch
  String name
  String body
}