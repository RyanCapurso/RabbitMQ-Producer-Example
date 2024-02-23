package br.com.rabbit.producer.rabbitproducerservice.controllers;

import br.com.rabbit.producer.rabbitproducerservice.services.StringServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/produces")
public class StringController {
  private final StringServices services;

  @GetMapping
  public ResponseEntity<String> produces(@RequestParam("message") String message){
    services.produce(message);
    return ResponseEntity.ok().body("Enviando Mensagem");
  }
}
