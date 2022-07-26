package aaj.requesttester.service;

import aaj.requesttester.domain.RequestDocument;
import aaj.requesttester.repository.RequestDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RequestDocumentServiceImpl implements RequestDocumentService {
  private final RequestDocumentRepository requestDocumentRepository;

  @Autowired
  public RequestDocumentServiceImpl(RequestDocumentRepository requestDocumentRepository) {
    this.requestDocumentRepository = requestDocumentRepository;
  }

  @Override
  public ArrayList<RequestDocument> getAllRequestsByUserId(String userId) {
    return requestDocumentRepository.findAllByUserId(userId);
  }

  @Override
  public ArrayList<RequestDocument> getAllRequestsByUserIdAndEndpoint(String userId, String endpoint) {
    return requestDocumentRepository.findAllByUserIdAndEndpoint(userId, endpoint);
  }

  @Override
  public RequestDocument getRequestsById(String id) {
    return requestDocumentRepository.findAllById(id);
  }

  @Override
  public void createRequest(RequestDocument requestDocument) {
    requestDocumentRepository.save(requestDocument);
  }
}
