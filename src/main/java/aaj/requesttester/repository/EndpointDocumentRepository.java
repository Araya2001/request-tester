package aaj.requesttester.repository;

import aaj.requesttester.domain.EndpointDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface EndpointDocumentRepository extends MongoRepository<EndpointDocument, String> {
  ArrayList<EndpointDocument> findAll();
}
