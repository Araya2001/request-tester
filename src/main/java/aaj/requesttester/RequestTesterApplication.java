package aaj.requesttester;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@PropertySource("classpath:${PROPERTY_FILE}.properties")
public class RequestTesterApplication {
  public static void main(String[] args) {
    SpringApplication.run(RequestTesterApplication.class, args);
  }
}
