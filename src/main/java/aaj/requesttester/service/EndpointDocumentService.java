package aaj.requesttester.service;

import aaj.requesttester.domain.EndpointDocument;

import java.util.ArrayList;

public interface EndpointDocumentService {
  ArrayList<EndpointDocument> getAllEndpoints();
  void createEndpoint(EndpointDocument endpointDocument);
}
