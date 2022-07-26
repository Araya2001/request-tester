package aaj.requesttester.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.io.Serializable;

public class RequestDocumentRequest implements Serializable {
  @JsonAlias("Endpoint")
  private String endpoint;
  @JsonAlias("Header")
  private String header;
  @JsonAlias("Body")
  private String body;
  @JsonAlias("UserId")
  private String userId;

  public String getEndpoint() {
    return endpoint;
  }

  public void setEndpoint(String endpoint) {
    this.endpoint = endpoint;
  }

  public String getHeader() {
    return header;
  }

  public void setHeader(String header) {
    this.header = header;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  @Override
  public String toString() {
    return "RequestDocumentRequest{" +
        "endpoint='" + endpoint + '\'' +
        ", header='" + header + '\'' +
        ", json='" + body + '\'' +
        ", userId='" + userId + '\'' +
        '}';
  }
}
