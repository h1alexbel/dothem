package org.dothem.backlog.github

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@Component
class GitHub {

  @Value('${backlog.github.token}')
  private String token
  @Value('${backlog.github.api-version}')
  private String version
  @Autowired
  private WebClient web

  Flux<CreateGitHubIssueRs> createIssue(CreateGithubIssueRq request) {
    this.web.post()
        .uri("https://api.github.com/repos/${request.owner}/${request.repo}/issues")
        .header("Authorization", "Bearer ${this.token}")
        .header("GitHub-Api-Version", "application/vnd.github+json")
        .header("Accept", this.version)
        .body(Mono.just(request), CreateGithubIssueRq)
        .retrieve()
        .bodyToFlux(CreateGitHubIssueRs)
  }
}