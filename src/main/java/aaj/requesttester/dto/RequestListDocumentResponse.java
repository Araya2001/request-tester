package aaj.requesttester.dto;

import aaj.requesttester.domain.RequestDocument;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.io.Serializable;
import java.util.ArrayList;

public class RequestListDocumentResponse extends Response implements Serializable {
  @JsonAlias("DocumentBody")
  ArrayList<RequestDocument> requestDocument;

  public ArrayList<RequestDocument> getRequestDocument() {
    return requestDocument;
  }

  public void setRequestDocument(ArrayList<RequestDocument> requestDocument) {
    this.requestDocument = requestDocument;
  }

  @Override
  public String toString() {
    return "RequestListDocumentResponse{" +
        "result=" + result +
        ", requestDocument=" + requestDocument +
        ", status='" + status + '\'' +
        ", message='" + message + '\'' +
        "} " + super.toString();
  }
}
