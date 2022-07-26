package aaj.requesttester.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "endpoint_document")
public class EndpointDocument {
  protected String id;
  private String endpoint;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EndpointDocument that = (EndpointDocument) o;
    return Objects.equals(id, that.id) && Objects.equals(endpoint, that.endpoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, endpoint);
  }

  @Override
  public String toString() {
    return "EndpointDocument{" +
        "id='" + id + '\'' +
        ", endpoint='" + endpoint + '\'' +
        '}';
  }
}
