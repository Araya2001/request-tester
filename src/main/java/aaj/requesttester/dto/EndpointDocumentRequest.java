package aaj.requesttester.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.io.Serializable;

public class EndpointDocumentRequest implements Serializable {
  @JsonAlias("Endpoint")
  String endpoint;

  public String getEndpoint() {
    return endpoint;
  }

  public void setEndpoint(String endpoint) {
    this.endpoint = endpoint;
  }
}
