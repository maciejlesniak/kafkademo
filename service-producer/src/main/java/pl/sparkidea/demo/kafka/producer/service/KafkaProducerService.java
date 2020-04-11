package pl.sparkidea.demo.kafka.producer.service;

import java.util.concurrent.Future;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

  private static final Logger LOG = LoggerFactory.getLogger(KafkaProducerService.class);

  private static final String KAFKA_TOPIC_TEXT_MESSAGES = "demo-text-msg";

  private final KafkaTemplate<Integer, String> kafkaTemplate;

  @SuppressWarnings("unchecked")
  public KafkaProducerService(
      KafkaTemplate<?, ?> kafkaTemplate) {

    this.kafkaTemplate = (KafkaTemplate<Integer, String>) kafkaTemplate;
  }

  public Future<SendResult<Integer, String>> sendMessage(String message) {

    LOG.debug("Sending a message -> topic: {}, key: {}, payload: {}",
        KAFKA_TOPIC_TEXT_MESSAGES,
        message.length(),
        message);

    return this.kafkaTemplate.send(
        KAFKA_TOPIC_TEXT_MESSAGES,
        message.length(),
        message
    );
  }

}
