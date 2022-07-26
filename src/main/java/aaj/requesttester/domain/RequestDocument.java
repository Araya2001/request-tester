package aaj.requesttester.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "request_document")
public class RequestDocument {
  protected String id;
  private String endpoint;
  private String header;
  private String body;

  private String userId;

  @Id
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

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
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequestDocument that = (RequestDocument) o;
    return Objects.equals(id, that.id) && Objects.equals(endpoint, that.endpoint) && Objects.equals(header, that.header) && Objects.equals(body, that.body);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, endpoint, header, body);
  }

  @Override
  public String toString() {
    return "RequestDocument{" +
        "id='" + id + '\'' +
        ", endpoint='" + endpoint + '\'' +
        ", header='" + header + '\'' +
        ", json='" + body + '\'' +
        '}';
  }
}
