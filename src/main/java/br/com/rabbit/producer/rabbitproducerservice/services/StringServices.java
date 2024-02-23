package br.com.rabbit.producer.rabbitproducerservice.services;

import static br.com.rabbit.producer.rabbitproducerservice.configs.RabbitMQConfig.EXG_NAME_MARKETPLACE;
import static br.com.rabbit.producer.rabbitproducerservice.configs.RabbitMQConfig.RK_PRODUCT_LOG;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class StringServices {
  private final RabbitTemplate rabbitTemplate;
  public void produce(String message){
    log.info("Mensagem Recebida" + message);
    rabbitTemplate.convertAndSend(EXG_NAME_MARKETPLACE, RK_PRODUCT_LOG, message);
  }
}
