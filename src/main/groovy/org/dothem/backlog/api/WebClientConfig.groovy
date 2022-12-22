package org.dothem.backlog.api

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@Configuration
class WebClientConfig {

  @Bean
  WebClient web() {
    WebClient.create()
  }
}