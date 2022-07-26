package aaj.requesttester.controller;

import aaj.requesttester.domain.EndpointDocument;
import aaj.requesttester.dto.EndpointDocumentRequest;
import aaj.requesttester.dto.EndpointDocumentResponse;
import aaj.requesttester.dto.EndpointListDocumentResponse;
import aaj.requesttester.dto.Status;
import aaj.requesttester.service.EndpointDocumentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@RestController
@ControllerAdvice
@RequestMapping("/v1/endpoint")
public class EndpointController {
  private final EndpointDocumentService endpointDocumentService;

  @Autowired
  public EndpointController(EndpointDocumentService endpointDocumentService) {
    this.endpointDocumentService = endpointDocumentService;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<EndpointListDocumentResponse> doGet(HttpServletRequest httpServletRequest) {
    log.warn("NEW REQUEST - HTTP GET request on resource mapping \"v1/endpoint\" - IP: " + httpServletRequest.getHeader("X-FORWARDED-FOR"));
    Status status = Status.SUCCESS;
    EndpointListDocumentResponse response = new EndpointListDocumentResponse();
    response.setMessage(status.getCodeMessage());
    response.setStatus(status.getStatus());
    response.setResult(status.isResult());
    response.setEndpointDocument(endpointDocumentService.getAllEndpoints());
    return new ResponseEntity<>(response, status.getHttpStatus());
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<EndpointDocumentResponse> doGet(@RequestBody EndpointDocumentRequest endpointDocumentRequest, HttpServletRequest httpServletRequest) {
    log.warn("NEW REQUEST - HTTP POST request on resource mapping \"v1/endpoint\" - IP: " + httpServletRequest.getHeader("X-FORWARDED-FOR"));
    Status status = Status.SUCCESS;
    EndpointDocumentResponse response = new EndpointDocumentResponse();
    response.setMessage(status.getCodeMessage());
    response.setStatus(status.getStatus());
    response.setResult(status.isResult());
    EndpointDocument endpointDocument = endpointDocumentService.getAllEndpoints().stream().filter(e -> endpointDocumentRequest.getEndpoint().equals(e.getEndpoint())).findAny().orElse(null);
    if (endpointDocument == null) {
      endpointDocument = new EndpointDocument();
      endpointDocument.setEndpoint(endpointDocumentRequest.getEndpoint());
      endpointDocumentService.createEndpoint(endpointDocument);
    }
    response.setEndpointDocument(endpointDocument);
    return new ResponseEntity<>(response, status.getHttpStatus());
  }
}
