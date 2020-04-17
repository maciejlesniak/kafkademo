package pl.sparkidea.demo.kafka.producer.service;

import java.util.concurrent.Future;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class DemoTextMsgTopicFacade implements KafkaTopicFacade<Integer, String> {

  private static final String KAFKA_TOPIC_TEXT_MESSAGES = "demo-text-msg";

  private final KafkaTemplate<Integer, String> kafkaTemplate;

  @SuppressWarnings("unchecked")
  public DemoTextMsgTopicFacade(
      KafkaTemplate<?, ?> kafkaTemplate) {

    this.kafkaTemplate = (KafkaTemplate<Integer, String>) kafkaTemplate;
  }

  @Override
  public Future<SendResult<Integer, String>> sendMessage(String msg) {

    return this.kafkaTemplate.send(
        KAFKA_TOPIC_TEXT_MESSAGES,
        msg.length(),
        msg
    );
  }
}
