package pl.sparkidea.demo.kafka.producer.service;

import java.util.concurrent.Future;
import org.springframework.kafka.support.SendResult;

public interface KafkaTopicFacade<K, V> {

  Future<SendResult<K, V>> sendMessage(V msg);

}
