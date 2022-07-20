package br.com.pet.storeapi.api.clients;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ViaCepClient {

  @Bean
  public WebClient viaCepWebClient(WebClient.Builder builder) {
    return builder
        .baseUrl("https://viacep.com.br/ws")
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .build();
  }
}
