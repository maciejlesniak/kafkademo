package pl.sparkidea.demo.kafka.producer.service;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.util.ObjectUtils;

public class LoggingProducerListener<K, V> implements ProducerListener<K, V> {

  public static final Logger LOG = LoggerFactory.getLogger(LoggingProducerListener.class);

  @Override
  public void onSuccess(String topic, Integer partition, K key, V value, RecordMetadata recordMetadata) {

    LOG.debug("Topic/partition/key [{}/{}/{}], val: {}",
        topic,
        partition,
        ObjectUtils.nullSafeToString(key),
        ObjectUtils.nullSafeToString(value)
    );

  }

  @Override
  public void onError(String topic, Integer partition, K key, V value, Exception exception) {

    LOG.error("Topic/partition/key [{}/{}/{}], val: {}, error: {}",
        topic,
        partition,
        ObjectUtils.nullSafeToString(key),
        ObjectUtils.nullSafeToString(value),
        exception.getMessage(),
        exception
    );
  }
}
