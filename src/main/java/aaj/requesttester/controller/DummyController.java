package aaj.requesttester.controller;

import aaj.requesttester.domain.EndpointDocument;
import aaj.requesttester.domain.RequestDocument;
import aaj.requesttester.dto.Response;
import aaj.requesttester.dto.Status;
import aaj.requesttester.service.EndpointDocumentService;
import aaj.requesttester.service.RequestDocumentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.stream.Collectors;

@Log4j2
@RestController
@ControllerAdvice
@RequestMapping("/v1/dummy")
public class DummyController {
  private final RequestDocumentService requestDocumentService;
  private final EndpointDocumentService endpointDocumentService;

  @Autowired
  public DummyController(RequestDocumentService requestDocumentService, EndpointDocumentService endpointDocumentService) {
    this.requestDocumentService = requestDocumentService;
    this.endpointDocumentService = endpointDocumentService;
  }

  @PostMapping("/{path}")
  ResponseEntity<Response> doGet(HttpServletRequest httpServletRequest, @PathVariable String path, @RequestParam String userId) throws IOException {
    Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
    StringBuilder sb = new StringBuilder();
    if (headerNames != null) {
      while (headerNames.hasMoreElements()) {
        String headerName = headerNames.nextElement();
        sb.append(headerName);
        sb.append(" = ");
        sb.append(httpServletRequest.getHeader(headerName));
        sb.append(";\n");
      }
    }
    String builtHeaderString = sb.toString();
    log.warn("NEW REQUEST - HTTP GET request on resource mapping \"v1/\" - IP: " + httpServletRequest.getHeader("X-FORWARDED-FOR"));
    Status status = Status.SUCCESS;
    Response response = new Response() {
      @Override
      public boolean isResult() {
        return super.isResult();
      }

      @Override
      public void setResult(boolean result) {
        super.setResult(result);
      }

      @Override
      public String getStatus() {
        return super.getStatus();
      }

      @Override
      public void setStatus(String status) {
        super.setStatus(status);
      }

      @Override
      public String getMessage() {
        return super.getMessage();
      }

      @Override
      public void setMessage(String message) {
        super.setMessage(message);
      }

      @Override
      public String toString() {
        return super.toString();
      }
    };
    response.setMessage(status.getCodeMessage());
    response.setStatus(status.getStatus());
    response.setResult(status.isResult());
    RequestDocument requestDocument = new RequestDocument();
    requestDocument.setEndpoint(path);
    requestDocument.setHeader(builtHeaderString);
    requestDocument.setBody(httpServletRequest.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
    requestDocument.setUserId(userId);
    requestDocumentService.createRequest(requestDocument);
    return new ResponseEntity<>(response, status.getHttpStatus());
  }
}
