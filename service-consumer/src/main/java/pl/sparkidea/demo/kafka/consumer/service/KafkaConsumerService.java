package pl.sparkidea.demo.kafka.consumer.service;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

  private static final Logger LOG = LoggerFactory.getLogger(KafkaConsumerService.class);

  @KafkaListener(topics = {"demo-text-msg"})
  public void consumeMessages(String message) throws IOException {

    LOG.debug("Incoming Kafka message: {}", message);
  }

}
