package aaj.requesttester.service;

import aaj.requesttester.domain.EndpointDocument;
import aaj.requesttester.repository.EndpointDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EndpointDocumentServiceImpl implements EndpointDocumentService {

  private final EndpointDocumentRepository endpointDocumentRepository;

  @Autowired
  public EndpointDocumentServiceImpl(EndpointDocumentRepository endpointDocumentRepository) {
    this.endpointDocumentRepository = endpointDocumentRepository;
  }

  @Override
  public ArrayList<EndpointDocument> getAllEndpoints() {
    return endpointDocumentRepository.findAll();
  }

  @Override
  public void createEndpoint(EndpointDocument endpointDocument) {
    endpointDocumentRepository.save(endpointDocument);
  }
}
