package pl.sparkidea.demo.kafka.producer.service;

import java.util.concurrent.Future;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

  private KafkaTopicFacade<Integer, String> demoTextMsgTopicFacade;

  public KafkaProducerService(
      KafkaTopicFacade<Integer, String> demoTextMsgTopicFacade) {

    this.demoTextMsgTopicFacade = demoTextMsgTopicFacade;
  }

  public Future<SendResult<Integer, String>> sendMessage(String msg) {

    return demoTextMsgTopicFacade.sendMessage(msg);
  }

}
