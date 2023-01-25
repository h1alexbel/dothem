package org.dothem.backlog.api

import org.dothem.backlog.github.CreateGitHubIssueRq
import org.dothem.backlog.github.GitHub
import org.dothem.backlog.todoist.CreateTodoistTaskRq
import org.dothem.backlog.todoist.Todoist
import org.dothem.backlog.todoist.TodoistProjectRs
import org.dothem.backlog.todoist.TodoistSectionRs
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@RestController
@RequestMapping("/api/v1/backlog")
class BacklogApiController {

  @Autowired
  private Todoist todoist
  @Autowired
  private GitHub gh

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/todoist/projects")
  Flux<TodoistProjectRs> projects() {
    this.todoist.projects()
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/todoist/projects/{id}/sections")
  Flux<TodoistSectionRs> sections(@PathVariable String id) {
    this.todoist.sections(id)
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  Flux<CreateTaskRs> createTask(@RequestBody CreateTaskRq request) {
    this.gh.createIssue(
        new CreateGitHubIssueRq(
            owner: request.owner,
            repo: request.repo,
            title: request.title,
            body: request.body,
            labels: request.labels
        )
    ).zipWith(
        this.todoist.createTask(
            new CreateTodoistTaskRq(
                content: request.title,
                description: request.body,
                projectId: request.projectId,
                sectionId: request.sectionId,
                priority: request.priority,
                lang: request.lang,
                due: request.due,
                labels: request.labels
            )
        )
    ).flatMap(responses ->
        Mono.just(new CreateTaskRs(github: responses.t1.url, todoist: responses.t2.url))
    )
  }
}