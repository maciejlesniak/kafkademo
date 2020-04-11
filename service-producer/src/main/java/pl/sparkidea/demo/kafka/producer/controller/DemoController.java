package pl.sparkidea.demo.kafka.producer.controller;


import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sparkidea.demo.kafka.producer.dto.EventSentResponse;
import pl.sparkidea.demo.kafka.producer.service.KafkaProducerService;

@RestController
@RequestMapping("/send")
public class DemoController {

  private final KafkaProducerService kafkaProducerService;

  public DemoController(KafkaProducerService kafkaProducerService) {

    this.kafkaProducerService = kafkaProducerService;
  }

  @RequestMapping(
      method = POST,
      path = "/text-only",
      consumes = MediaType.TEXT_PLAIN_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<EventSentResponse<Integer, String>> sentEvent(@RequestBody String message)
      throws ExecutionException, InterruptedException {

    SendResult<Integer, String> sendResult = kafkaProducerService.sendMessage(message).get();

    EventSentResponse<Integer, String> kafkaSendResultResponse = new EventSentResponse<>(
        sendResult.getRecordMetadata().topic(),
        sendResult.getRecordMetadata().partition(),
        Stream.of(sendResult.getProducerRecord().headers().toArray())
            .map(header -> String.format("%s->%s", header.key(), new String(header.value())))
            .collect(Collectors.toSet()),
        sendResult.getProducerRecord().key(),
        sendResult.getProducerRecord().value(),
        sendResult.getRecordMetadata().timestamp(),
        sendResult.getProducerRecord().timestamp());

    return ResponseEntity.ok(kafkaSendResultResponse);
  }

}
