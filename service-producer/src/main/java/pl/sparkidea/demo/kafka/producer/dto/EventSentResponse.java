package pl.sparkidea.demo.kafka.producer.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Set;

public class EventSentResponse<K, V> {

  public static final String FIELD_TOPIC = "topic";

  public static final String FIELD_PARTITION = "partition";

  public static final String FIELD_HEADERS = "headers";

  public static final String FIELD_KEY = "partition_key";

  public static final String FIELD_VAL = "content";

  public static final String FIELD_TIMESTAMP_RECORD = "record_timestamp";

  public static final String FIELD_TIMESTAMP_PRODUCER = "producer_timestamp";

  @JsonProperty(FIELD_TOPIC)
  private final String topic;

  @JsonProperty(FIELD_PARTITION)
  private final Integer partition;

  @JsonProperty(FIELD_HEADERS)
  private final Set<String> headers;

  @JsonProperty(FIELD_KEY)
  private final K key;

  @JsonProperty(FIELD_VAL)
  private final V value;

  @JsonProperty(FIELD_TIMESTAMP_RECORD)
  private final Long recordTimestamp;

  @JsonProperty(FIELD_TIMESTAMP_PRODUCER)
  private final Long producerTimestamp;


  @JsonCreator
  public EventSentResponse(
      String topic,
      Integer partition,
      Set<String> headers,
      K key,
      V value,
      Long recordTimestamp,
      Long producerTimestamp) {

    this.topic = topic;
    this.partition = partition;
    this.headers = headers;
    this.key = key;
    this.value = value;
    this.recordTimestamp = recordTimestamp;
    this.producerTimestamp = producerTimestamp;
  }

  public String getTopic() {

    return topic;
  }

  public Integer getPartition() {

    return partition;
  }

  public Set<String> getHeaders() {

    return headers;
  }

  public K getKey() {

    return key;
  }

  public V getValue() {

    return value;
  }

  public Long getRecordTimestamp() {

    return recordTimestamp;
  }

  public Long getProducerTimestamp() {

    return producerTimestamp;
  }
}
