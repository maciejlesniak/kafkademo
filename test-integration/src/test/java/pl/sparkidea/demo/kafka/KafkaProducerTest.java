package pl.sparkidea.demo.kafka;

import static io.restassured.RestAssured.given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import java.net.HttpURLConnection;
import java.time.Instant;
import org.junit.jupiter.api.RepeatedTest;

public class KafkaProducerTest {

  @RepeatedTest(2000)
  public void producer_whenPostData_sendsItToKafka() {

    RequestSpecBuilder specBuilder = new RequestSpecBuilder();
    specBuilder.setBaseUri("http://localhost:9000/send");

    // @formatter:off
    given()
        .spec(specBuilder.build())
    .when()
        .contentType(ContentType.TEXT)
        .body(String.format("some dummy text %d", Instant.now().toEpochMilli()))
        .post("/text-only")
    .then()
        .log().all()
        .statusCode(HttpURLConnection.HTTP_OK);
    // @formatter:on

  }

}
