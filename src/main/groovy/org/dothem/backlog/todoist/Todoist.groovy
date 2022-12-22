package org.dothem.backlog.todoist


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
class Todoist {

  @Value('${backlog.todoist.token}')
  private String token
  @Autowired
  private WebClient web

  Flux<TodoistSectionRs> sections(String id) {
    this.web.get()
        .uri("https://api.todoist.com/rest/v2/sections?project_id=${id}")
        .header("Authorization", "Bearer ${this.token}")
        .retrieve()
        .bodyToFlux(TodoistSectionRs)
  }

  Flux<TodoistProjectRs> projects() {
    this.web.get()
        .uri("https://api.todoist.com/rest/v2/projects")
        .header("Authorization", "Bearer ${this.token}")
        .retrieve()
        .bodyToFlux(TodoistProjectRs)
  }

  Flux<CreateTodoistTaskRs> createTask(CreateTodoistTaskRq request) {
    this.web.post()
        .uri("https://api.todoist.com/rest/v2/tasks")
        .header("Authorization", "Bearer ${this.token}")
        .body(Mono.just(request), CreateTodoistTaskRq)
        .retrieve()
        .bodyToFlux(CreateTodoistTaskRs)
  }
}
