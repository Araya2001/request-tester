package aaj.requesttester.dto;

import aaj.requesttester.domain.RequestDocument;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.io.Serializable;

public class RequestDocumentResponse extends Response implements Serializable {
  @JsonAlias("DocumentBody")
  RequestDocument requestDocument;

  public RequestDocument getRequestDocument() {
    return requestDocument;
  }

  public void setRequestDocument(RequestDocument requestDocument) {
    this.requestDocument = requestDocument;
  }

  @Override
  public String toString() {
    return "RequestDocumentResponse{" +
        "result=" + result +
        ", requestDocument=" + requestDocument +
        ", status='" + status + '\'' +
        ", message='" + message + '\'' +
        "} " + super.toString();
  }
}
