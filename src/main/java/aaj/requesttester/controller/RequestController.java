package aaj.requesttester.controller;

import aaj.requesttester.dto.RequestDocumentResponse;
import aaj.requesttester.dto.RequestListDocumentResponse;
import aaj.requesttester.dto.Status;
import aaj.requesttester.service.RequestDocumentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@RestController
@ControllerAdvice
@RequestMapping("/v1/request")
public class RequestController {
  private final RequestDocumentService requestDocumentService;

  @Autowired
  public RequestController(RequestDocumentService requestDocumentService) {
    this.requestDocumentService = requestDocumentService;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<RequestDocumentResponse> doGet(HttpServletRequest httpServletRequest, @RequestParam String id) {
    log.warn("NEW REQUEST - HTTP GET request on resource mapping \"v1/request\" - IP: " + httpServletRequest.getHeader("X-FORWARDED-FOR"));
    Status status = Status.SUCCESS;
    RequestDocumentResponse response = new RequestDocumentResponse();
    response.setMessage(status.getCodeMessage());
    response.setStatus(status.getStatus());
    response.setResult(status.isResult());
    response.setRequestDocument(requestDocumentService.getRequestsById(id));
    return new ResponseEntity<>(response, status.getHttpStatus());
  }

  @GetMapping(value = "/list",produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<RequestListDocumentResponse> doListGet(HttpServletRequest httpServletRequest, @RequestParam String userId, @RequestParam(required = false) String endpoint) {
    log.warn("NEW REQUEST - HTTP GET request on resource mapping \"v1/request/list\" - IP: " + httpServletRequest.getHeader("X-FORWARDED-FOR"));
    Status status = Status.SUCCESS;
    RequestListDocumentResponse response = new RequestListDocumentResponse();
    response.setMessage(status.getCodeMessage());
    response.setStatus(status.getStatus());
    response.setResult(status.isResult());
    if (endpoint == null) {
      response.setRequestDocument(requestDocumentService.getAllRequestsByUserId(userId));
    } else {
      response.setRequestDocument(requestDocumentService.getAllRequestsByUserIdAndEndpoint(userId, endpoint));
    }
    return new ResponseEntity<>(response, status.getHttpStatus());
  }
}
