package org.dothem.backlog.api

import org.dothem.backlog.github.CreateGitHubReleaseRq
import org.dothem.backlog.github.GitHub
import org.dothem.backlog.github.OwnerRepoRq
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@RestController
@RequestMapping("/api/v1/releases")
class ReleaseApiController {

  @Autowired
  private GitHub gh

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  Flux<?> release(@RequestBody CreateGitHubReleaseRq request) {
    this.gh.createRelease(new OwnerRepoRq("h1alexbel", "realo"),
        new CreateGitHubReleaseRq("0.0.1", "main", "name", "body"))
  }
}