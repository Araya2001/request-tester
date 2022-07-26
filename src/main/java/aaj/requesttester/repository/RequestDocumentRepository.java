package aaj.requesttester.repository;

import aaj.requesttester.domain.RequestDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface RequestDocumentRepository extends MongoRepository<RequestDocument, String> {
  ArrayList<RequestDocument> findAllByUserIdAndEndpoint(String username, String endpoint);
  ArrayList<RequestDocument> findAllByUserId(String username);

  RequestDocument findAllById(String id);
}
