package aaj.requesttester.dto;

import aaj.requesttester.domain.EndpointDocument;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.io.Serializable;
import java.util.ArrayList;

public class EndpointDocumentResponse extends Response implements Serializable {
  @JsonAlias("EndpointDocument")
  EndpointDocument endpointDocument;

  public EndpointDocument getEndpointDocument() {
    return endpointDocument;
  }

  public void setEndpointDocument(EndpointDocument endpointDocument) {
    this.endpointDocument = endpointDocument;
  }

  @Override
  public String toString() {
    return "EndpointDocumentResponse{" +
        "endpointDocument=" + endpointDocument +
        ", status='" + status + '\'' +
        ", message='" + message + '\'' +
        "} " + super.toString();
  }
}
