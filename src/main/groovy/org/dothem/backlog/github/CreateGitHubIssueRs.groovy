package org.dothem.backlog.github

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
class CreateGitHubIssueRs {

  @JsonProperty("html_url")
  String url
}