package aaj.requesttester.service;

import aaj.requesttester.domain.RequestDocument;

import java.util.ArrayList;

public interface RequestDocumentService  {
  ArrayList<RequestDocument> getAllRequestsByUserId(String userId);
  ArrayList<RequestDocument> getAllRequestsByUserIdAndEndpoint(String userId, String endpoint);

  RequestDocument getRequestsById(String id);
  void createRequest(RequestDocument requestDocument);
}
