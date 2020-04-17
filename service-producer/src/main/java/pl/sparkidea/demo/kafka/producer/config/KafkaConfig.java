package pl.sparkidea.demo.kafka.producer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.ProducerListener;
import pl.sparkidea.demo.kafka.producer.service.LoggingProducerListener;

@Configuration
public class KafkaConfig {

  @Bean
  public ProducerListener<Object, Object> kafkaProducerListener() {

    return new LoggingProducerListener<>();
  }

}
